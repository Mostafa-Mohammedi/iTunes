-- create the column remove the constraint if there already and add the one to many relation ship
alter table assistant
drop constraint if exists fk_assistant,
add column if not exists superhero_id int not null,
add constraint fk_assistant foreign key (superhero_id) references superhero (superhero_id);
