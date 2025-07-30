package org.example.marketinglikeapiserver.exception

import org.example.marketinglikeapiserver.enums.MSAServiceErrorCode
import org.springframework.http.HttpStatus

class FailedLikeException(
    override val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    override val msaServiceErrorCode: MSAServiceErrorCode = MSAServiceErrorCode.SAVE_FAILED_FOR_DATABASE,
    override val logics: String,
    override val message: String = "Failed to process like operation"
): MSAServerException(httpStatus, msaServiceErrorCode, logics, message)
