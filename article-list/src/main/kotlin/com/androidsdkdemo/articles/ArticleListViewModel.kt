package com.androidsdkdemo.articles

import Article
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidsdkdemo.data.PublisherContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tracking.EventTrackerUseCase
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val repository: PublisherContentRepository,
    private val eventTrackerUseCase: EventTrackerUseCase
) : ViewModel() {

    companion object {
        const val TAG = "ArticleListViewModel"
    }

    private val _articles: MutableStateFlow<List<Article>> = MutableStateFlow(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    fun getArticles(context: Context) {
        viewModelScope.launch {
            _articles.value = repository.getArticles(context)
        }
    }

    fun onDestroy() {
        eventTrackerUseCase.close()
    }

    fun trackPageView() {
        eventTrackerUseCase.track(title = "Headlines")
    }
}