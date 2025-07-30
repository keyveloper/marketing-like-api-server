package org.example.marketinglikeapiserver.dto

import java.util.UUID

data class UnLikeApiRequest(
    val influencerId: UUID,
    val advertisementId: Long
)
