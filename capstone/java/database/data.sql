BEGIN TRANSACTION;

INSERT INTO family_account (family_id, family_name) VALUES (5001, 'Smith');
INSERT INTO family_account (family_id, family_name) VALUES (5002, 'Apple');

INSERT INTO users (username,is_parent,family_id,password_hash,role) VALUES ('user1',true,5001,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id,password_hash,role) VALUES ('user2',true,5002,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,password_hash,role) VALUES ('user3',false,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,password_hash,role) VALUES ('user4',false,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,password_hash,role) VALUES ('admin',true,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO library (book_id,isbn,book_title,book_author,cover_img,genre) VALUES (9001, 9001, 'Book 1', 'Bob Smith', 'www.picture.com','bad');
INSERT INTO library (book_id,isbn,book_title,book_author,cover_img,genre) VALUES (9002, 9002, 'Book 2', 'Bob Smith', 'www.picture.com','bad');
INSERT INTO library (book_id,isbn,book_title,book_author,cover_img,genre) VALUES (9003, 9003, 'Book 3', 'Bob Smith', 'www.picture.com','bad');

INSERT INTO reading_activity (activity_id,user_id,isbn,minutes_read) VALUES (6001, 3, 9001,8);
INSERT INTO reading_activity (activity_id,user_id,isbn,minutes_read) VALUES (6002, 2, 9001,9);

COMMIT TRANSACTION;
