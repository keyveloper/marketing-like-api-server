package org.example.marketinglikeapiserver.enums

enum class MSAServiceErrorCode(val code: Int) {
    // 0~ : Success
    OK(0),

    // 10000~ : Authentication & Authorization errors
    INVALID_TOKEN(10001),
    EXPIRED_TOKEN(10002),

    // 20000~ : Permission & Role errors
    FORBIDDEN(20001),

    // 30000~ : User information errors
    USER_NOT_FOUND(30001),

    // 40000~ : Entity Not found
    NOT_FOUND_LIKE_AD(40000),

    // 50000~ : Server errors
    SAVE_FAILED_FOR_DATABASE(50000),
    INTERNAL_SERVER_ERROR(50099),
    UNKNOWN_ERROR(59999),
}
