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

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Data manager class that handles data manipulation between the database and the UI.
 */

@Singleton
class JokesLocalDataSource @Inject constructor(private val jokesDao: JokesDao) {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    fun addJoke(msg: String) {
        executorService.execute {
            jokesDao.insertAll(
                Jokes(
                    msg,
                    System.currentTimeMillis()
                )
            )
        }
    }

    fun getAllJokes(callback: (List<Jokes>) -> Unit) {
        executorService.execute {
            val logs = jokesDao.getAll()
            mainThreadHandler.post { callback(logs) }
        }
    }

    fun removeLogs() {
        executorService.execute {
            jokesDao.nukeTable()
        }
    }
}
