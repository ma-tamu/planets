package jp.co.project.planets.pleiades.repository;

import jp.co.project.planets.pleiades.db.dao.CountryDao;
import jp.co.project.planets.pleiades.db.dao.LanguageDao;
import jp.co.project.planets.pleiades.db.dao.RegionDao;
import jp.co.project.planets.pleiades.model.entity.CountryEntity;
import jp.co.project.planets.pleiades.model.entity.LanguageEntity;
import jp.co.project.planets.pleiades.model.entity.RegionEntity;
import org.springframework.stereotype.Repository;

/**
 * country repository
 */
@Repository
public class CountryRepository {

    private final CountryDao countryDao;
    private final LanguageDao languageDao;
    private final RegionDao regionDao;


    /**
     * new instance country repository
     *
     * @param countryDao
     *         country dao
     * @param languageDao
     *         language dao
     * @param regionDao
     *         region dao
     */
    public CountryRepository(final CountryDao countryDao, final LanguageDao languageDao, final RegionDao regionDao) {
        this.countryDao = countryDao;
        this.languageDao = languageDao;
        this.regionDao = regionDao;
    }

    /**
     * find by primary key
     *
     * @param id
     *         id
     * @return country
     */
    public CountryEntity findByPrimaryKey(final String id) {
        final var country = countryDao.selectById(id);
        final var language = languageDao.selectById(country.getLanguageId());
        final var region = regionDao.selectById(country.getRegionId());
        final var languageRecord = new LanguageEntity(language.getId(), language.getName());
        final var regionRecord = new RegionEntity(region.getId(), region.getName());
        return new CountryEntity(country.getId(), country.getName(), languageRecord, regionRecord);
    }
}
