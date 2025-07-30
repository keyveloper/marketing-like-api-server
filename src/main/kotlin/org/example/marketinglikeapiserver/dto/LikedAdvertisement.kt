package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.LikeStatus
import org.example.marketinglikeapiserver.table.LikeAdTable
import org.jetbrains.exposed.sql.ResultRow
import java.util.UUID

data class LikedAdvertisement(
    val id: Long,
    val influencerId: UUID,
    val advertisementId: Long,
    val likeStatus: LikeStatus,
    val createdAt: Long,
    val lastModifiedAt: Long
) {
    companion object {

        fun of(entity: LikeAdEntity): LikedAdvertisement {
            return LikedAdvertisement(
                id = entity.id.value,
                influencerId = entity.influencerId,
                advertisementId = entity.advertisementId,
                likeStatus = entity.likeStatus,
                createdAt = entity.createAt,
                lastModifiedAt = entity.lastModifiedAt
            )
        }

        fun fromResultRow(row: ResultRow): LikedAdvertisement {
            return LikedAdvertisement(
                id = row[LikeAdTable.id].value,
                influencerId = row[LikeAdTable.influencerId],
                advertisementId = row[LikeAdTable.advertisementId],
                likeStatus = row[LikeAdTable.likeStatus],
                createdAt = row[LikeAdTable.createdAt],
                lastModifiedAt = row[LikeAdTable.lastModifiedAt]
            )
        }
    }
}
