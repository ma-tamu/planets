package jp.co.project.planets.moon.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * date utils
 */
public final class DateUtils {

    /**
     * private new instances date utils
     */
    private DateUtils() {

    }

    /**
     * instant to jst LocalDateTime
     *
     * @param instant
     *         instant
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(final Instant instant) {
        instant.atZone(ZoneId.systemDefault());
        return LocalDateTime.ofInstant(instant, ZoneOffset.systemDefault());
    }
}
