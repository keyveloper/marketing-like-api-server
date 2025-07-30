package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

data class GetInfluencersByAdIdResponseFromServer(
    val result: GetInfluencersByAdIdResult,
    override val httpStatus: HttpStatus,
    override val msaServiceErrorCode: MSAServiceErrorCode,
    override val errorMessage: String?,
    override val logics: String?
): MSABusinessErrorResponse(httpStatus, msaServiceErrorCode, errorMessage, logics) {
    companion object {
        fun success(result: GetInfluencersByAdIdResult): GetInfluencersByAdIdResponseFromServer {
            return GetInfluencersByAdIdResponseFromServer(
                result = result,
                httpStatus = HttpStatus.OK,
                msaServiceErrorCode = MSAServiceErrorCode.OK,
                errorMessage = null,
                logics = "Get influencers by advertisement successful"
            )
        }
    }
}
