package org.example.marketinglikeapiserver.dto

import java.util.UUID

data class LikeApiRequest(
    val influencerId: UUID,
    val advertisementId: Long
)
