DROP TABLE user IF EXISTS;
CREATE TABLE user (
    user_id VARCHAR PRIMARY KEY
    ,user_name VARCHAR NOT NULL
    ,encoded_password VARCHAR NOT NULL
    ,email VARCHAR NOT NULL
    ,comment VARCHAR
    ,place VARCHAR
    ,birth_day DATE
    ,img_url VARCHAR
);
DROP TABLE tweet IF EXISTS;
CREATE TABLE tweet (
    tweet_id INT PRIMARY KEY auto_increment
    ,content VARCHAR NOT NULL
    ,tweet_user VARCHAR NOT NULL
    ,attachment VARCHAR
    ,favorite INT
    ,retweet INT
    ,reply_to INT
    ,time INT
);
DROP TABLE follow IF EXISTS;
CREATE TABLE follow (
    follow_id VARCHAR NOT NULL
    ,follower_id VARCHAR NOT NULL
    ,block_flag BIT
    ,mute_flag BIT
    ,PRIMARY KEY(follow_id, follower_id)
);
DROP TABLE role IF EXISTS;
CREATE TABLE role (
    user_name VARCHAR NOT NULL
    ,role VARCHAR NOT NULL
    ,PRIMARY KEY(user_name, role)
);
DROP TABLE authority IF EXISTS;
CREATE TABLE authority (
    user_name VARCHAR NOT NULL
    ,authority VARCHAR NOT NULL
    ,PRIMARY KEY(user_name, authority)
);
