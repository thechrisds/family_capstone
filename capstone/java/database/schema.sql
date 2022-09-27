BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, family_account, library, reading_activity, prizes CASCADE;

DROP SEQUENCE IF EXISTS seq_user_id, seq_family_id, seq_library_id, seq_activity_id, seq_prizes_id;

CREATE TABLE family_account (
    family_id serial,
    family_name varchar(50) NOT NULL,
    CONSTRAINT PK_family_account PRIMARY KEY (family_id)
);

CREATE SEQUENCE seq_family_id
INCREMENT BY 1
START WITH 1001
NO MAXVALUE;

CREATE SEQUENCE seq_user_id
    INCREMENT BY 1
    START WITH 1
    NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	family_id int,
	is_parent boolean NOT NULL DEFAULT false,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) DEFAULT 'ROLE_USER',
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT FK_family_account_family_id FOREIGN KEY (family_id) REFERENCES family_account (family_id)
);

CREATE SEQUENCE seq_library_id
INCREMENT BY 1
START WITH 2001
NO MAXVALUE;

CREATE TABLE library (
    book_id int NOT NULL DEFAULT nextval('seq_library_id'),
	isbn numeric NOT NULL UNIQUE,
    book_title varchar (100) NOT NULL UNIQUE,
    book_author varchar (50) NOT NULL,
    cover_img varchar(200),
    genre varchar (50) NOT NULL,
    description varchar (200),
    CONSTRAINT PK_library PRIMARY KEY (isbn)
);

CREATE SEQUENCE seq_activity_id
    INCREMENT BY 1
    START WITH 3001
    NO MAXVALUE;

CREATE TABLE reading_activity (
    activity_id int NOT NULL DEFAULT nextval('seq_activity_id'),
    user_id int NOT NULL,
    isbn int NOT NULL,
    minutes_read int DEFAULT 0,
    date_read timestamp,
    notes varchar (250),
    completed boolean DEFAULT false,
    CONSTRAINT PK_reading_activity PRIMARY KEY (activity_id),
    CONSTRAINT FK_family_account_users FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_library FOREIGN KEY (isbn) REFERENCES library (isbn)
);

CREATE SEQUENCE seq_prizes_id
    INCREMENT BY 1
    START WITH 4001
    NO MAXVALUE;

CREATE TABLE prizes (
    family_id int NOT NULL,
    prizes_id int NOT NULL DEFAULT nextval('seq_activity_id'),
    name varchar (50) NOT NULL,
    description varchar (200) NOT NULL,
    eligible int NOT NULL,
    stock int NOT NULL,
    start_date varchar (20) NOT NULL,
    end_date varchar (20),
    CONSTRAINT PK_prizes PRIMARY KEY (prizes_id),
    CONSTRAINT FK_family_id FOREIGN KEY (family_id) REFERENCES family_account (family_id)
);


COMMIT TRANSACTION;

--ROLLBACK;