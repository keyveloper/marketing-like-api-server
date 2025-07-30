package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

data class GetLikedAdsByInfluencerIdResponseFromServer(
    val result: GetLikedAdsByInfluencerIdResult,
    override val httpStatus: HttpStatus,
    override val msaServiceErrorCode: MSAServiceErrorCode,
    override val errorMessage: String?,
    override val logics: String?
): MSABusinessErrorResponse(httpStatus, msaServiceErrorCode, errorMessage, logics) {
    companion object {
        fun success(result: GetLikedAdsByInfluencerIdResult): GetLikedAdsByInfluencerIdResponseFromServer {
            return GetLikedAdsByInfluencerIdResponseFromServer(
                result = result,
                httpStatus = HttpStatus.OK,
                msaServiceErrorCode = MSAServiceErrorCode.OK,
                errorMessage = null,
                logics = "Get liked ads by influencer successful"
            )
        }
    }
}
