package org.example.marketinglikeapiserver.dto

import java.util.UUID

data class CheckLikedAdsByInfluencerIdResult(
    val influencerId: UUID,
    val likedAdvertisements: List<LikedAdvertisement>
) {
    companion object {
        fun of(
            influencerId: UUID,
            likedAdvertisements: List<LikedAdvertisement>
        ): CheckLikedAdsByInfluencerIdResult {
            return CheckLikedAdsByInfluencerIdResult(
                influencerId = influencerId,
                likedAdvertisements = likedAdvertisements
            )
        }
    }
}
