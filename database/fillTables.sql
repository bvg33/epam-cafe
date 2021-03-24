USE epamweb;

/*--------------filling in the table "users"---------------------*/

INSERT INTO users (login, password, name, points, cardnumber,role)
VALUES ('user', SHA1('user'), 'Dima', '20', '1111 1111 1111 1111','USER');

INSERT INTO users (login, password, name, points, cardnumber,role)
VALUES ('admin', SHA1('admin'), 'Dima', '15', '1111 1111 1111 1111','ADMIN');


/*--------------filling in the table "menu"---------------------*/

INSERT INTO menu (name, price, photo)
VALUES ('Capuccino', '3 BYN','65a19997-1990-4594-a360-66f26d0c05f7cappuccino.jpg');

INSERT INTO menu (name, price, photo)
VALUES ('Kakao', '2 BYN','a929963d-5b95-4243-9cd3-562ed0bb8aefkakao.jpg');

INSERT INTO menu (name, price, photo)
VALUES ('Latte', '4 BYN','54f17d0c-4092-4a49-a977-5b32487fca15latte.jpg');

INSERT INTO menu (name, price, photo)
VALUES ('Sandwich', '3 BYN','d3c09704-80cb-477a-802c-b0c8a25fb306sandwich.jpg');

INSERT INTO menu (name, price, photo)
VALUES ('Cheescake', '6 BYN','f75f8a9b-b353-43d6-9ca6-695df09dde7ccheescake.jpg');

INSERT INTO menu (name, price, photo)
VALUES ('Tea', '1 BYN','eb6fbcab-c47d-49e7-9d9f-74c970b0d303tea.jpg');

INSERT INTO menu (name, price, photo)
VALUES ('Cake', '4 BYN','38423b5d-83cf-414e-9fe6-b32d1065cb09cake.jpg');