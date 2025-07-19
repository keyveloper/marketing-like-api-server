package org.example.marketinglikeapiserver.table

import org.example.marketinglikeapiserver.enums.LikeStatus
import org.jetbrains.exposed.sql.Column
import java.util.UUID

object LikeAdTable : BaseDateLongIdTable("like_ad") {
    val influencerId: Column<UUID> = uuid("influencer_id")
    val advertisementId: Column<Long> = long("advertisement_id")
    val likeStatus: Column<LikeStatus> = enumerationByName("like_status", 20, LikeStatus::class)
}
