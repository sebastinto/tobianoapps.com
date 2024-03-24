package com.tobianoapps.website.components.sections.project

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectLayout(
    modifier: Modifier = Modifier.margin(topBottom = 32.px),
    breakpoint: Breakpoint,
    content: @Composable () -> Unit
) {
    if (breakpoint <= Breakpoint.MD) {
        Column(modifier = modifier) {
            content()
        }
    } else {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            content()
        }
    }
}