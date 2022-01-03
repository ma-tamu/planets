SELECT
  /*%expand*/*
FROM
  oauth_client_consent
WHERE
  registered_client_id = /* clientId */'a'
  AND principal_name = /* userId */'a'
