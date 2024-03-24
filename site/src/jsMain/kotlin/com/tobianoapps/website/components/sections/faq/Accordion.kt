package com.tobianoapps.website.components.sections.faq

import androidx.compose.runtime.Composable
import com.tobianoapps.website.util.Res

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateRows
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.icons.fa.FaChevronDown
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

val CollapsibleStyle = CssStyle.base {
    Modifier.color(
        if (colorMode.isLight) Colors.White else ColorMode.DARK.toPalette().color
    )
        .margin(.5.cssRem)
}

@Composable
fun CollapsableHeightBox(
    open: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        Modifier
            .gridTemplateRows { size(if (open) 1.fr else 0.fr) }
            .overflow(Overflow.Hidden)
            .transition(CSSTransition("grid-template-rows", 0.3.s))
            .then(modifier)
    ) {
        Box(
            Modifier.overflow(Overflow.Hidden),
            content = content
        ) // needed if inner element has padding
    }
}

@Composable
fun Accordion(
    modifier: Modifier = CollapsibleStyle.toModifier(),
    tabText: String,
    content: @Composable (Modifier) -> Unit,
    expanded: Boolean = false,
    onClick: () -> Unit
) {
    // column
    Column(modifier = modifier.fillMaxWidth()) {
        // tab
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.px)
                .background(Res.Theme.BORDER_DARK.color)
                .onClick { onClick.invoke() }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().cursor(Cursor.Pointer),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SpanText(text = tabText)
                Box(modifier = Modifier.padding(all = 8.px)) {
                    FaChevronDown(
                        modifier = Modifier
                            .rotate(if (expanded) 180.deg else 0.deg)
                            .transition(
                                CSSTransition(
                                    property = "rotate",
                                    duration = 200.ms,
                                    timingFunction = TransitionTimingFunction.EaseInOut
                                )
                            )
                    )
                }
            }
        }

        // tab content
        CollapsableHeightBox(
            open = expanded,
            modifier = Modifier.fillMaxWidth().background(Res.Theme.BACKGROUND_DARK.color)
        ) {
            content(Modifier.padding(18.px))
        }
    }
}
