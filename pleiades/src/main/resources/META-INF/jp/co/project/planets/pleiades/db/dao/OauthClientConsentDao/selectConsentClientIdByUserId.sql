SELECT
  /*%expand*/*
FROM
  oauth_client_consent
WHERE
  oauth_client_id = /* clientId */'a'
  AND user_id = /* userId */'a'
  AND is_deleted = 0