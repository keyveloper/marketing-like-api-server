package org.example.marketinglikeapiserver.dto

data class LikeOrSwitchApiRequest(
    val influencerId: String,
    val advertisementId: Long
)
