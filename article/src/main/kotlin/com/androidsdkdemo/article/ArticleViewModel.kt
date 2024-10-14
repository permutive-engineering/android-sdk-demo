package com.androidsdkdemo.article

import ArticleDetail
import android.content.Context
import androidx.lifecycle.ViewModel
import com.androidsdkdemo.data.PublisherContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import tracking.EventTrackerUseCase
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val repository: PublisherContentRepository,
    private val eventTrackerUseCase: EventTrackerUseCase
) : ViewModel() {

    private val _article: MutableStateFlow<ArticleDetail?> = MutableStateFlow(null)
    val article: StateFlow<ArticleDetail?> = _article

    fun getArticle(context: Context, id: String?) {
        _article.value = id?.let { repository.getArticle(context, id) }
    }

    fun onDestroy() {
        eventTrackerUseCase.close()
    }

    fun trackPageView() {
        eventTrackerUseCase.track(title = article.value?.title.orEmpty())
    }

    fun onScroll(scrollValue: Int, max: Int) {
        eventTrackerUseCase.updatePercentageViewed(scrollValue, max)
    }
}