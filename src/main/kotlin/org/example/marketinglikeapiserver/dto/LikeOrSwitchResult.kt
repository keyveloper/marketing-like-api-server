package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.LikeStatus

data class LikeOrSwitchResult(
    val likeAd: LikeAd,
    val likeStatus: LikeStatus
) {
    companion object {
        fun of(
            likeAd: LikeAd,
            likeStatus: LikeStatus
        ): LikeOrSwitchResult {
            return LikeOrSwitchResult(
                likeAd = likeAd,
                likeStatus = likeStatus
            )
        }
    }
}
