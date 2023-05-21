/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.ponkratovaelizaveta.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Data access object to query the database.
 */
@Dao
interface JokesDao {

    @Query("SELECT * FROM jokes ORDER BY id DESC")
    fun getAll(): List<Jokes>

    @Insert
    fun insertAll(vararg jokes: Jokes)

    @Insert
    fun insert(joke: Jokes)

    @Query("DELETE FROM jokes")
    fun nukeTable()

    //delete from marks
    //order by id desc limit 1
    @Query("DELETE FROM jokes WHERE id = (SELECT MIN(id) FROM jokes)")
    fun deleteLastEntry()
}
