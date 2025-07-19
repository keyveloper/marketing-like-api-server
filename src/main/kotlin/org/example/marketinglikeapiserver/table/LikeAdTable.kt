package org.example.marketinglikeapiserver.table

import org.example.marketinglikeapiserver.enums.EntityStatus
import org.example.marketinglikeapiserver.enums.LikeStatus
import org.jetbrains.exposed.sql.Column

object LikeAdTable : BaseDateLongIdTable("like_ad") {
    val influencerId: Column<String> = varchar("influencer_id", 36)
    val advertisementId: Column<Long> = long("advertisement_id")
    val likeStatus: Column<LikeStatus> = enumerationByName("like_status", 20, LikeStatus::class)
    val entityStatus: Column<EntityStatus> = enumerationByName("entity_status", 20, EntityStatus::class)
}
