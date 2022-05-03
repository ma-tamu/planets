package jp.co.project.planets.pleiades.model.entity;

import java.io.Serializable;

/**
 * country entity
 *
 * @param id
 *         id
 * @param name
 *         name
 * @param language
 *         laguage
 * @param region
 *         region
 */
public record CountryEntity(String id, String name, LanguageEntity language,
                            RegionEntity region) implements Serializable {


}
