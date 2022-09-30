BEGIN TRANSACTION;

INSERT INTO family_account (family_id, family_name) VALUES (5001, 'Smith');
INSERT INTO family_account (family_id, family_name) VALUES (5002, 'Apple');

INSERT INTO users (username,is_parent,family_id,password_hash,role) VALUES ('user1',true,5001,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id,password_hash,role) VALUES ('user2',true,5002,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,password_hash,role) VALUES ('user3',false,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,password_hash,role) VALUES ('user4',false,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,password_hash,role) VALUES ('admin',true,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO library (book_id,isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9001, 9780062368683, 'To Kill A Mockingbird', 'Harper Lee', 'www.picture.com','bad', 5001);
INSERT INTO library (book_id,isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9002, 9781603095020, 'Animal Stories', 'Peter Hoey', 'www.picture.com','bad', 5002);
INSERT INTO library (book_id,isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9003, 9003, 'Book 3', 'Bob Smith', 'www.picture.com','bad', 5002);

INSERT INTO format (format_id, format_type) VALUES (0, 'other');
INSERT INTO format (format_id, format_type) VALUES (1, 'paper');
INSERT INTO format (format_id, format_type) VALUES (2, 'digital');
INSERT INTO format (format_id, format_type) VALUES (3, 'audiobook');
INSERT INTO format (format_id, format_type) VALUES (4, 'read-aloud (reader)');
INSERT INTO format (format_id, format_type) VALUES (5, 'read-aloud (listener)');

INSERT INTO reading_activity (activity_id,user_id,isbn,minutes_read,format_id) VALUES (6001, 3, 9780062368683, 8, 0);
INSERT INTO reading_activity (activity_id,user_id,isbn,minutes_read,format_id) VALUES (6002, 2, 9781603095020, 9, 0);

COMMIT TRANSACTION;
