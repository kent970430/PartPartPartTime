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


@Entity(tableName = "company_table"
)
data class Company(
        @PrimaryKey(autoGenerate = true)
        var num: Long = 0L,

        @ColumnInfo(name = "userName")
        var userName: String? = null,

        @ColumnInfo(name = "password")
        var password: String? = null,

        @ColumnInfo(name = "companyID")
        var companyID: String? = null,

        @ColumnInfo(name = "companyName")
        var companyName: String? = null,

        @ColumnInfo(name = "address")
        var address: String? = null,

        @ColumnInfo(name = "contact")
        var contact: String? = null,

        @ColumnInfo(name = "email")
        var email: String? = null,

        @ColumnInfo(name = "details")
        var details: String? = null,

        @ColumnInfo(name = "job")
        var job: String? = null,

        @ColumnInfo(name = "image")
        var image: String? = null,

        @ColumnInfo(name = "category")
        var category: String? = null
)
