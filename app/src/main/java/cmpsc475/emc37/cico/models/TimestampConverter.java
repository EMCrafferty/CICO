package cmpsc475.emc37.cico.models;

import androidx.annotation.NonNull;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TimestampConverter {
  @TypeConverter
  public static Long fromTimestamp(@NonNull OffsetDateTime timestamp) {
    return timestamp.toEpochSecond();
  }

  @TypeConverter
  public static OffsetDateTime toTimestamp(@NonNull Long secondsFromEpoch) {
    return OffsetDateTime.ofInstant(Instant.ofEpochSecond(secondsFromEpoch), ZoneOffset.UTC);
  }
}
