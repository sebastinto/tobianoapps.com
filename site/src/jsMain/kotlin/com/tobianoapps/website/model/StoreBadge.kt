package com.tobianoapps.website.model

/**
 * Typically a Google Play Store or Apple App Store marketing badge and url.
 *
 * @param imageUri URI of badge image inside this project
 * @param url URL for the project in the store
 */
data class StoreBadge(
    val imageUri: String, // badge image resource
    val url: String // link to store
)