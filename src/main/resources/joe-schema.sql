drop table if exists joe CASCADE;
create table joe 
(
	id integer PRIMARY KEY AUTO_INCREMENT,
	podcast_number integer not null, 
	guests varchar(255), 
	category varchar(255) not null,
	rating integer not null,
	favorite varchar(255)

);