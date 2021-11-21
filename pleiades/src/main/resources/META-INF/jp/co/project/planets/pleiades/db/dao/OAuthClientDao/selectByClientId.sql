SELECT
  /*%expand*/*
FROM
  oauth_client
WHERE
  client_id = /* clientId */'a'
  AND is_deleted = 0