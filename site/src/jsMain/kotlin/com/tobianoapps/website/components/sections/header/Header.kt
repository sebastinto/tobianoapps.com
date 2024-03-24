package com.tobianoapps.website.components.sections.header

import androidx.compose.runtime.Composable
import com.tobianoapps.website.util.Res
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backdropFilter
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.defer.deferRender
import com.varabyte.kobweb.silk.style.CssPrefix
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

///**
// * Setting a blur value on [com.varabyte.kobweb.compose.ui.modifiers.backdropFilter] does not work on Safari.
// * This alternative fixes the issue by adding a `-webkit-backdrop-filter` property.
// */
//fun Modifier.backdropFilter(vararg filters: CSSFilter) = styleModifier {
//    if (filters.isNotEmpty()) {
//        listOf("backdrop-filter", "-webkit-backdrop-filter").forEach {
//            property(it, filters.joinToString(" "))
//        }
//    }
//}

@CssPrefix("tba-header")
val HeaderStyle = CssStyle.base(extraModifier = { SmoothColorStyle.toModifier() }) {
    Modifier
        .fillMaxWidth()
        .padding(left = 1.cssRem, right = 1.cssRem, top = 1.cssRem, bottom = 1.cssRem)
        .fontSize(1.25.cssRem)
        .position(Position.Fixed)
        .top(0.percent)
        .backgroundColor(colorMode.toPalette().background.toRgb().copyf(alpha = 0.65f))
        .backdropFilter(saturate(180.percent), blur(10.px))
        .borderBottom(width = 1.px, style = LineStyle.Solid, color = colorMode.toPalette().border)
}

@Composable
fun Header(
    modifier: Modifier = Modifier,
    colorMode: ColorMode,
    onThemSwitchClicked: () -> Unit
) {
    val ctx = rememberPageContext()
    deferRender {
        Row(
            modifier = HeaderStyle.toModifier().then(modifier),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .cursor(Cursor.Pointer)
                    .onClick {
                        ctx.router.navigateTo("/")
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(36.px)
                        .objectFit(ObjectFit.ScaleDown),
                    src = Res.Image.TOBIANO_LOGO,
                    autoPrefix = false
                )
                SpanText(
                    text = Res.String.TOBIANO_APPS,
                    modifier = Modifier
                        .margin(left = 8.px)
                        .fontSize(Res.Dimen.Header.HEADER_TITLE_FONT_SIZE_REM.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .textAlign(TextAlign.Start)
                )
            }
            Spacer()
            ThemeSwitch(colorMode = colorMode, onClick = onThemSwitchClicked)
        }
    }
}
