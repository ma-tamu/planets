package jp.co.project.planets.pleiades.model.entity;

import jp.co.project.planets.pleiades.enums.GenderEnum;

/**
 * user entity
 *
 * @param id
 *         id
 * @param loginId
 *         login id
 * @param name
 *         name
 * @param mail
 *         mail
 * @param gender
 *         gender
 * @param company
 *         company
 * @param lockout
 *         lockout
 */
public record UserEntity(String id, String loginId, String name, String mail, GenderEnum gender, CompanyEntity company,
                         boolean lockout) {
}
