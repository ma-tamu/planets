package jp.co.project.planets.pleiades.repository;

import jp.co.project.planets.pleiades.db.dao.CompanyDao;
import jp.co.project.planets.pleiades.model.entity.CompanyEntity;
import org.springframework.stereotype.Repository;

/**
 * company repository
 */
@Repository
public class CompanyRepository {

    private final CompanyDao companyDao;

    private final CountryRepository countryRepository;

    /**
     * new instance company repository
     *
     * @param companyDao
     *         company dao
     * @param countryRepository
     *         country repository
     */
    public CompanyRepository(final CompanyDao companyDao, final CountryRepository countryRepository) {
        this.companyDao = companyDao;
        this.countryRepository = countryRepository;
    }

    /**
     * find by primary key
     *
     * @param id
     *         id
     * @return company entity
     */
    public CompanyEntity findByPrimaryKey(final String id) {
        final var company = companyDao.selectById(id);
        final var country = countryRepository.findByPrimaryKey(company.getCountryId());
        return new CompanyEntity(company.getId(), company.getName(), country);
    }

}
