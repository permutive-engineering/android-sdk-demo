package com.androidsdkdemo.article

import ArticleDetail
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidsdkdemo.ui.R
import theme.Logo
import ui.theme.AndroidSDKDemoTheme

@Composable
fun Article(article: ArticleDetail, onScroll: (scrollValue: Int, max: Int) -> Unit) {
    Box(
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
            Article(onScroll, article)
        }
    }
}

@Composable
private fun Article(onScroll: (scrollValue: Int, max: Int) -> Unit, article: ArticleDetail) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        val scrollState = rememberScrollState()
        LaunchedEffect(scrollState) {
            snapshotFlow { scrollState.isScrollInProgress }
                .collect {
                    if (scrollState.maxValue.toFloat() > 0f) {
                        onScroll(scrollState.value, scrollState.maxValue)
                    }
                }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
            )
            Image(
                painter = painterResource(R.drawable.article_image),
                contentDescription = "Article Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = article.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    AndroidSDKDemoTheme {
        Article(
            ArticleDetail(
                "119",
                "New AI technology released",
                "A new long-awaited AI technology has been released at last." +
                        "A new long-awaited AI technology has been released at last." +
                        "A new long-awaited AI technology has been released at last." +
                        "A new long-awaited AI technology has been released at last.",
            )
        ) { _, _ -> }
    }
}