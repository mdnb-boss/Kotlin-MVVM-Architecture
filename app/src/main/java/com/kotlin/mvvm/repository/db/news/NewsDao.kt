package com.kotlin.mvvm.repository.db.news

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlin.mvvm.repository.model.news.News

/**
 * Created by Waheed on 04,November,2019
 */

/**
 * Abstracts access to the news database
 */
@Dao
abstract class NewsDao {

    /**
     * Insert articles into the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertArticles(articles: List<News>)

    /**
     * Get all the articles from database
     */
    @Query("SELECT * FROM news_table")
    abstract suspend fun getNewsArticles(): List<News>

    @Query("DELETE FROM news_table")
    abstract suspend fun deleteAllArticles()
}