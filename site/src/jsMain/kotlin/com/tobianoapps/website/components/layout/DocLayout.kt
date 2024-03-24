package com.tobianoapps.website.components.layout

import androidx.compose.runtime.Composable
import com.tobianoapps.website.util.Res
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.silk.style.CssPrefix
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

@CssPrefix("tba-ccs")
val DocBodyStyle = CssStyle {  
    base {
        Modifier
            .fillMaxWidth(85.percent)
            .lineHeight(2)
            .fontSize(1.cssRem)
            .fontFamily(Res.String.RUBIK)
    }
    Breakpoint.MD { Modifier.fillMaxWidth(70.percent) }
}

@Composable
fun DocLayout(content: @Composable ColumnScope.() -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(DocBodyStyle.toModifier()) {
            content()
        }
    }
}