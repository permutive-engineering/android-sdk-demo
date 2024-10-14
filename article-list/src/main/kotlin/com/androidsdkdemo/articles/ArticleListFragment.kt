package com.androidsdkdemo.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.androidsdkdemo.articles.list.R
import com.androidsdkdemo.articles.ui.ArticleList
import dagger.hilt.android.AndroidEntryPoint
import ui.theme.AndroidSDKDemoTheme

@AndroidEntryPoint
class ArticleListFragment : Fragment() {

    companion object {
        const val TAG = "ArticleListFragment"
        const val NAVIGATION_PARAM_ARTICLE_ID = "articleId"
    }

    private val viewModel by viewModels<ArticleListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getArticles(this.requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                AndroidSDKDemoTheme(dynamicColor = false) {
                    ArticleList(
                        articles = viewModel.articles.collectAsState().value,
                        onArticleSelected = { navigateToArticle(it) }
                    )
                }
            }
            viewModel.trackPageView()
            super.onCreate(savedInstanceState)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun navigateToArticle(id: String) {
        val bundle = bundleOf(NAVIGATION_PARAM_ARTICLE_ID to id)
        findNavController().navigate(R.id.articleFragment, bundle)
    }
}
