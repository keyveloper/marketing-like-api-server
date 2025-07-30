package org.example.marketinglikeapiserver.service

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketinglikeapiserver.dto.GetInfluencersByAdIdResult
import org.example.marketinglikeapiserver.dto.GetLikedAdsByInfluencerIdResult
import org.example.marketinglikeapiserver.dto.LikedAdvertisement
import org.example.marketinglikeapiserver.dto.UnLikeResultFromServer
import org.example.marketinglikeapiserver.enums.LikeStatus
import org.example.marketinglikeapiserver.exception.FailedLikeException
import org.example.marketinglikeapiserver.repository.LikeAdRepository
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class LikeAdService(
    private val likeAdRepository: LikeAdRepository
) {
    private val logger = KotlinLogging.logger {}

    fun likeUpsert(influencerId: UUID, advertisementId: Long): LikedAdvertisement {
        return transaction {
            likeAdRepository.upsertLike(
                influencerId,
                advertisementId,
                LikeStatus.LIKE
            )
        }
    }

    fun unLike(influencerId: UUID, advertisementId: Long): UnLikeResultFromServer {
        return transaction {
            val effectedRow = likeAdRepository.unLikeStatusByUserIds(
                influencerId,
                advertisementId
            )

            if (effectedRow == 0) throw FailedLikeException(
                logics = "LikeAdSvc-unLike",
                message = "Unlike failed, maybe can't find like entity influencerId=$influencerId, advertisementId=$advertisementId"
            )

            UnLikeResultFromServer.of(effectedRow)
        }
    }

    fun getLikedAdsByInfluencerId(influencerId: UUID): GetLikedAdsByInfluencerIdResult {
        return transaction {
            val likedAds = likeAdRepository.findLikedAdsByInfluencerId(influencerId)
            GetLikedAdsByInfluencerIdResult.of(
                influencerId = influencerId,
                advertisementIds = likedAds.map { it.advertisementId }
            )
        }
    }

    fun getInfluencersByAdId(advertisementId: Long): GetInfluencersByAdIdResult {
        return transaction {
            val likedAds = likeAdRepository.findInfluencersByAdId(advertisementId)
            GetInfluencersByAdIdResult.of(
                advertisementId = advertisementId,
                influencerIds = likedAds.map { it.influencerId }
            )
        }
    }
}
