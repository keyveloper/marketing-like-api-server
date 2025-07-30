package org.example.marketinglikeapiserver.dto

import java.util.UUID

data class GetInfluencersByAdIdResult(
    val advertisementId: Long,
    val influencerIds: List<UUID>
) {
    companion object {
        fun of(
            advertisementId: Long,
            influencerIds: List<UUID>
        ): GetInfluencersByAdIdResult {
            return GetInfluencersByAdIdResult(
                advertisementId = advertisementId,
                influencerIds = influencerIds
            )
        }
    }
}
