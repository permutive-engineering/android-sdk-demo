data class Articles(
    val articles: List<Article>
)

data class Article(
    val id: String,
    val title: String,
    val description: String,
    val imagePath: String
)
