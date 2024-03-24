package com.tobianoapps.website.model

/**
 * A [ProjectFeature] typically represents an article, or video review for a project.
 *
 * @param title Title of the feature
 * @param url Url to the feature
 */
data class ProjectFeature(
    val title: String,
    val url: String
)