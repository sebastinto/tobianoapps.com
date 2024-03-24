package com.tobianoapps.website.components.sections.project

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectLayoutImage(
    modifier: Modifier = Modifier,
    src: String,
    imageCornerRadius: Int
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .borderRadius(r = imageCornerRadius.px)
                .fillMaxSize()
                .objectFit(ObjectFit.ScaleDown),
            src = src
        )
    }
}