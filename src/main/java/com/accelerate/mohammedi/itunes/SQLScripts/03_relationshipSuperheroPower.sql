/*
 dropping the table if exist so i can recreate the table 
 creating the linking table for superhero assistant relationship
 altering table to add the column and is empty and constraint aswell the primary keys
*/


drop table if exists superhero_assisten;

create table superhero_assisten (
	
);


alter table superhero_assisten
	add column if not exists superhero_id int not null,
	add column if not exists assistant_id int not null,
	add constraint fk_hero_assistant foreign key (superhero_id) references superhero (superhero_id),
	add constraint fk_assistant_superhero foreign key (assistant_id) references assistant (assistant_id),
	add primary key (superhero_id, assistant_id);

	