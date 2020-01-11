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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Applicant::class,Company::class,Event::class,PartimeJob::class,Training::class,Match::class,HistoryApplicant::class,HistoryCompany::class), version = 9, exportSchema = false)
abstract class PartimeDatabase : RoomDatabase() {


    abstract val applicantDao: ApplicantDao
    abstract val companyDao: CompanyDao
    abstract val eventDao: EventDao
    abstract val historyApplicantDao: HistoryApplicantDao
    abstract val historyCompanyDao: HistoryCompanyDao
    abstract val partimeJobDao: PartimeJobDao
    abstract val trainingDao: TrainingDao
    abstract val matchDao: MatchDao

    companion object {

        @Volatile
        private var INSTANCE: PartimeDatabase? = null

        fun getInstance(context: Context): PartimeDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            PartimeDatabase::class.java,
                            "part_time_database"
                    )
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}