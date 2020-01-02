/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.partpartparttime.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*


//@Entity(tableName = "user_table",
//        foreignKeys = arrayOf(
//        ForeignKey(
//        entity = Applicant::class,
//        parentColumns = arrayOf("userID"),
//        childColumns = arrayOf("user_idd")),
//                ForeignKey(
//                        entity = Company::class,
//                        parentColumns = arrayOf("companyID"),
//                        childColumns = arrayOf("company_idd")),
//                ForeignKey(
//                        entity = Company::class,
//                        parentColumns = arrayOf("rateID"),
//                        childColumns = arrayOf("rate_idd"))
//))

@Entity(tableName = "user_table",
        foreignKeys =
        [ForeignKey(
                entity = Applicant::class,
                parentColumns = ["userID"],
                childColumns = ["user_idd"]),
        ForeignKey(
                entity = Company::class,
                parentColumns = ["companyID"],
                childColumns = ["company_idd"]),
        ForeignKey(
                entity = Rate::class,
                parentColumns = ["rateID"],
                childColumns = ["rate_idd"])])
data class User(
        @PrimaryKey
        @ColumnInfo(name = "userName")
        var userName: String,

        @ColumnInfo(name = "user_idd")
        var user_idd: Int,

        @ColumnInfo(name = "company_idd")
        var company_idd: Int,

        @ColumnInfo(name = "rate_idd")
        var rate_idd: Int,

        @ColumnInfo(name = "password")
        var password: String
)



//@Entity(tableName = "applicant_table",
//        foreignKeys = arrayOf(
//                ForeignKey(
//                        entity = Training::class,
//                        parentColumns = arrayOf("trainingID"),
//                        childColumns = arrayOf("training_idd")))
//)
@Entity(tableName = "applicant_table",
        foreignKeys =
        [ForeignKey(
                entity = Training::class,
                parentColumns = ["trainingID"],
                childColumns = ["training_idd"]),
                ForeignKey(
                        entity = PartimeJob::class,
                        parentColumns = ["pJobID"],
                        childColumns = ["pJob_idd"])])
data class Applicant(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "userID")
        var userID: Int = "A".toInt() + 1001,

        @ColumnInfo(name = "training_idd")
        var training_idd: Int,

        @ColumnInfo(name = "firstName")
        var firstName: Int,

        @ColumnInfo(name = "lastName")
        var lastName: Int,

        @ColumnInfo(name = "age")
        var age: Int,

        @ColumnInfo(name = "address")
        var address: Int,

        @ColumnInfo(name = "contact")
        var contact: Int,

        @ColumnInfo(name = "email")
        var email: Int,

        @ColumnInfo(name = "profilePic")
        var profilePic: Int,

        @ColumnInfo(name = "resume")
        var resume: Int
)



@Entity(tableName = "company_table",
        foreignKeys =
        [ForeignKey(
                entity = PartimeJob::class,
                parentColumns = ["pJobID"],
                childColumns = ["pJob_idd"]),
                ForeignKey(
                        entity = Event::class,
                        parentColumns = ["eventID"],
                        childColumns = ["event_idd"])])
data class Company(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "companyID")
        var companyID: Int = "C".toInt() + 1001,

        @ColumnInfo(name = "pJob_idd")
        var pJob_idd: Int,

        @ColumnInfo(name = "companyName")
        var companyName: String,

        @ColumnInfo(name = "address")
        var address: String,

        @ColumnInfo(name = "contact")
        var contact: String,

        @ColumnInfo(name = "email")
        var email: String,

        @ColumnInfo(name = "event_idd")
        var event_idd: Int
)



@Entity(tableName = "rate_table")
data class Rate(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "rateID")
        var rateID: Int = "R".toInt() + 1001,

        @ColumnInfo(name = "average")
        var average: Double
)



@Entity(tableName = "training_table",
        foreignKeys =
                [ForeignKey(
                        entity = TrainingOrganization::class,
                        parentColumns = ["organizationID"],
                        childColumns = ["organization_idd"])])
data class Training(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "trainingID")
        var trainingID: Int = "T".toInt() + 1001,

        @ColumnInfo(name = "organization_idd")
        var organization_idd: Int,

        @ColumnInfo(name = "trainingName")
        var trainingName: String,

        @ColumnInfo(name = "date")
        var date: Date
)


@Entity(tableName = "training_organization_table")
data class TrainingOrganization(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "organizationID")
        var organizationID: Int = "O".toInt() + 1001,

        @ColumnInfo(name = "organizationName")
        var organizationName: String,

        @ColumnInfo(name = "address")
        var address: String,

        @ColumnInfo(name = "contact")
        var contact: String,

        @ColumnInfo(name = "email")
        var email: String
)



@Entity(tableName = "partimeJob_table")
data class PartimeJob(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "pJobID")
        var pJobID: Int = "P".toInt() + 1001,

        @ColumnInfo(name = "jobPosition")
        var jobPosition: String,

        @ColumnInfo(name = "jobRequirement")
        var jobRequirement: String,

        @ColumnInfo(name = "salaryPerDay")
        var salaryPerDay: Int,

        @ColumnInfo(name = "duration")
        var duration: Date,

        @ColumnInfo(name = "cStatus")
        var cStatus: Boolean,

        @ColumnInfo(name = "aStatus")
        var aStatus: Boolean
)


@Entity(tableName = "event_table",
        foreignKeys =
        [ForeignKey(
                entity = Notic::class,
                parentColumns = ["noticID"],
                childColumns = ["notic_idd"])])
data class Event(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "eventID")
        var eventID: Int = "E".toInt() + 1001,

        @ColumnInfo(name = "notic_idd")
        var notic_idd: Int
)


@Entity(tableName = "notic_table")
data class Notic(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "noticID")
        var noticID: Int = "N".toInt() + 1001,

        @ColumnInfo(name = "date")
        var date: Date
)
