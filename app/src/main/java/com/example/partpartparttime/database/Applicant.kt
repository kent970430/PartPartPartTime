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

@Entity(
    tableName = "applicant_table"
)
data class Applicant(
    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "userName")
    var userName: String = "",

    @ColumnInfo(name = "password")
    var password: String = "",

    @ColumnInfo(name = "userID")
    var userID: String = "",

    @ColumnInfo(name = "firstName")
    var firstName: String = "",

    @ColumnInfo(name = "lastName")
    var lastName: String= "",

    @ColumnInfo(name = "contact")
    var contact: String= "",

    @ColumnInfo(name = "email")
    var email: String= "",

    @ColumnInfo(name = "experience")
    var experince: String= "",

    @ColumnInfo(name = "skill")
    var skill: String= "",

    @ColumnInfo(name = "education")
    var education: String= ""

//    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
//    var data: ByteArray? = null,
)

