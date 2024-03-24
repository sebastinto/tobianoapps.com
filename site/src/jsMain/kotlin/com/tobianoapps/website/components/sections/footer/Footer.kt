package com.tobianoapps.website.components.sections.footer

import androidx.compose.runtime.Composable
import com.tobianoapps.website.model.SocialIcon
import com.tobianoapps.website.util.Res
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderTop
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssPrefix
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@CssPrefix("tba-footer")
val FooterStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .margin(top = 2.cssRem)
        .borderTop(1.px, LineStyle.Solid, colorMode.toPalette().border)
        .padding(topBottom = 1.cssRem, leftRight = 4.cssRem)
}

@CssPrefix("tba-copyright")
val CopyrightStyle = CssStyle.base {
    Modifier.opacity(1).fontSize(0.8.cssRem)
}

@CssPrefix("tba-credits")
val CreditsStyle = CssStyle.base {
    Modifier.opacity(0.6).fontSize(0.8.cssRem)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Column(
        modifier = FooterStyle.toModifier().then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // icons
        Row(
            Modifier
                .justifyContent(JustifyContent.SpaceAround)
                .width(12.cssRem)
                .margin(top = 1.cssRem, bottom = 1.cssRem)
        ) {
            SocialIcon.enumerated.forEach {
                FooterSocialIcon(
                    href = it.href,
                    tooltipText = it.tooltipText
                ) { it.content.invoke() }
            }
        }

        // copyright
        SpanText(
            text = Res.String.getCopyright(),
            modifier = CopyrightStyle.toModifier().then(
                Modifier
                    .fontSize(Res.Dimen.Footer.FOOTER_TOOLTIP_TEXT_SIZE_REM.cssRem)
                    .textAlign(TextAlign.Start)
            )
        )

        // credits
        Span(
            attrs = CreditsStyle.toModifier()
                .then(
                    Modifier
                        .fontSize(Res.Dimen.Footer.FOOTER_TOOLTIP_TEXT_SIZE_REM.cssRem)
                        .whiteSpace(WhiteSpace.PreWrap)
                        .textAlign(TextAlign.Center)
                ).toAttrs()
        ) {
            FooterTextLink(path = Res.String.WEBSITE_LINK, text = Res.String.FOOTER_WEBSITE)
            Text(Res.String.FOOTER_BUILT_WITH)
            FooterTextLink(path = Res.String.KOTLIN_URL, text = Res.String.KOTLIN)
            Text(" and ")
            FooterTextLink(path = Res.String.KOBWEB_URL, text = Res.String.KOBWEB)
            Text(".")
        }
    }
}
