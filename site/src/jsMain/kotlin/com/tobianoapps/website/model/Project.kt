package com.tobianoapps.website.model

import com.tobianoapps.website.util.Res


sealed class Project(
    val title: String,
    val subtitles: List<String>,
    val imageSrc: String,
    val projectFeatures: List<ProjectFeature>,
    val badges: List<StoreBadge>
) {
    data object TimeRise : Project(
        title = Res.String.TIME_RISE_TITLE,
        subtitles = listOf(Res.String.TIME_RISE_SUBTITLE),
        imageSrc = Res.Image.TIME_RISE,
        projectFeatures = listOf(
            ProjectFeature(
                title = "★ Best Kitchen Timer Apps ★",
                url = "https://freeappsforme.com/kitchen-timer-apps"
            ),
            ProjectFeature(
                title = "★ Featured on Android Headlines ★",
                url = "https://www.androidheadlines.com/2022/05/time-rise-android-app.html"
            ),
            ProjectFeature(
                title = "★ Featured on Android Police ★",
                url = "https://www.androidpolice.com/2021/04/24/12-new-and-notable-android-apps-and-live-wallpapers-from-the-last-three-weeks-including-weatherback-wallpaper-microsoft-edge-canary-and-sketch-360-4-3-21-4-24-21/#time-rise"
            )
        ), badges = listOf(
            StoreBadge(
                imageUri = Res.Image.GOOGLE_PLAY_BADGE,
                url = Res.String.TIME_RISE_GOOGLE_PLAY_URL
            )
        )
    )

    data object SunnySide : Project(
        title = Res.String.SUNNY_SIDE_TITLE,
        subtitles = listOf(Res.String.SUNNY_SIDE_SUBTITLE_1, Res.String.SUNNY_SIDE_SUBTITLE_2),
        imageSrc = Res.Image.SUNNY_SIDE,
        projectFeatures = listOf(
            ProjectFeature(
                title = "★ 19 Best Weather Apps ★",
                url = "https://androidappsforme.com/weather-apps-for-android/"
            ),
            ProjectFeature(
                title = "★ Featured on Android Police ★",
                url = "https://www.androidpolice.com/2021/07/03/14-new-and-notable-android-apps-from-the-last-two-weeks-including-stadia-for-android-tv-elabels-and-zoom-for-chrome-6-19-21-7-3-21/#sunny-side"
            )
        ), badges = listOf(
            StoreBadge(
                imageUri = Res.Image.GOOGLE_PLAY_BADGE,
                url = Res.String.SUNNY_SIDE_GOOGLE_PLAY_URL
            )
        )
    )

    data object LakeAndCoast : Project(
        title = Res.String.LAKE_AND_COAST_TITLE,
        subtitles = listOf(Res.String.LAKE_AND_COAST_SUBTITLE),
        imageSrc = Res.Image.LAKE_AND_COAST,
        projectFeatures = emptyList(),
        badges = listOf(
            StoreBadge(
                imageUri = Res.Image.APP_STORE_BADGE,
                url = Res.String.LAKE_AND_COAST_APP_STORE_URL
            ),
            StoreBadge(
                imageUri = Res.Image.GOOGLE_PLAY_BADGE,
                url = Res.String.LAKE_AND_COAST_GOOGLE_PLAY_URL
            )
        )
    )

    companion object {
        val all = listOf(SunnySide, TimeRise, LakeAndCoast)
    }
}