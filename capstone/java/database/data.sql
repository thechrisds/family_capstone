BEGIN TRANSACTION;

INSERT INTO family_account (family_name) VALUES ('Smith');
INSERT INTO family_account (family_name) VALUES ('Apple');

INSERT INTO users (username,is_parent,family_id, total_minutes, password_hash,role) VALUES ('Tom',true,1001,5,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id, total_minutes, password_hash,role) VALUES ('user1',true,1001,25,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id, total_minutes, password_hash,role) VALUES ('user2',true,1002,100,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id, total_minutes, password_hash,role) VALUES ('user3',true,1002,3000,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id, total_minutes, password_hash,role) VALUES ('Edward',true,1002,5,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id, total_minutes, password_hash,role) VALUES ('Jane',false, 1001,15, '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id, total_minutes, password_hash,role) VALUES ('Chunk',false,1001,25,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,is_parent,family_id, total_minutes, password_hash,role) VALUES ('admin',true,1001,100,'$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO library (isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9780439708180, 'Harry Potter and the Wizard Stone Thing', 'J.K. Rowling', 'www.picture.com','wizards!', 1001);
INSERT INTO library (isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9780345538987, 'DinoSaur Park', 'Mike Chrichton', 'www.picture.com','pretty okay, they made a movie', 1002);
INSERT INTO library (isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9780358653035, 'Lord of the Rings', 'Jolken Rolken Rolken Tolkien', 'www.picture.com','dwarves!', 1002);
INSERT INTO library (isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9780812979688, 'Antifragile', 'Nassim Tab', 'www.picture.com','smart people stuff', 1001);
INSERT INTO library (isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9781603095020, 'Animal Stories', 'Peter Hoey', 'www.picture.com','not bad', 1002);
INSERT INTO library (isbn,book_title,book_author,cover_img,genre, family_id) VALUES (9780394800165, 'Green Eggs and Ham', 'Dr. Seuss', 'www.picture.com','not great', 1002);

INSERT INTO format (format_id, format_type) VALUES (0, 'other');
INSERT INTO format (format_id, format_type) VALUES (1, 'paper');
INSERT INTO format (format_id, format_type) VALUES (2, 'digital');
INSERT INTO format (format_id, format_type) VALUES (3, 'audiobook');
INSERT INTO format (format_id, format_type) VALUES (4, 'read-aloud (reader)');
INSERT INTO format (format_id, format_type) VALUES (5, 'read-aloud (listener)');

INSERT INTO reading_activity (user_id,book_id,minutes_read,format_id) VALUES (2, 9001, 8, 0);
INSERT INTO reading_activity (user_id,book_id,minutes_read,format_id) VALUES (1, 9004, 9, 0);
INSERT INTO reading_activity (user_id,book_id,minutes_read,format_id) VALUES (1, 9005, 9, 0);

INSERT INTO prizes (family_id,name, description, goal, stock, start_date, end_date) VALUES (1001,'Ice Cream', 'Creamy ice', 60, 3, '2022-09-20', '2022-09-30');
INSERT INTO prizes (family_id,name, description, goal, stock, start_date, end_date) VALUES (1001,'Bike', 'Bihicular Vehicle', 300, 3, '2022-09-15', '2022-10-30');
INSERT INTO prizes (family_id,name, description, goal, stock, start_date, end_date) VALUES (1002,'Food', 'No food if you dont read', 60, 3, '2022-09-20', '2022-09-30');

COMMIT TRANSACTION;
