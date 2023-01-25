-- create the database
-- CREATE DATABASE SuperheroesDb;

-- drop table script to check if the table doesnt exist in the SuperheroesDb

drop table if exists Superhero, assistant, power;

/*
 create the super hero table with the id as primary key and auto increment.
 name and alies cannot be same if alias is not null
 the length of the name, alias and origin are 50 character 
*/
create table if not exists Superhero(
	superhero_id serial primary key,
	name varchar(150),
	alias varchar(150),
	origin varchar(150)
);

/*
 create the assistant table with the id as primary key and auto increment.
 name and alies cannot be same if alias is not null
 the length of the name is  50 character.
*/

create table if not exists assistant(
	assistant_id serial primary key,
	name varchar(150)
);

/*
 create the assistant table with the id as primary key and auto increment.
 name and alies cannot be same if alias is not null
 the length of the name is 50 character
 the length of the description is 200
*/

create table if not exists power(
	power_id serial primary key,
	name varchar(150),
	description varchar(250)
	
);
