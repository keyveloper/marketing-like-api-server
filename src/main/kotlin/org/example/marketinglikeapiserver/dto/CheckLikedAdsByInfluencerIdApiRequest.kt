package org.example.marketinglikeapiserver.dto

import java.util.UUID

data class CheckLikedAdsByInfluencerIdApiRequest(
    val influencerId: UUID,
    val advertisementIds: List<Long>
)
