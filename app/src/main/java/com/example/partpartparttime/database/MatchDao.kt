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
interface MatchDao {

    @Insert
    fun insert(match: Match)

    @Update
    fun update(match: Match?)

    @Query("SELECT * from match_table WHERE companyID = :key")
    fun getUserId(key: String): Match?

    @Query("SELECT * from match_table WHERE companyID = :key AND userID = :key1 AND usermatchcompany = :key2")
    fun getAppliedApplicant(key: String, key1: String, key2: String): LiveData<List<Match>>

    @Query("SELECT * from match_table WHERE companyID = :key AND userID = :key1 AND usermatchcompany = :key2")
    fun getAppliedApplicant1(key: String, key1: String, key2: String): Match?

//    @Query("SELECT * from match_table WHERE companyID = :key AND userID = :key1 AND companymatchuser = :key2 AND usermatchcompany = :key3 ")
//    fun getMatchedCompanyandUser(key: String, key1: String, key2: String, key3: String): Match?


}