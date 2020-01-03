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
        var duration: String,

        @ColumnInfo(name = "cStatus")
        var cStatus: Boolean,

        @ColumnInfo(name = "aStatus")
        var aStatus: Boolean
)