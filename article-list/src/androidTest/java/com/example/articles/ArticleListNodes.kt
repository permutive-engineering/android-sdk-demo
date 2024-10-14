package com.example.articles

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag

class ArticleListNodes(
    val rule: ComposeContentTestRule
) {

    val logo = rule.onNodeWithTag("logo")
    val title = rule.onNodeWithTag("title", useUnmergedTree = true)
    val description = rule.onNodeWithTag("description", useUnmergedTree = true)
    fun article(atIndex: Int) = rule.onNodeWithTag("article_$atIndex")

}