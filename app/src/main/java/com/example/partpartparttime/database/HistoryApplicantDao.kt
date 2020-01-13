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

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HistoryApplicantDao {

    @Insert
    fun insert(history_applicant: HistoryApplicant)

    @Update
    fun update(history_applicant: HistoryApplicant)

    @Query("SELECT * from history_applicant_table WHERE companyID = :key")
    fun getUserId(key: String): LiveData<List<HistoryApplicant>>

    @Query("SELECT * from history_applicant_table WHERE userID = :key ORDER BY history_appID DESC ")
    fun getAllHistory(key: String): LiveData<List<HistoryApplicant>>

    @Query("SELECT * from history_applicant_table WHERE companyID = :key ORDER BY history_appID DESC ")
    fun getAllHistorys(key: String): LiveData<List<HistoryApplicant>>

    @Query("SELECT * from history_applicant_table WHERE userID = :key  ")
    fun getAllHistoryss(key: String): HistoryApplicant?

}