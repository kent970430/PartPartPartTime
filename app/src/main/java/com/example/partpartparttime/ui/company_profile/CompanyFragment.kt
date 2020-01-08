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
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.partpartparttime.MainActivity
import com.example.partpartparttime.MainActivity.Companion.loggedUser
import com.example.partpartparttime.MainActivity.Companion.name
import com.example.partpartparttime.R
import com.example.partpartparttime.database.Applicant
import com.example.partpartparttime.database.Company
import com.example.partpartparttime.database.PartimeDatabase
import com.example.partpartparttime.databinding.FragmentCompanyBinding
import com.example.partpartparttime.ui.events.EventFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_company.*
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
        val userSourse = PartimeDatabase.getInstance(application).applicantDao

        var comp: Company? = dataSource.getCompanyID(loggedUser)
        var userrr: Applicant? = userSourse.getApplicantID(loggedUser)

        var evenn = EventFragment()
        var userss = evenn.users
        var comp1: Company? = dataSource.getCompanyID(userss)

        if (comp == null) {
            if(userrr == null) {
                Toast.makeText(activity, R.string.get_failed, Toast.LENGTH_SHORT).show()
                Log.i("Result", "No company found")
            } else {
                buttonEdit.hidee(false)
                buttonSave.hidee(false)
                buttonLogOut.hidee(false)
                val name:EditText = binding.root.findViewById(R.id.textName)
                if (comp1 != null) {
                    name.setText(comp1.companyName)
                }

                val email: EditText = binding.root.findViewById(R.id.textEmaill)
                if (comp1 != null) {
                    email.setText(comp1.email)
                }

                val contact: EditText = binding.root.findViewById(R.id.textDescription)
                if (comp1 != null) {
                    contact.setText(comp1.contact)
                }

                val address: EditText = binding.root.findViewById(R.id.textDescription1)
                if (comp1 != null) {
                    address.setText(comp1.address)
                }

                val description: EditText = binding.root.findViewById(R.id.textDescription2)
                if (comp1 != null) {
                    description.setText(comp1.details)
                }

                val job: EditText = binding.root.findViewById(R.id.textDescription3)
                if (comp1 != null) {
                    job.setText(comp1.job)
                }

                val image: ImageView = binding.root.findViewById(R.id.imageViewPreview2)
                val imageV = comp1?.image.toString().toUri()
                image.setImageURI(imageV)

                val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
                headName.setText(MainActivity.name)
                val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
                if (comp1 != null) {
                    headEmail.setText(comp1.email)
                }
                val imageView : ImageView = this.getActivity()!!.findViewById(R.id.imageView)
                imageView.setImageURI(imageV)
            }
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

            val image: ImageView = binding.root.findViewById(R.id.imageViewPreview2)
            val imageV = comp.image.toString().toUri()
            image.setImageURI(imageV)

            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
            headName.setText(MainActivity.name)
            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
            headEmail.setText(comp.email)
            val imageView : ImageView = this.getActivity()!!.findViewById(R.id.imageView)
            imageView.setImageURI(imageV)

        }

        val navView: NavigationView = activity!!.findViewById(R.id.nav_view)

        val headerView = navView.menu.getItem(3)
        headerView.isVisible = true

        binding.buttonLogOut.setOnClickListener { view ->

            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()

            loggedUser = ""
            name = ""
            val headName: TextView = this.getActivity()!!.findViewById(R.id.head_name)
            headName.setText(R.string.nav_header_title)
            val headEmail: TextView = this.getActivity()!!.findViewById(R.id.head_email)
            headEmail.setText(R.string.nav_header_subtitle)
            val imageView : ImageView = this.getActivity()!!.findViewById(R.id.imageView)
            imageView.setImageResource(R.mipmap.ic_launcher)

            Toast.makeText(activity, "Successfully logged out", Toast.LENGTH_SHORT).show()
            Log.i("Result", "Successfully logged out")

            val navView: NavigationView = activity!!.findViewById(R.id.nav_view)

            navView.menu.getItem(3).isVisible = false

            navView.menu.getItem(4).isVisible = true


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

            if (comp != null) {
                comp.contact = uContact
                comp.email = uEmail
                comp.address = uAddress
                comp.details = uDescription
                comp.job = uJob
                comp.image = MainActivity.imagePath

                dataSource.update(comp)
            }

            val imageView : ImageView = this.getActivity()!!.findViewById(R.id.imageView)
            imageView.setImageURI(MainActivity.imagePath!!.toUri())

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY) {
            if (data != null) {
                val contentURI = data!!.data
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(
                        this.context!!.contentResolver,
                        contentURI
                    )
                    val path = saveImage(bitmap)
                    imageview!!.setImageBitmap(bitmap)

                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }

        } else if (requestCode == CAMERA) {
            val thumbnail = data!!.extras!!.get("data") as Bitmap
            imageview!!.setImageBitmap(thumbnail)
            saveImage(thumbnail)
        }
    }

    private fun saveImage(finalBitmap: Bitmap): String {

        val root = Environment.getExternalStorageDirectory().toString()
        val myDir = File(root + "/capture_photo")
        myDir.mkdirs()
        val generator = Random()
        var n = 10000
        n = generator.nextInt(n)
        val OutletFname = "Image-$n.jpg"
        val file = File(myDir, OutletFname)
        if (file.exists()) file.delete()
        try {
            val out = FileOutputStream(file)
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
            MainActivity.imagePath = file.absolutePath
            out.flush()
            out.close()
        } catch (e: Exception) {
            e.printStackTrace()

        }
        return MainActivity.imagePath.toString()
    }

    fun View.hidee(show: Boolean) {
        visibility = if(show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}