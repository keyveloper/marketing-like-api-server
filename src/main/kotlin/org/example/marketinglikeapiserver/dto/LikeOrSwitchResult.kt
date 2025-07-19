package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.LikeStatus

data class LikeOrSwitchResult(
    val likeAdMetadata: LikeAdMetadata,
    val likeStatus: LikeStatus
) {
    companion object {
        fun of(
            likeAdMetadata: LikeAdMetadata,
            likeStatus: LikeStatus
        ): LikeOrSwitchResult {
            return LikeOrSwitchResult(
                likeAdMetadata = likeAdMetadata,
                likeStatus = likeStatus
            )
        }
    }
}
