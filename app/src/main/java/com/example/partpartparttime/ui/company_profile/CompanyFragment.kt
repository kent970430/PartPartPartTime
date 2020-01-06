package com.example.partpartparttime.ui.company_profile

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.MainActivity.Companion.loggedUser
import com.example.partpartparttime.MainActivity.Companion.name
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentCompanyBinding
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class CompanyFragment : Fragment() {

    private lateinit var companyViewModel: CompanyViewModel
    private var btn: Button? = null
    private var imageview: ImageView? = null
    private val GALLERY = 1
    private val CAMERA = 2
    private var uContact = ""
    private var uEmail = ""
    private var uAddress = ""
    private var uDescription = ""
    private var uJob = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCompanyBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_company, container, false
        )

        btn = binding.root.findViewById<View>(R.id.chooseimage) as Button
        imageview = binding.root.findViewById<View>(R.id.imageViewPreview2) as ImageView

        btn!!.setOnClickListener { showPictureDialog() }

        val application = requireNotNull(this.activity).application
        val dataSource = PartimeDatabase.getInstance(application).companyDao

        var comp: Company? = dataSource.getCompanyID(loggedUser)

        if (comp == null) {
            Toast.makeText(activity, R.string.login_failed, Toast.LENGTH_SHORT).show()
            Log.i("Result", "No user found")
        } else {
            val name: EditText = binding.root.findViewById(R.id.textName)
            name.setText(comp.companyName)

            val email: EditText = binding.root.findViewById(R.id.textEmaill)
            email.setText(comp.email)

            val contact: EditText = binding.root.findViewById(R.id.textDescription)
            contact.setText(comp.contact)

            val address: EditText = binding.root.findViewById(R.id.textDescription1)
            address.setText(comp.address)

            val description: EditText = binding.root.findViewById(R.id.textDescription2)
            description.setText(comp.details)

            val job: EditText = binding.root.findViewById(R.id.textDescription3)
            job.setText(comp.job)

            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
            headName.setText(MainActivity.name)
            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
            headEmail.setText(comp.email)

        }

        binding.buttonLogOut.setOnClickListener { view ->
            //            Log.i("Result", MainActivity.loggedUser)
            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()

            loggedUser = ""
            name = ""
            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
            headName.setText("")
            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
            headEmail.setText("")

            Log.i("Result", "Successfully logged out")


            view.findNavController().navigate(R.id.action_companyFragment_to_nav_home)
        }

        binding.buttonEdit.setOnClickListener { view ->
            val email: EditText = binding.root.findViewById(R.id.textEmaill)
            email.isEnabled = true

            val contact: EditText = binding.root.findViewById(R.id.textDescription)
            contact.isEnabled = true

            val address: EditText = binding.root.findViewById(R.id.textDescription1)
            address.isEnabled = true

            val description: EditText = binding.root.findViewById(R.id.textDescription2)
            description.isEnabled = true

            val job: EditText = binding.root.findViewById(R.id.textDescription3)
            job.isEnabled = true

            val chooseimage: Button = binding.root.findViewById(R.id.chooseimage)
            chooseimage.isVisible = true
        }

        binding.buttonSave.setOnClickListener { view ->
            uContact = binding.textDescription.text.toString()
            uEmail = binding.textEmaill.text.toString()
            uAddress = binding.textDescription1.text.toString()
            uDescription = binding.textDescription2.text.toString()
            uJob = binding.textDescription3.text.toString()

            if(comp != null) {
                comp.contact = uContact
                comp.email = uEmail
                comp.address = uAddress
                comp.details = uDescription
                comp.job = uJob

                dataSource.update(comp)
            }

            val email: EditText = binding.root.findViewById(R.id.textEmaill)
            email.isEnabled = false

            val contact: EditText = binding.root.findViewById(R.id.textDescription)
            contact.isEnabled = false

            val address: EditText = binding.root.findViewById(R.id.textDescription1)
            address.isEnabled = false

            val description: EditText = binding.root.findViewById(R.id.textDescription2)
            description.isEnabled = false

            val job: EditText = binding.root.findViewById(R.id.textDescription3)
            job.isEnabled = false

            val chooseimage: Button = binding.root.findViewById(R.id.chooseimage)
            chooseimage.isVisible = false
        }
        return binding.root
    }

    private fun showPictureDialog() {
        val pictureDialog = AlertDialog.Builder(this.context)
        pictureDialog.setTitle("Select Action")
        val pictureDialogItems = arrayOf("Select photo from gallery", "Capture photo from camera")
        pictureDialog.setItems(
            pictureDialogItems
        ) { dialog, which ->
            when (which) {
                0 -> choosePhotoFromGallary()
                1 -> takePhotoFromCamera()
            }
        }
        pictureDialog.show()
    }

    fun choosePhotoFromGallary() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        startActivityForResult(galleryIntent, GALLERY)
    }

    private fun takePhotoFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        /* if (resultCode == this.RESULT_CANCELED)
         {
         return
         }*/
        if (requestCode == GALLERY) {
            if (data != null) {
                val contentURI = data!!.data
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(
                        this.context!!.contentResolver,
                        contentURI
                    )
                    val path = saveImage(bitmap)
//                    Toast.makeText(this@MainActivity, "Image Saved!", Toast.LENGTH_SHORT).show()
                    imageview!!.setImageBitmap(bitmap)

                } catch (e: IOException) {
                    e.printStackTrace()
//                    Toast.makeText(this@MainActivity, "Failed!", Toast.LENGTH_SHORT).show()
                }

            }

        } else if (requestCode == CAMERA) {
            val thumbnail = data!!.extras!!.get("data") as Bitmap
            imageview!!.setImageBitmap(thumbnail)
            saveImage(thumbnail)
//            Toast.makeText(this@MainActivity, "Image Saved!", Toast.LENGTH_SHORT).show()
        }
    }

    fun saveImage(myBitmap: Bitmap): String {
        val bytes = ByteArrayOutputStream()
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
        val wallpaperDirectory = File(
            (Environment.getExternalStorageState()).toString() + MainActivity.IMAGE_DIRECTORY
        )
        // have the object build the directory structure, if needed.
        Log.d("fee", wallpaperDirectory.toString())
        if (!wallpaperDirectory.exists()) {

            wallpaperDirectory.mkdirs()
        }

        try {
            Log.d("heel", wallpaperDirectory.toString())
            val f = File(
                wallpaperDirectory, ((Calendar.getInstance()
                    .getTimeInMillis()).toString() + ".jpg")
            )
            f.createNewFile()
            val fo = FileOutputStream(f)
            fo.write(bytes.toByteArray())
            MediaScannerConnection.scanFile(
                this.context,
                arrayOf(f.getPath()),
                arrayOf("image/jpeg"), null
            )
            fo.close()
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath())

            return f.getAbsolutePath()
        } catch (e1: IOException) {
            e1.printStackTrace()
        }

        return ""
    }
}