package com.tobianoapps.website

import com.tobianoapps.website.util.Res

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.link
import org.jetbrains.compose.web.css.px

@InitSilk
fun initSilk(context: InitSilkContext) {
    context.apply {
        stylesheet.registerStyleBase("body") {
            Modifier.fontFamily(Res.String.JOST, "Ubuntu", "Roboto", "Arial", "Helvetica", "sans-serif")
                .fontSize(18.px)
                .lineHeight(1.5)
        }

        stylesheet.registerStyleBase("code") {
            Modifier.fontFamily(
                Res.String.REDDIT_MONO,
                "Ubuntu Mono",
                "Roboto Mono",
                "Lucida Console",
                "Courier New",
                "monospace"
            )
        }
        theme.palettes.apply {
            light.apply {
                color = Res.Theme.BODY_TEXT_LIGHT.color
                background = Res.Theme.BACKGROUND_LIGHT.color
                border = Res.Theme.BORDER_LIGHT.color
                link.apply {
                    default = Res.Theme.LINK_DEFAULT_LIGHT.color
                    visited = context.theme.palettes.light.link.default
                }
            }

            dark.apply {
                color = Res.Theme.BODY_TEXT_DARK.color
                background = Res.Theme.BACKGROUND_DARK.color
                border = Res.Theme.BORDER_DARK.color
                link.apply {
                    default = Res.Theme.LINK_DEFAULT_DARK.color
                    visited = context.theme.palettes.dark.link.default
                }
            }
        }
    }
}