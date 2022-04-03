SELECT permission.*
FROM permission
       INNER JOIN role_permission rp on permission.id = rp.permission_id
       INNER JOIN role r on rp.role_id = r.id
       INNER JOIN user_role ur on r.id = ur.role_id
WHERE ur.user_id = /* userId */''
  AND r.is_deleted = 0
  AND permission.is_deleted = 0
ORDER BY permission.id