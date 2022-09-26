BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS seq_user_id, seq_family_id, seq_library_id, activity_id, prizes_id;

CREATE SEQUENCE seq_user_id
    INCREMENT BY 1
    START WITH 1
    NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_family_id
INCREMENT BY 1
START WITH 1001
NO MAXVALUE;

CREATE TABLE familyAccount (
    family_id int NOT NULL DEFAULT nextval('seq_family_id'),
    parent_id int NOT NULL
    child_id int NOT NULL
    family_name varchar(50) NOT NULL,
    CONSTRAINT PK_familyAccount PRIMARY KEY (family_id),
    CONSTRAINT FK_familyAccount_users FOREIGN KEY (parent_id) REFERENCES users (user_id),
    CONSTRAINT FK_familyAccount_users FOREIGN KEY (child_id) REFERENCES users (user_id)
);


--CREATE SEQUENCE seq_library_id
--INCREMENT BY 1
--START WITH 2001
--NO MAXVALUE;

CREATE TABLE library (
    book_id int NOT NULL DEFAULT nextval('seq_library_id'),
    book_title varchar (100) NOT NULL UNIQUE,
    book_author varchar (50) NOT NULL,
    isbn int NOT NULL UNIQUE,
    cover_img varchar(200),
    genre varchar (50) NOT NULL,
    description varchar (200),
    CONSTRAINT PK_library PRIMARY KEY (isbn),
);

CREATE TABLE reading_activity (
    activity_id int NOT NULL,
    user_id int NOT NULL,
    isbn int NOT NULL,
    minutes_read int NOT NULL,
    date_read timestamp,
    CONSTRAINT PK_reading_activity PRIMARY KEY (activity_id)
    CONSTRAINT FK_familyAccount_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE prizes (
    prizes_id int NOT NULL UNIQUE,
    name varchar (50) NOT NULL,
    description varchar (200) NOT NULL,
    eligible int NOT NULL,
    stock int NOT NULL,
    start_date varchar (20) NOT NULL,
    end_date varchar (20)
    CONSTRAINT PK_prizes PRIMARY KEY (prizes_id)
);


COMMIT TRANSACTION;
