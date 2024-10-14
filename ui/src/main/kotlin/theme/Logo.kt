package theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import com.example.androidsdkdemo.ui.R

@Composable
fun Logo() {
    Box(
        Modifier
            .padding(WindowInsets.statusBars.asPaddingValues())
            .fillMaxWidth()

    ) {
        Image(
            painterResource(R.drawable.logo),
            contentDescription = "Permutive Logo",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .testTag("logo")
        )
    }
}