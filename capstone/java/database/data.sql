BEGIN TRANSACTION;

INSERT INTO family_account (family_name) VALUES ('Smith');
INSERT INTO family_account (family_name) VALUES ('Apple');

INSERT INTO users (username,is_parent,family_id,password_hash,role) VALUES ('user1',true,1001,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id,password_hash,role) VALUES ('user2',true,1002,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id,password_hash,role) VALUES ('user3',false, 1001, '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id,password_hash,role) VALUES ('user4',false,1001,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id,password_hash,role) VALUES ('admin',true,1002,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO library (isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9780062368683, 'To Kill A Mockingbird', 'Harper Lee', 'www.picture.com','bad', 1001);
INSERT INTO library (isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9781603095020, 'Animal Stories', 'Peter Hoey', 'www.picture.com','bad', 1002);
INSERT INTO library (isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9780394800165, 'Green Eggs and Ham', 'Dr. Seuss', 'www.picture.com','bad', 1002);

INSERT INTO format (format_id, format_type) VALUES (0, 'other');
INSERT INTO format (format_id, format_type) VALUES (1, 'paper');
INSERT INTO format (format_id, format_type) VALUES (2, 'digital');
INSERT INTO format (format_id, format_type) VALUES (3, 'audiobook');
INSERT INTO format (format_id, format_type) VALUES (4, 'read-aloud (reader)');
INSERT INTO format (format_id, format_type) VALUES (5, 'read-aloud (listener)');

INSERT INTO reading_activity (user_id,isbn,minutes_read,format_id) VALUES (2, 9780062368683, 8, 0);
INSERT INTO reading_activity (user_id,isbn,minutes_read,format_id) VALUES (1, 9781603095020, 9, 0);
INSERT INTO reading_activity (user_id,isbn,minutes_read,format_id) VALUES (1, 9781603095020, 9, 0);

INSERT INTO prizes (family_id,name, description, goal, stock, start_date, end_date) VALUES (1001,'Ice Cream', 'Creamy ice', 60, 3, '2022-09-20', '2022-09-30');
INSERT INTO prizes (family_id,name, description, goal, stock, start_date, end_date) VALUES (1001,'Bike', 'Bihicular Vehicle', 300, 3, '2022-09-15', '2022-10-30');
INSERT INTO prizes (family_id,name, description, goal, stock, start_date, end_date) VALUES (1002,'Food', 'No food if you dont read', 60, 3, '2022-09-20', '2022-09-30');

COMMIT TRANSACTION;
