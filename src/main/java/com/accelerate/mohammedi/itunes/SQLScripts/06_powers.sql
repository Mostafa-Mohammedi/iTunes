select * from power;
-- select statement to check all the power

select * from power;
-- select statement to check all the superheroes

select * from superhero;
-- select statement to check all the superhero power
select * from superhero_power;

-- insert  statement to check all the power available
insert into power(name, description)
values 
('running', 'The ability to flee from a fight'),
('hide', 'The ability to hide from the villain'),
('begging', 'The ability to beg for his life'),
('faking', 'The ability to fake being brave ');

-- isnert statement to create the heroes power 
insert into superhero_power(superhero_id, power_id)
values 
(1,1),
(1,2),
(1,3),
(1,4),
(2,1),
(3,1);