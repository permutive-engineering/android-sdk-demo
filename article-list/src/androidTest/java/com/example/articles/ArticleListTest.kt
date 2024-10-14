package com.example.articles

import Article
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import com.androidsdkdemo.articles.ui.ArticleList
import org.junit.Rule
import org.junit.Test
import ui.theme.AndroidSDKDemoTheme

class ArticleListTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val nodes = ArticleListNodes(composeTestRule)

    @Test
    fun no_content_is_displayed_when_no_articles_exist() {
        composeTestRule.setContent {
            AndroidSDKDemoTheme {
                ArticleList(articles = emptyList(), onArticleSelected = {})
            }
        }

        nodes.logo.assertIsDisplayed()
        nodes.title.assertIsNotDisplayed()
        nodes.description.assertIsNotDisplayed()
    }

    @Test
    fun content_is_displayed_when_articles_exist() {
        composeTestRule.setContent {
            AndroidSDKDemoTheme {
                ArticleList(
                    articles =
                        listOf(
                            Article(
                                "119",
                                "New AI technology released",
                                "A new long-awaited AI technology has been released at last.",
                                "assets/article_image.png",
                            ),
                        ),
                    onArticleSelected = {},
                )
            }
        }

        nodes.article(0).assertIsDisplayed()
        nodes.logo.assertIsDisplayed()
        nodes.title.assertIsDisplayed()
        nodes.description.assertIsDisplayed()
    }

    @Test
    fun when_article_selected_then_app_navigates_to_details() {
        composeTestRule.setContent {
            AndroidSDKDemoTheme {
                ArticleList(
                    articles =
                        listOf(
                            Article(
                                "119",
                                "New AI technology released",
                                "A new long-awaited AI technology has been released at last.",
                                "assets/article_image.png",
                            ),
                        ),
                    onArticleSelected = {},
                )
            }
        }

        nodes.article(atIndex = 0).assertIsDisplayed()
        nodes.article(atIndex = 0).performClick()
    }
}
