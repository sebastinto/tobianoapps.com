package com.tobianoapps.website.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tobianoapps.website.components.sections.faq.Accordion
import com.tobianoapps.website.components.sections.footer.Footer
import com.tobianoapps.website.components.sections.header.Header
import com.tobianoapps.website.model.Faq
import com.tobianoapps.website.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gridRow
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateRows
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.percent

@Page("/android/sunnyside/faq")
@Composable
fun SunnySideFAQ() {
    val breakpoint = rememberBreakpoint()

    var colorMode by ColorMode.currentState
    LaunchedEffect(colorMode) {
        val savedTheme = localStorage.getItem(Res.String.SAVED_THEME) ?: ColorMode.LIGHT.name
        colorMode = ColorMode.valueOf(savedTheme)
    }

    var expanded by remember {
        mutableIntStateOf(-1)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .minHeight(100.percent)
            // Create a box with two rows: the main content (fills as much space as it can) and the footer (which reserves
            // space at the bottom). "auto" means the use the height of the row. "1fr" means give the rest of the space to
            // that row. Since this container is set to *at least* 100%, the footer will always appear at least on the
            // bottom but can be pushed further down if the first row (main content) grows beyond the page.
            .gridTemplateRows { size(1.fr); size(auto) },
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            // Add some top margin to give some space for where the nav header will appear
            modifier = Modifier
                .fillMaxSize()
                .margin(top = 5.cssRem)
                .background(colorMode.toPalette().background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Header(
                colorMode = colorMode,
                onThemSwitchClicked = {
                    colorMode = colorMode.opposite
                    localStorage.setItem(Res.String.SAVED_THEME, colorMode.name)
                })

            Column(
                modifier = CenterColumnStyle
                    .toModifier()
                    .padding(top = if (breakpoint >= Breakpoint.MD) 3.cssRem else 0.cssRem)
            ) {
                SpanText(
                    "Sunny Side FAQ",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fontSize(Res.Dimen.ProjectLayout.TITLE_FONT_SIZE_REM.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .textAlign(TextAlign.Center)
                        .padding(top = 1.cssRem, bottom = 2.cssRem)
                )
                Faq.all.forEachIndexed { index, faq ->
                    Accordion(
                        tabText = faq.question,
                        content = { modifier -> faq.answer(modifier) },
                        expanded = expanded == index,
                        onClick = { expanded = if (expanded != index) index else -1 }
                    )
                }
            }

            Footer(modifier = Modifier.gridRow(2, 3))
        }
    }
}