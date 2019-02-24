INSERT INTO user (user_id, user_name, encoded_password, comment, place, birth_day, img_url) VALUES ('kodaira', 'kodaira', '$2a$10$zFEweFHkCxWQSxOXmO.Rn.IlNeXuyHE8DxLLtPKSntbCXF3ZBLG96', 'hoge', 'Tokyo', 100000, 'example.com');
INSERT INTO user (user_id, user_name, encoded_password, comment, place, birth_day, img_url) VALUES ('hoge', 'hoge', '$2a$10$zFEweFHkCxWQSxOXmO.Rn.IlNeXuyHE8DxLLtPKSntbCXF3ZBLG96', 'hoge', 'Tokyo', 100000, 'example.com');
INSERT INTO follow (follow_id, follower_id, block_flag, mute_flag) VALUES ('kodaira', 'hoge', 1, 0);
INSERT INTO tweet (content, tweet_user, attachment, favorite, retweet, reply_to, time) VALUES ('test message', 'kodaira', 'attachment', 0, 0, 1, 300);
INSERT INTO tweet (content, tweet_user, attachment, favorite, retweet, reply_to, time) VALUES ('アイウエオかきくけこさしすせそたちつてとなにぬねのは皮膚へ保まみむめもやゆよらりるれろわをん', 'hoge', 'attachment', 0, 0, 1, 300);
INSERT INTO role (user_name, role) VALUES ('kodaira', 'USER');
INSERT INTO authority (user_name, authority) VALUES ('kodaira', 'USER');
