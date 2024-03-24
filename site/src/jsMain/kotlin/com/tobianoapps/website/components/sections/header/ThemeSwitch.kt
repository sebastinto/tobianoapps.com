package com.tobianoapps.website.components.sections.header

import androidx.compose.runtime.*
import com.tobianoapps.website.util.Res.Theme.Companion.themeSwitchBackgroundBackground
import com.tobianoapps.website.util.Res.Theme.Companion.themeSwitchHoverBackground
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaMoon
import com.varabyte.kobweb.silk.components.icons.fa.FaSun
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ThemeSwitchStyle = CssStyle {
    base {
        Modifier
            .background(colorMode.themeSwitchBackgroundBackground())
            .transition(CSSTransition(property = "background", duration = 300.ms))
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = colorMode.toPalette().border
            )
    }

    hover { Modifier.background(colorMode.themeSwitchHoverBackground()) }
}
@Composable
fun ThemeSwitch(
    colorMode: ColorMode,
    onClick: () -> Unit
) {
    var rotation by remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {
        Box(
            modifier =
            ThemeSwitchStyle.toModifier().then(Modifier
                .rotate(rotation.deg)
                .transition(
                    CSSTransition(property = "rotate", duration = 500.ms),
                )
                .padding(all = 8.px)
                .borderRadius(r = 30.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    rotation += 360
                    onClick.invoke() }
            )
        ) {
            if (colorMode.isLight) FaSun() else FaMoon()
        }
    }
}

