BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, family_account, format, library, reading_activity, prizes CASCADE;

DROP SEQUENCE IF EXISTS seq_user_id, seq_family_id, seq_library_id, seq_activity_id, seq_prizes_id;

CREATE SEQUENCE seq_family_id --use for family instead of serial?
    INCREMENT BY 1
    START WITH 1001
    NO MAXVALUE;


CREATE TABLE family_account (
    family_id int NOT NULL DEFAULT nextval('seq_family_id'),
    family_name varchar(50) NOT NULL,
    CONSTRAINT PK_family_account PRIMARY KEY (family_id)
);



CREATE SEQUENCE seq_user_id
    INCREMENT BY 1
    START WITH 1
    NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	family_id int,
	is_parent boolean NOT NULL DEFAULT false,
	username varchar(50) NOT NULL UNIQUE,
	firstname varchar (50),
    lastname varchar (50),
    total_minutes int DEFAULT 0,
	password_hash varchar(200) NOT NULL,
	role varchar(50) DEFAULT 'ROLE_USER',
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT FK_family_account_family_id FOREIGN KEY (family_id) REFERENCES family_account (family_id)
);

CREATE SEQUENCE seq_library_id
INCREMENT BY 1
START WITH 9001 --changed this from 2001 to 9001, just in case people add a lot of books
NO MAXVALUE;

CREATE TABLE format (
    format_id int NOT NULL DEFAULT 0,
    format_type varchar (30) DEFAULT 'unspecified',
    CONSTRAINT PK_format PRIMARY KEY (format_id)
);

CREATE TABLE library (
    book_id int NOT NULL DEFAULT nextval('seq_library_id'),
	isbn numeric NOT NULL,
    book_title varchar (100) NOT NULL,
    book_author varchar (50) NOT NULL,
    cover_img varchar(200),
    genre varchar (50) DEFAULT ('Other'),
    description varchar (500),
    family_id int,
    deleted boolean DEFAULT (false),
    CONSTRAINT FK_family_account_family_id FOREIGN KEY (family_id) REFERENCES family_account (family_id),
    CONSTRAINT PK_library PRIMARY KEY (book_id)
);

CREATE SEQUENCE seq_activity_id
    INCREMENT BY 1
    START WITH 3001
    NO MAXVALUE;

CREATE TABLE reading_activity (
    activity_id int NOT NULL DEFAULT nextval('seq_activity_id'),
    user_id int NOT NULL,
    book_id int,
    minutes_read int DEFAULT 0,
    date_read  DATE NOT NULL DEFAULT CURRENT_DATE,
    notes varchar (250) DEFAULT 'none',
    format_id int DEFAULT 0,
    completed boolean DEFAULT false,
    CONSTRAINT PK_reading_activity PRIMARY KEY (activity_id),
    CONSTRAINT FK_format FOREIGN KEY (format_id) REFERENCES format (format_id),
	CONSTRAINT FK_library FOREIGN KEY (book_id) REFERENCES library (book_id)
);

CREATE SEQUENCE seq_prizes_id
    INCREMENT BY 1
    START WITH 4001
    NO MAXVALUE;

CREATE TABLE prizes (
    family_id int NOT NULL DEFAULT 0, --changed to DEFAULT 0
    prize_id int NOT NULL DEFAULT nextval('seq_prizes_id'), --was set to seq_activity_id for some reason
    name varchar (50) NOT NULL,
    description varchar (200) NOT NULL,
    goal int NOT NULL, --eligible = goal? (in minutes) if so, will change name to goal/something else
    stock int NOT NULL,
    start_date DATE NOT NULL DEFAULT CURRENT_DATE, --changed from varchar to DATE
    end_date DATE NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT PK_prizes PRIMARY KEY (prize_id),
    CONSTRAINT FK_family_id FOREIGN KEY (family_id) REFERENCES family_account (family_id)
);


COMMIT TRANSACTION;

--ROLLBACK;