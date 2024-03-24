package com.tobianoapps.website.components.sections.project

import androidx.compose.runtime.Composable
import com.tobianoapps.website.model.Project
import com.tobianoapps.website.util.Res
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val StoreBadgeStyle = CssStyle {
    base {
        Modifier
            .rotate(0.deg)
            .scale(1)
            .transition(
                CSSTransition(property = "rotate", duration = 300.ms),
                CSSTransition(property = "scale", duration = 200.ms),
            )
    }
    hover {
        Modifier
            .scale(1.05)
    }
}

@Composable
fun ProjectLayoutText(
    modifier: Modifier = Modifier,
    project: Project,
    breakpoint: Breakpoint
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            with(project) {
                SpanText(
                    text = title,
                    modifier = Modifier
                        .fontSize(Res.Dimen.ProjectLayout.TITLE_FONT_SIZE_REM.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .textAlign(
                            if (breakpoint <= Breakpoint.SM) TextAlign.Center
                            else TextAlign.Start
                        )
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .margin(bottom = 16.px),
                    horizontalAlignment = Alignment.Start
                ) {
                    subtitles.forEach { sub ->
                        SpanText(
                            text = sub,
                            modifier = Modifier
                                .fontSize(Res.Dimen.ProjectLayout.SUBTITLE_FONT_SIZE_REM.cssRem)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .margin(bottom = 16.px),
                    horizontalAlignment = Alignment.Start
                ) {
                    projectFeatures.forEach { feature ->
                        Link(
                            path = feature.url,
                            text = feature.title,
                            openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
                            modifier = Modifier.fontSize(Res.Dimen.ProjectLayout.FEATURE_FONT_SIZE_REM.cssRem)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .margin(bottom = 32.px),
                    horizontalAlignment = Alignment.Start
                ) {
                    project.badges.forEach { badge ->
                        Link(
                            path = badge.url,
                            modifier = StoreBadgeStyle.toModifier(),
                            variant = UncoloredLinkVariant,
                            content = {
                                Image(
                                    modifier = Modifier
                                        .objectFit(ObjectFit.Contain)
                                        .width(Res.Dimen.ProjectLayout.STORE_BADGE_WIDTH.px)
                                        .height(Res.Dimen.ProjectLayout.STORE_BADGE_HEIGHT.px),
                                    src = badge.imageUri,
                                )
                            })
                    }
                }
            }
        }
    }
}