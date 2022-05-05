package jp.co.project.planets.pleiades.model.entity;

import java.io.Serializable;

/**
 * company entity
 *
 * @param id
 *         id
 * @param name
 *         name
 * @param country
 *         country
 */
public record CompanyEntity(String id, String name, CountryEntity country) implements Serializable {
}
