package com.tobianoapps.website.components.sections.footer

import androidx.compose.runtime.Composable
import com.tobianoapps.website.util.Res
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms

val FooterSocialStyle = CssStyle {
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
            .rotate(10.deg)
            .scale(1.7)
    }
}

@Composable
fun FooterSocialIcon(href: String, tooltipText: String, content: @Composable () -> Unit) {
    Link(
        modifier = FooterSocialStyle.toModifier(),
        path = href,
        variant = UncoloredLinkVariant,
        content = content
    )
    Tooltip(
        modifier = Modifier.fontSize(Res.Dimen.Footer.FOOTER_TOOLTIP_TEXT_SIZE_REM.cssRem),
        target = ElementTarget.PreviousSibling,
        text = tooltipText,
        placement = PopupPlacement.Top
    )
}