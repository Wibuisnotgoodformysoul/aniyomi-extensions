package eu.kanade.tachiyomi.animeextension.pt.animeyabu.extractors

import eu.kanade.tachiyomi.animeextension.pt.animeyabu.AYConstants
import eu.kanade.tachiyomi.animesource.model.Video

class PlayerOneExtractor {

    private val PREFIX = "Player 1"

    fun videoListFromHtml(html: String): List<Video> {
        return AYConstants.PLAYER_REGEX.findAll(html).map { it ->
            val quality = "$PREFIX (${it.groupValues[1]})"
            val videoUrl = it.groupValues[2]
            Video(videoUrl, quality, videoUrl, null)
        }.toList()
    }
}
