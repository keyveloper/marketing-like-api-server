package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.EntityStatus
import org.example.marketinglikeapiserver.enums.LikeStatus

data class SaveLikeAd(
    val influencerId: String,
    val advertisementId: Long,
    val likeStatus: LikeStatus,
    val entityStatus: EntityStatus
) {
    companion object {
        fun of(
            influencerId: String,
            advertisementId: Long,
            likeStatus: LikeStatus,
            entityStatus: EntityStatus
        ): SaveLikeAd {
            return SaveLikeAd(
                influencerId = influencerId,
                advertisementId = advertisementId,
                likeStatus = likeStatus,
                entityStatus = entityStatus
            )
        }
    }
}
