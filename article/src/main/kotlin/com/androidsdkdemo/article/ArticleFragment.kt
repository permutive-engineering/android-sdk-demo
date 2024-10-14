package com.androidsdkdemo.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ui.theme.AndroidSDKDemoTheme

@AndroidEntryPoint
class ArticleFragment : Fragment() {

    private val viewModel by viewModels<ArticleViewModel>()
    private val articleId by lazy { arguments?.getString("articleId") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getArticle(this.requireContext(), articleId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AndroidSDKDemoTheme(dynamicColor = false) {
                    viewModel.article.collectAsState().value?.let { article ->
                        Article(
                            article = article,
                            onScroll = { scrollValue, max ->
                                viewModel.onScroll(
                                    scrollValue = scrollValue,
                                    max = max
                                )
                            })
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.trackPageView()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
}