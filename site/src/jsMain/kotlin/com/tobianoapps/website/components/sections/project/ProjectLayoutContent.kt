package com.tobianoapps.website.components.sections.project

import androidx.compose.runtime.Composable
import com.tobianoapps.website.model.Project
import com.tobianoapps.website.util.Res
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectLayoutContent(
    project: Project,
    breakpoint: Breakpoint
) {
    with(project) {
        ProjectLayoutText(
            modifier = Modifier
                .minWidth(Res.Dimen.ProjectLayout.MIN_WIDTH_PX.px)
                .padding(leftRight = Res.Dimen.ProjectLayout.TEXT_LEFT_RIGHT_PADDING.px),
            project = project,
            breakpoint = breakpoint

        )
        ProjectLayoutImage(
            modifier = Modifier
                .minWidth(Res.Dimen.ProjectLayout.MIN_WIDTH_PX.px)
                .maxHeight(Res.Dimen.ProjectLayout.IMAGE_MAX_HEIGHT_PX.px)
                .padding(leftRight = Res.Dimen.ProjectLayout.TEXT_LEFT_RIGHT_PADDING.px),
            src = imageSrc,
            imageCornerRadius = Res.Dimen.ProjectLayout.IMAGE_BORDER_RADIUS
        )
    }
}