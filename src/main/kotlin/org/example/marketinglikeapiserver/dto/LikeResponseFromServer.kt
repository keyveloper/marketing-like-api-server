package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

data class LikeResponseFromServer(
    val result: LikedAdvertisement,
    override val httpStatus: HttpStatus,
    override val msaServiceErrorCode: MSAServiceErrorCode,
    override val errorMessage: String?,
    override val logics: String?
): MSABusinessErrorResponse(httpStatus, msaServiceErrorCode, errorMessage, logics) {
    companion object {
        fun success(result: LikedAdvertisement): LikeResponseFromServer {
            return LikeResponseFromServer(
                result = result,
                httpStatus = HttpStatus.OK,
                msaServiceErrorCode = MSAServiceErrorCode.OK,
                errorMessage = null,
                logics = "Like operation successful"
            )
        }
    }
}
