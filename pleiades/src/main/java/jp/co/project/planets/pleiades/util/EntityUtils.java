package jp.co.project.planets.pleiades.util;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * entity utils
 */
public final class EntityUtils {

    private EntityUtils() {
    }

    /**
     * generate id
     *
     * @return id
     */
    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", StringUtils.EMPTY);
    }
}
