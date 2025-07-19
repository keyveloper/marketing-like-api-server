package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.enums.EntityStatus
import org.example.marketinglikeapiserver.enums.LikeStatus
import org.example.marketinglikeapiserver.table.LikeAdTable
import org.jetbrains.exposed.dao.id.EntityID

class LikeAdEntity(id: EntityID<Long>): BaseDateEntity(id, LikeAdTable) {
    companion object: BaseDateEntityAutoUpdate<LikeAdEntity>(LikeAdTable)

    var influencerId: String by LikeAdTable.influencerId
    var advertisementId: Long by LikeAdTable.advertisementId
    var likeStatus: LikeStatus by LikeAdTable.likeStatus
    var entityStatus: EntityStatus by LikeAdTable.entityStatus
}
