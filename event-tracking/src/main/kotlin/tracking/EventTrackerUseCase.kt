package tracking

import android.annotation.SuppressLint
import android.net.Uri
import com.permutive.android.EventProperties
import com.permutive.android.PageTracker
import com.permutive.android.Permutive
import javax.inject.Inject

class EventTrackerUseCase @Inject constructor(
    private val permutive: Permutive
) {

    private lateinit var tracker: PageTracker

    @SuppressLint("CheckResult")
    fun track(
        ispInfo: String = "isp_info",
        geoInfo: String = "geo_info",
        ipAddress: String = "ip_address",
        title: String
    ) {
        tracker = permutive.trackPage(
            EventProperties.from(
                ispInfo to EventProperties.ISP_INFO,
                geoInfo to EventProperties.GEO_INFO,
                ipAddress to EventProperties.IP_ADDRESS_HASH,
            ),
            title = title,
            url = Uri.parse("https://androidtest.com/"),
        )
    }

    fun updatePercentageViewed(scrollValue: Int, max: Int) {
        val percentage =
            (scrollValue.toFloat() / max.toFloat())
        tracker.updatePercentageViewed(percentage)
    }

    fun close() {
        tracker.close()
    }
}