package com.tobianoapps.website.components.sections.footer

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.silk.components.navigation.Link

@Composable
fun FooterTextLink(path: String, text: String) =
    Link(path, text, modifier = Modifier.fontWeight(FontWeight.Medium))