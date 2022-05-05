package jp.co.project.planets.earthly.service;

import jp.co.project.planets.earthly.model.dto.UserDetailDto;
import jp.co.project.planets.pleiades.enums.GenderEnum;
import jp.co.project.planets.pleiades.model.entity.UserEntity;
import jp.co.project.planets.pleiades.repository.CompanyRepository;
import jp.co.project.planets.pleiades.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * user service
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    /**
     * new instance user service
     *
     * @param userRepository
     *         user repository
     * @param companyRepository
     *         company repository
     */
    public UserService(final UserRepository userRepository, final CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }


    public UserEntity findById(final String id, final UserDetailDto userDetailDto) {
        final var user = userRepository.findByPrimaryKey(id).orElseThrow();
        final var genderEnum = GenderEnum.of(user.getGender());
        final var company = companyRepository.findByPrimaryKey(user.getCompanyId());
        return new UserEntity(user.getId(), user.getLoginId(), user.getName(), user.getMail(), genderEnum, company,
                user.getLockout());
    }

}
