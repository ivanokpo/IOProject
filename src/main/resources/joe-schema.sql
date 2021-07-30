drop table if exists podcasts CASCADE;
create table podcasts 
(
	id integer PRIMARY KEY AUTO_INCREMENT,
	podcast_Number integer not null, 
	guests varchar(255), 
	category varchar(255) not null,
	rating integer not null,
	favorite varchar(255)

);