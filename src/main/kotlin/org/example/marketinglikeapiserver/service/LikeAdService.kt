package org.example.marketinglikeapiserver.service

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketinglikeapiserver.dto.LikeOrSwitchResult
import org.example.marketinglikeapiserver.dto.SaveLikeAd
import org.example.marketinglikeapiserver.enums.LikeStatus
import org.example.marketinglikeapiserver.repository.LikeAdRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class LikeAdService(
    private val likeAdRepository: LikeAdRepository
) {
    private val logger = KotlinLogging.logger {}

    fun likeOrSwitch(influencerId: UUID, advertisementId: Long): LikeOrSwitchResult {
        logger.info { "LikeAdService.likeOrSwitch: influencerId=$influencerId, advertisementId=$advertisementId" }

        val existingLikeAd = likeAdRepository.findByInfluencerIdAndAdvertisementId(influencerId, advertisementId)

        return if (existingLikeAd != null) {
            logger.info { "LikeAdService.likeOrSwitch: existing like found, switching status" }
            val updatedLikeAd = likeAdRepository.switch(influencerId, advertisementId)
            LikeOrSwitchResult.of(
                likeAd = updatedLikeAd,
                likeStatus = updatedLikeAd.likeStatus
            )
        } else {
            logger.info { "LikeAdService.likeOrSwitch: no existing like found, creating new LIKE" }
            val saveLikeAd = SaveLikeAd.of(
                influencerId = influencerId,
                advertisementId = advertisementId,
                likeStatus = LikeStatus.LIKE
            )
            val savedLikeAd = likeAdRepository.save(saveLikeAd)
            LikeOrSwitchResult.of(
                likeAd = savedLikeAd,
                likeStatus = savedLikeAd.likeStatus
            )
        }
    }
}
