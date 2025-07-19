package org.example.marketinglikeapiserver.dto

import org.example.marketinglikeapiserver.table.BaseDateLongIdTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID

abstract class BaseDateEntity(id: EntityID<Long>, table: BaseDateLongIdTable): LongEntity(id) {
    val createAt by table.createdAt
    var lastModifiedAt by table.lastModifiedAt
}