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

@Entity(tableName = "applicant_table"
)
data class Applicant(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "userID")
        var userID: Int = "A".toInt() + 1001,

        @ColumnInfo(name = "training_idd")
        var training_idd: Int,

        @ColumnInfo(name = "firstName")
        var firstName: String,

        @ColumnInfo(name = "lastName")
        var lastName: String,

        @ColumnInfo(name = "age")
        var age: Int,

        @ColumnInfo(name = "address")
        var address: String,

        @ColumnInfo(name = "contact")
        var contact: String,

        @ColumnInfo(name = "email")
        var email: String,

        @ColumnInfo(name = "profilePic")
        var profilePic: String,

        @ColumnInfo(name = "resume")
        var resume: String
)

