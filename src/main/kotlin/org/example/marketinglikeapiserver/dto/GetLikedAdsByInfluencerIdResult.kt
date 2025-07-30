package org.example.marketinglikeapiserver.dto

import java.util.UUID

data class GetLikedAdsByInfluencerIdResult(
    val influencerId: UUID,
    val advertisementIds: List<Long>
) {
    companion object {
        fun of(
            influencerId: UUID,
            advertisementIds: List<Long>
        ): GetLikedAdsByInfluencerIdResult {
            return GetLikedAdsByInfluencerIdResult(
                influencerId = influencerId,
                advertisementIds = advertisementIds
            )
        }
    }
}
