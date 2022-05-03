package jp.co.project.planets.pleiades.model.entity;

import java.io.Serializable;

/**
 * region entity
 *
 * @param id
 *         id
 * @param name
 *         name
 */
public record RegionEntity(String id, String name) implements Serializable {
}
