package org.example.marketinglikeapiserver.repository

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketinglikeapiserver.dto.LikeAdEntity
import org.example.marketinglikeapiserver.dto.LikedAdvertisement
import org.example.marketinglikeapiserver.enums.LikeStatus
import org.example.marketinglikeapiserver.exception.FailedLikeException
import org.example.marketinglikeapiserver.table.LikeAdTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.jetbrains.exposed.sql.upsert
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class LikeAdRepository {
    private val logger = KotlinLogging.logger {}

    fun upsertLike(
        influencerId: UUID,
        advertisementId: Long,
        status: LikeStatus
    ): LikedAdvertisement {
        val now = System.currentTimeMillis()

        val upsertStatement = LikeAdTable.upsert {
            it[LikeAdTable.influencerId] = influencerId
            it[LikeAdTable.advertisementId] = advertisementId
            it[likeStatus] = status
            it[createdAt] = now
            it[lastModifiedAt] = now
        }

        val resultRow = upsertStatement.resultedValues?.get(0) ?: throw FailedLikeException(
            logics = "LikeAdRepo-upsert",
            message = "Failed to upsert like"
        )

        return LikedAdvertisement.fromResultRow(resultRow)
    }

    fun unLikeStatusByUserIds(
        influencerId: UUID,
        advertisementId: Long
    ): Int {
        return LikeAdTable.update(
            where = {
                (LikeAdTable.influencerId eq influencerId) and
                (LikeAdTable.advertisementId eq advertisementId) and
                (LikeAdTable.likeStatus eq LikeStatus.LIKE)
            }
        ) { row ->
            row[LikeAdTable.likeStatus] = LikeStatus.UNLIKE
            row[LikeAdTable.lastModifiedAt] = System.currentTimeMillis()
        }
    }

    fun findLikedAdsByInfluencerId(influencerId: UUID): List<LikedAdvertisement> {
        return transaction {
            LikeAdEntity.find {
                (LikeAdTable.influencerId eq influencerId) and
                (LikeAdTable.likeStatus eq LikeStatus.LIKE)
            }.map { LikedAdvertisement.of(it) }
        }
    }

    fun findInfluencersByAdId(advertisementId: Long): List<LikedAdvertisement> {
        return transaction {
            LikeAdEntity.find {
                (LikeAdTable.advertisementId eq advertisementId) and
                (LikeAdTable.likeStatus eq LikeStatus.LIKE)
            }.map { LikedAdvertisement.of(it) }
        }
    }
}
