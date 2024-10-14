package com.androidsdkdemo.articles.ui

import Article
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidsdkdemo.ui.R
import theme.Logo
import ui.theme.AndroidSDKDemoTheme

@Composable
fun ArticleList(articles: List<Article>, onArticleSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.background,
                        MaterialTheme.colorScheme.surfaceVariant
                    )
                )
            )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Logo()
            Articles(articles, Modifier, onArticleSelected)
        }
    }
}

@Composable
private fun Articles(
    articles: List<Article>,
    modifier: Modifier,
    onArticleSelected: (String) -> Unit
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .testTag("articles"),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        articles.forEachIndexed { index, article ->
            Article(article, index, Modifier, onArticleSelected)
        }
    }
}

@Composable
fun Article(article: Article, index: Int, modifier: Modifier, onArticleSelected: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .clickable { onArticleSelected(article.id) }
            .testTag("article_$index")
    ) {
        Row(
            modifier
                .padding(horizontal = 30.dp, vertical = 15.dp)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = modifier.testTag("title")
                )
                Text(
                    text = article.description,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = modifier.testTag("description")
                )
            }
            Image(
                painter = painterResource(R.drawable.article_image),
                contentDescription = "Article Image",
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    AndroidSDKDemoTheme {
        ArticleList(
            listOf(
                Article(
                    "119",
                    "New AI technology released",
                    "A new long-awaited AI technology has been released at last.",
                    "assets/article_image.png"
                )
            )
        ) { }
    }
}