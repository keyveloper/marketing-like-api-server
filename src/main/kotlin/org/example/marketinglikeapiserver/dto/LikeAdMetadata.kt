package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.EntityStatus
import org.example.marketinglikeapiserver.enums.LikeStatus

data class LikeAdMetadata(
    val id: Long,
    val influencerId: String,
    val advertisementId: Long,
    val likeStatus: LikeStatus,
    val entityStatus: EntityStatus,
    val createdAt: Long,
    val lastModifiedAt: Long
) {
    companion object {
        fun of(
            id: Long,
            influencerId: String,
            advertisementId: Long,
            likeStatus: LikeStatus,
            entityStatus: EntityStatus,
            createdAt: Long,
            lastModifiedAt: Long
        ): LikeAdMetadata {
            return LikeAdMetadata(
                id = id,
                influencerId = influencerId,
                advertisementId = advertisementId,
                likeStatus = likeStatus,
                entityStatus = entityStatus,
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
                entityStatus = entity.entityStatus,
                createdAt = entity.createAt,
                lastModifiedAt = entity.lastModifiedAt
            )
        }
    }
}
