package org.example.marketinglikeapiserver.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketinglikeapiserver.dto.*
import org.example.marketinglikeapiserver.service.LikeAdService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/like")
class LikeAdController(
    private val likeAdService: LikeAdService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("/ad")
    fun like(@RequestBody request: LikeApiRequest): ResponseEntity<LikeResponseFromServer> {
        logger.info { "LikeAdController.like: request=$request" }

        val result = likeAdService.likeUpsert(
            influencerId = request.influencerId,
            advertisementId = request.advertisementId
        )

        val response = LikeResponseFromServer.success(result)
        logger.info { "LikeAdController.like: response=$response" }

        return ResponseEntity.ok(response)
    }

    @PostMapping("/ad/unlike")
    fun unlike(@RequestBody request: UnLikeApiRequest): ResponseEntity<UnLikeResponseFromServer> {
        logger.info { "LikeAdController.unlike: request=$request" }

        val result = likeAdService.unLike(
            influencerId = request.influencerId,
            advertisementId = request.advertisementId
        )

        val response = UnLikeResponseFromServer.success(result)
        logger.info { "LikeAdController.unlike: response=$response" }

        return ResponseEntity.ok(response)
    }

    @GetMapping("/influencer/{influencerId}")
    fun getLikedAdsByInfluencerId(
        @PathVariable influencerId: UUID
    ): ResponseEntity<GetLikedAdsByInfluencerIdResponseFromServer> {
        logger.info { "LikeAdController.getLikedAdsByInfluencerId: influencerId=$influencerId" }

        val result = likeAdService.getLikedAdsByInfluencerId(influencerId)

        val response = GetLikedAdsByInfluencerIdResponseFromServer.success(result)
        logger.info { "LikeAdController.getLikedAdsByInfluencerId: response=$response" }

        return ResponseEntity.ok(response)
    }

    @GetMapping("/advertisement/{advertisementId}")
    fun getInfluencersByAdId(
        @PathVariable advertisementId: Long
    ): ResponseEntity<GetInfluencersByAdIdResponseFromServer> {
        logger.info { "LikeAdController.getInfluencersByAdId: advertisementId=$advertisementId" }

        val result = likeAdService.getInfluencersByAdId(advertisementId)

        val response = GetInfluencersByAdIdResponseFromServer.success(result)
        logger.info { "LikeAdController.getInfluencersByAdId: response=$response" }

        return ResponseEntity.ok(response)
    }
}
