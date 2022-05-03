package jp.co.project.planets.pleiades.model.entity;

import java.io.Serializable;

/**
 * language entity
 *
 * @param id
 *         id
 * @param name
 *         name
 */
public record LanguageEntity(String id, String name) implements Serializable {
}
