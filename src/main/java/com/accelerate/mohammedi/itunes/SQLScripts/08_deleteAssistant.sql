select * from assistant;
-- select statement to check all the powr 
select * from power;
-- select statement to check all the superheroes
select * from superhero;
-- select statement to check all the superhero power
select * from superhero_power;


-- delete statement for deleting a assistant by name and returning the deleted column
delete from assistant
where name = 'Aqua woman'
returning *;