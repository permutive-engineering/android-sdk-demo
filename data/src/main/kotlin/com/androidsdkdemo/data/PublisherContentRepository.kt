package com.androidsdkdemo.data

import Article
import ArticleDetail
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import javax.inject.Inject

class PublisherContentRepository @Inject constructor() {

    companion object {
        const val TAG = "PublisherContentRepository"
    }

    private val articles = "articles.json"
    private val article = "article_detail.json"

    fun getArticles(context: Context): List<Article> =
        try {
            val inputStream = context.assets.open(articles)
            val reader = InputStreamReader(inputStream)
            val gson = Gson()
            val listType = object : TypeToken<List<Article>>() {}.type
            gson.fromJson(reader, listType)
        } catch (e: Exception) {
            Log.e(TAG, "Error reading JSON file: ${e.message}")
            emptyList()
        }

    fun getArticle(context: Context, id: String): ArticleDetail {
        val articles = getArticleDetails(context)
        return articles.first { it.id == id }
    }

    private fun getArticleDetails(context: Context): List<ArticleDetail> =
        try {
            val inputStream = context.assets.open(article)
            val reader = InputStreamReader(inputStream)
            val gson = Gson()
            val listType = object : TypeToken<List<ArticleDetail>>() {}.type
            gson.fromJson(reader, listType)
        } catch (e: Exception) {
            Log.e(TAG, "Error reading JSON file: ${e.message}")
            emptyList()
        }
}