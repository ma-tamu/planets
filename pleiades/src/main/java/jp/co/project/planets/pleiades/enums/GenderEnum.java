package jp.co.project.planets.pleiades.enums;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Arrays;

/**
 * gender enum
 */
public enum GenderEnum implements Serializable {

    /** 男性 */
    MALE("M"),
    /** 女性 */
    FEMALE("F");

    private final String value;

    /**
     * new instance gender enum
     *
     * @param value
     *         gender
     */
    GenderEnum(final String value) {
        this.value = value;
    }

    /**
     * getter value
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * enum of
     *
     * @param gender
     *         gender
     * @return GenderEnum
     */
    public static GenderEnum of(final String gender) {
        return Arrays.stream(GenderEnum.values()).filter(it -> StringUtils.equals(it.getValue(), gender)) //
                .findFirst().orElseThrow(() -> new RuntimeException(String.format("gender[%s] not found.", gender)));
    }
}
