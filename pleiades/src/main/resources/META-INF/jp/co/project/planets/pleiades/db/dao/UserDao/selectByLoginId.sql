select
  /*%expand*/*
from user
where login_id = /* loginId */'a'
  and is_deleted = 0