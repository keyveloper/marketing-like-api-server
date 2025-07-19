package org.example.marketinglikeapiserver.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.marketinglikeapiserver.dto.LikeOrSwitchApiRequest
import org.example.marketinglikeapiserver.dto.LikeOrSwitchResponseFromServer
import org.example.marketinglikeapiserver.service.LikeAdService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/like-ad")
class LikeAdController(
    private val likeAdService: LikeAdService
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("/like-or-switch")
    fun likeOrSwitch(@RequestBody request: LikeOrSwitchApiRequest): ResponseEntity<LikeOrSwitchResponseFromServer> {
        logger.info { "LikeAdController.likeOrSwitch: request=$request" }

        val result = likeAdService.likeOrSwitch(
            influencerId = request.influencerId,
            advertisementId = request.advertisementId
        )

        val response = LikeOrSwitchResponseFromServer.success(result)
        logger.info { "LikeAdController.likeOrSwitch: response=$response" }

        return ResponseEntity.ok(response)
    }
}
