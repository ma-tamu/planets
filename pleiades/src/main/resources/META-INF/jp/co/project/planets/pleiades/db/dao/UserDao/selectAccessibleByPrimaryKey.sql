SELECT *
FROM user
       LEFT OUTER JOIN company on company.id = user.company_id
       LEFT OUTER JOIN country on company.country_id = country.id
       LEFT OUTER JOIN language on country.language_id = language.id
       LEFT OUTER JOIN region on country.region_id = region.id
WHERE user.id = /*id*/'1'
  AND user.is_deleted = 0