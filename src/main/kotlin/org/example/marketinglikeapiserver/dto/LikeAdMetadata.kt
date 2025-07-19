package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.LikeStatus
import java.util.UUID

data class LikeAdMetadata(
    val id: Long,
    val influencerId: UUID,
    val advertisementId: Long,
    val likeStatus: LikeStatus,
    val createdAt: Long,
    val lastModifiedAt: Long
) {
    companion object {
        fun of(
            id: Long,
            influencerId: UUID,
            advertisementId: Long,
            likeStatus: LikeStatus,
            createdAt: Long,
            lastModifiedAt: Long
        ): LikeAdMetadata {
            return LikeAdMetadata(
                id = id,
                influencerId = influencerId,
                advertisementId = advertisementId,
                likeStatus = likeStatus,
                createdAt = createdAt,
                lastModifiedAt = lastModifiedAt
            )
        }

        fun fromEntity(entity: LikeAdEntity): LikeAdMetadata {
            return of(
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
