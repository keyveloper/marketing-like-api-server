package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.LikeStatus
import java.util.UUID

data class SaveLikeAd(
    val influencerId: UUID,
    val advertisementId: Long,
    val likeStatus: LikeStatus
) {
    companion object {
        fun of(
            influencerId: UUID,
            advertisementId: Long,
            likeStatus: LikeStatus
        ): SaveLikeAd {
            return SaveLikeAd(
                influencerId = influencerId,
                advertisementId = advertisementId,
                likeStatus = likeStatus
            )
        }
    }
}
