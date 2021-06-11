package com.gojek.gojekassignment.core.models

import com.squareup.moshi.Json
import java.io.Serializable

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */

data class BuildInfo (

    @Json(name = "href") var href : String,
    @Json(name = "avatar") var avatar : String,
    @Json(name = "username") var username : String

): Serializable