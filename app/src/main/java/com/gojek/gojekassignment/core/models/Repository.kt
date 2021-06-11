package com.gojek.gojekassignment.core.models

import com.squareup.moshi.Json
import java.io.Serializable

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */

data class Repository(

    @Json(name = "author") var author: String,
    @Json(name = "name") var name: String,
    @Json(name = "avatar") var avatar: String,
    @Json(name = "url") var url: String,
    @Json(name = "description") var description: String,
    @Json(name = "language") var language: String,
    @Json(name = "languageColor") var languageColor: String,
    @Json(name = "stars") var stars: Int,
    @Json(name = "forks") var forks: Int,
    @Json(name = "currentPeriodStars") var currentPeriodStars: Int,
    @Json(name = "builtBy") var builtBy: List<BuildInfo>

) : Serializable