package jp.co.project.planets.pleiades.model.entity;

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
public record CompanyEntity(String id, String name, CountryEntity country) {
}
