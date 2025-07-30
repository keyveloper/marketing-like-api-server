package org.example.marketinglikeapiserver.dto

data class UnLikeResultFromServer(
    val effectedRow: Int
) {
    companion object {
        fun of(effectedRow: Int): UnLikeResultFromServer {
            return UnLikeResultFromServer(effectedRow)
        }
    }
}
