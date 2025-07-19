package org.example.marketinglikeapiserver.dto

import java.util.UUID

data class LikeOrSwitchApiRequest(
    val influencerId: UUID,
    val advertisementId: Long
)
