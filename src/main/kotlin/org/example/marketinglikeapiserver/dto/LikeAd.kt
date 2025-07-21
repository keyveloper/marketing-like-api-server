package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.LikeStatus
import java.util.UUID

data class LikeAd(
    val id: Long,
    val influencerId: UUID,
    val advertisementId: Long,
    val likeStatus: LikeStatus,
    val createdAt: Long,
    val lastModifiedAt: Long
) {
    companion object {

        fun fromEntity(entity: LikeAdEntity): LikeAd {
            return LikeAd(
                id = entity.id.value,
                influencerId = entity.influencerId,
                advertisementId = entity.advertisementId,
                likeStatus = entity.likeStatus,
                createdAt = entity.createAt,
                lastModifiedAt = entity.lastModifiedAt
            )
        }
    }
}
