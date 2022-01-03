insert into permission (id, name, created_at, created_by, updated_at, update_by, is_deleted)
values ('ec8d5aae34d111ec91c10242ac120003', 'view_all_user', now(), 'NULL', now(), 'NULL', 0),
       ('c90c9f44366411ecb2920242ac120002', 'edit_all_user', now(), 'NULL', now(), 'NULL', 0),
       ('22459e55366511ecb2920242ac120002', 'view_all_client', now(), 'NULL', now(), 'NULL', 0),
       ('2720e684366511ecb2920242ac120002', 'edit_all_client', now(), 'NULL', now(), 'NULL', 0);

INSERT INTO `grant_type` (`id`, `type`, `created_at`, `created_by`, `updated_at`, `update_by`, `is_deleted`)
VALUES ('1b6a0d2a65f911ec8a0b0242ac120003', 'authorization_code', now(), 'NULL', now(), 'NULL', 0),
       ('f35c63dd660c11ec8a0b0242ac120003', 'implicit', now(), 'NULL', now(), 'NULL', 0),
       ('fdc24af6660c11ec8a0b0242ac120003', 'refresh_token', now(), 'NULL', now(), 'NULL', 0),
       ('092519c3660d11ec8a0b0242ac120003', 'client_credentials', now(), 'NULL', now(), 'NULL', 0),
       ('0f4c8f7b660d11ec8a0b0242ac120003', 'password', now(), 'NULL', now(), 'NULL', 0);

INSERT INTO `scope` (`id`, `name`, `created_at`, `created_by`, `updated_at`, `update_by`, `is_deleted`)
VALUES ('a85c1c6665fc11ec8a0b0242ac120003', 'open_id', now(), 'NULL', now(), 'NULL', 0),
       ('15b4a732660d11ec8a0b0242ac120003', 'me', now(), 'NULL', now(), 'NULL', 0);

INSERT INTO `oauth_client` (`id`, `name`, `client_id`, `client_secret`, `created_at`, `created_by`, `updated_at`,
                            `update_by`, `is_deleted`)
VALUES ('5e7abd95663011ec8a0b0242ac120003', 'mars', '34a10a88cbc2cfab10f4262e09439efec7e76a34e1b28687f0a19d43d3e76f4d',
        'c103fb40ee6d955024b7319b29fc4ad44e8c4c4a3c160b6a6075c00b39bd1991', now(), 'NULL', now(), 'NULL', 0);

INSERT INTO `oauth_client_grant_type` (`id`, `oauth_client_id`, `grant_type_id`)
VALUES (replace(uuid(), '-', ''), '5e7abd95663011ec8a0b0242ac120003', '1b6a0d2a65f911ec8a0b0242ac120003'),
       (replace(uuid(), '-', ''), '5e7abd95663011ec8a0b0242ac120003', 'fdc24af6660c11ec8a0b0242ac120003'),
       (replace(uuid(), '-', ''), '5e7abd95663011ec8a0b0242ac120003', '092519c3660d11ec8a0b0242ac120003');


INSERT INTO `oauth_client_scope` (`id`, `oauth_client_id`, `scope_id`)
VALUES (replace(uuid(), '-', ''), '5e7abd95663011ec8a0b0242ac120003', 'a85c1c6665fc11ec8a0b0242ac120003'),
       (replace(uuid(), '-', ''), '5e7abd95663011ec8a0b0242ac120003', 'a85cc25165fc11ec8a0b0242ac120003')
;

INSERT INTO `oauth_client_redirect_url`(`id`, `oauth_client_id`, `redirect_url`, `created_at`, `created_by`,
                                        `updated_at`, `update_by`, `is_deleted`)
VALUES ('fabfbc406c4611ecb1b80242ac120002', '5e7abd95663011ec8a0b0242ac120003',
        'http://127.0.0.1:8082/mars/swagger-ui/oauth2-redirect.html', now(), 'NULL', now(), 'NULL', 0);


INSERT INTO `user` (`id`, `login_id`, `name`, `gender`, `mail`, `password`, `lockout`, `office_id`,
                    `created_by`, `update_by`, `is_deleted`)
VALUES ('NULL', 'admin', 'Administrator', 'M', 'a@a.com',
        '$2a$10$IfIpdWUeKUBFd0pN6dRV/.4IT3Lsln5zuw8bZgiV.nTH/RbVRlxP2', b'0', b'0', 'NULL', 'NULL', 0);