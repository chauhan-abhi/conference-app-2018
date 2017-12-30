package io.github.droidkaigi.confsched2018.data.db.entity.mapper

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.ZoneOffset

class Converters {
    companion object {
        @JvmStatic
        @TypeConverter
        fun fromTimestamp(value: Long?): LocalDateTime? =
                if (value == null) null else LocalDateTime.ofInstant(Instant.ofEpochSecond(value), ZoneId.systemDefault())

        @JvmStatic
        @TypeConverter
        fun dateToTimestamp(date: LocalDateTime?): Long? =
                date?.toEpochSecond(ZoneOffset.ofHours(9))
    }
}
