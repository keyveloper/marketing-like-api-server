package org.example.marketinglikeapiserver.repository

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketinglikeapiserver.dto.LikeAdEntity
import org.example.marketinglikeapiserver.dto.LikeAd
import org.example.marketinglikeapiserver.dto.SaveLikeAd
import org.example.marketinglikeapiserver.enums.LikeStatus
import org.example.marketinglikeapiserver.exception.NotFoundLikeAdEntityException
import org.example.marketinglikeapiserver.table.LikeAdTable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class LikeAdRepository {
    private val logger = KotlinLogging.logger {}

    fun save(saveLikeAd: SaveLikeAd): LikeAd {
        return transaction {
            val entity = LikeAdEntity.new {
                influencerId = saveLikeAd.influencerId
                advertisementId = saveLikeAd.advertisementId
                likeStatus = saveLikeAd.likeStatus
            }
            LikeAd.fromEntity(entity)
        }
    }

    fun switch(influencerId: UUID, advertisementId: Long): LikeAd {
        return transaction {
            val entity = LikeAdEntity.find {
                (LikeAdTable.influencerId eq influencerId) and
                (LikeAdTable.advertisementId eq advertisementId)
            }.firstOrNull() ?: throw NotFoundLikeAdEntityException(
                logics = "LikeAdRepository.switch: entity not found for influencerId=$influencerId, advertisementId=$advertisementId"
            )

            entity.likeStatus = if (entity.likeStatus == LikeStatus.LIKE) LikeStatus.UNLIKE else LikeStatus.LIKE
            LikeAd.fromEntity(entity)
        }
    }

    fun findByAdvertisementId(advertisementId: Long): List<LikeAd> {
        return transaction {
            LikeAdEntity.find {
                LikeAdTable.advertisementId eq advertisementId
            }.map { LikeAd.fromEntity(it) }
        }
    }

    fun findByInfluencerId(influencerId: UUID): List<LikeAd> {
        return transaction {
            LikeAdEntity.find {
                LikeAdTable.influencerId eq influencerId
            }.map { LikeAd.fromEntity(it) }
        }
    }

    fun findByInfluencerIdAndAdvertisementId(influencerId: UUID, advertisementId: Long): LikeAd? {
        return transaction {
            LikeAdEntity.find {
                (LikeAdTable.influencerId eq influencerId) and
                (LikeAdTable.advertisementId eq advertisementId)
            }.firstOrNull()?.let { LikeAd.fromEntity(it) }
        }
    }
}
