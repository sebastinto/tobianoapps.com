package com.tobianoapps.website.util

import com.tobianoapps.website.util.Utils.capitalized
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlin.js.Date

object Res {
    enum class Theme(val color: Color) {
        BODY_TEXT_LIGHT(color = Colors.Black),
        BODY_TEXT_DARK(color = Color.rgb(r = 221, g = 221, b = 221)),
        BACKGROUND_LIGHT(color = Colors.White),
        BACKGROUND_DARK(color = Color.rgb(r = 25, g = 25, b = 25)),
        BORDER_LIGHT(color = Color.rgb(r = 230, g = 230, b = 230)),
        BORDER_DARK(color = Color.rgb(r = 50, g = 50, b = 50)),
        LINK_DEFAULT_LIGHT(color = Color.rgb(0xDF3030)),
        LINK_DEFAULT_DARK(color = Color.rgb(0xEF6C6C)),
        THEME_SWITCH_BACKGROUND_LIGHT(color = BACKGROUND_LIGHT.color),
        THEME_SWITCH_BACKGROUND_DARK(color = BORDER_DARK.color),
        THEME_SWITCH_HOVER_BACKGROUND_LIGHT(color = LINK_DEFAULT_LIGHT.color.lightened(.85f)),
        THEME_SWITCH_HOVER_BACKGROUND_DARK(color = LINK_DEFAULT_DARK.color.darkened(.6f));

        companion object {
            fun ColorMode.themeSwitchHoverBackground() =
                if (isLight) Res.Theme.THEME_SWITCH_HOVER_BACKGROUND_LIGHT.color
                else Res.Theme.THEME_SWITCH_HOVER_BACKGROUND_DARK.color

            fun ColorMode.themeSwitchBackgroundBackground() =
                if (isLight) Res.Theme.THEME_SWITCH_BACKGROUND_LIGHT.color
                else Res.Theme.THEME_SWITCH_BACKGROUND_DARK.color
        }
    }

    object String {
        fun getCopyright() = "© " + "${Date().getFullYear()}," + " ${TOBIANO_APPS.capitalized()}"

        const val TOBIANO_APPS = "tobiano apps"

        const val TIME_RISE_TITLE = "Time Rise"
        const val TIME_RISE_SUBTITLE = "Minimal Digital Hourglass"
        const val TIME_RISE_GOOGLE_PLAY_URL =
            "https://play.google.com/store/apps/details?id=com.tobianoapps.timerise&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1"

        const val SUNNY_SIDE_TITLE = "Sunny Side"
        const val SUNNY_SIDE_SUBTITLE_1 = "UV index"
        const val SUNNY_SIDE_SUBTITLE_2 = "UV protection guidelines"
        const val SUNNY_SIDE_GOOGLE_PLAY_URL =
            "https://play.google.com/store/apps/details?id=com.tobianoapps.sunnyside&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1"

        const val LAKE_AND_COAST_TITLE = "Lake & Coast"
        const val LAKE_AND_COAST_SUBTITLE = "Pontchartrain Conservancy Water Quality Program"
        const val LAKE_AND_COAST_GOOGLE_PLAY_URL =
            "https://play.google.com/store/apps/details?id=org.scienceforourcoast.lakeandcoast&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1"
        const val LAKE_AND_COAST_APP_STORE_URL =
            "https://apps.apple.com/us/app/lake-and-coast/id1559404216?itsct=apps_box_badge&amp;itscg=30200"


        const val JOST = "Jost"
        const val REDDIT_MONO = "RedditMono"
        const val RUBIK = "Rubik"

        const val FOOTER_WEBSITE = "This website"
        const val WEBSITE_LINK = "https://github.com/sebastinto/OEssHRERLr770rGGLOH0.github.io"
        const val FOOTER_BUILT_WITH = " was built with "

        const val KOTLIN = "Kotlin"
        const val KOBWEB = "KobWeb"
        const val KOBWEB_URL = "https://github.com/varabyte/kobweb"
        const val KOTLIN_URL = "https://kotlinlang.org/"
        const val MAILTO = "mailto:contact@tobianoapps.com"

        const val EMAIL = "email"
        const val LINKEDIN = "linkedin"
        const val GITHUB = "github"
        const val GITHUB_URL = "https://github.com/sebastinto"
        const val LINKEDIN_URL = "https://www.linkedin.com/in/sebastienvictorpinto/"

        const val SAVED_THEME = "theme"

    }

    object Image {
        const val TIME_RISE = "android_timerise.png"
        const val SUNNY_SIDE = "android_sunnyside.png"
        const val LAKE_AND_COAST = "lake_coast_teaser.jpg"
        const val TOBIANO_LOGO = "/logo.png"
        const val GOOGLE_PLAY_BADGE = "google_play_badge.png"
        const val APP_STORE_BADGE =
            "https://tools.applemediaservices.com/api/badges/download-on-the-app-store/black/en-US?size=250x83&amp;releaseDate=1276560000&h=fbdb5b4ea9418f75555a911d01d7610e"
    }

    object Dimen {
        object ProjectLayout {
            const val TEXT_LEFT_RIGHT_PADDING = 50
            const val IMAGE_BORDER_RADIUS = 8
            const val MIN_WIDTH_PX = 400
            const val IMAGE_MAX_HEIGHT_PX = 600

            const val STORE_BADGE_WIDTH = 160
            const val STORE_BADGE_HEIGHT = 55

            const val TITLE_FONT_SIZE_REM = 2.9
            const val SUBTITLE_FONT_SIZE_REM = 1.1
            const val FEATURE_FONT_SIZE_REM = 1.05
        }

        object Header {
            const val HEADER_TITLE_FONT_SIZE_REM = 1.4
        }

        object Footer {
            const val FOOTER_TOOLTIP_TEXT_SIZE_REM = 0.9
        }
    }
}

object Utils {
    fun String.capitalized() = replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}