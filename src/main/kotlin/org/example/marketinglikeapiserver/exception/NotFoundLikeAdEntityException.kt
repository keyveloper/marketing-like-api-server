package org.example.marketinglikeapiserver.exception

import org.example.marketinglikeapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

class NotFoundLikeAdEntityException(
    override val httpStatus: HttpStatus = HttpStatus.NOT_FOUND,
    override val msaServiceErrorCode: MSAServiceErrorCode = MSAServiceErrorCode.NOT_FOUND_LIKE_AD,
    override val logics: String,
    override val message: String = "LikeAd entity not found"
): MSAServerException(httpStatus, msaServiceErrorCode, logics, message)
