package com.tobianoapps.website.model

import androidx.compose.runtime.Composable
import com.tobianoapps.website.util.Res
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedin

sealed class SocialIcon(val href: String, val tooltipText: String, val content: @Composable () -> Unit) {

    data object Github : SocialIcon(href = Res.String.GITHUB_URL, tooltipText = Res.String.GITHUB, content = { FaGithub() })
    data object LinkedIn : SocialIcon(href = Res.String.LINKEDIN_URL, tooltipText = Res.String.LINKEDIN, content = { FaLinkedin() })
    data object Email : SocialIcon(href = Res.String.MAILTO, tooltipText = Res.String.EMAIL, content = { FaEnvelope() })

    companion object {
        val enumerated = listOf(Github, LinkedIn, Email)
    }
}