package jp.co.project.planets.pleiades.model.entity;

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
public record UserEntity(String id, String loginId, String name, String mail, String gender, CompanyEntity company,
                         boolean lockout) {
}
