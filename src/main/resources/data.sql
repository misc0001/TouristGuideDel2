CREATE SCHEMA IF NOT EXISTS touristguide;

SET SCHEMA touristguide;

drop table if exists touristattraction;
CREATE TABLE touristattraction(
                                  id integer auto_increment PRIMARY KEY,
                                  tname varchar(100),
                                  tdescription varchar(100),
                                  city varchar(100),
                                  tags varchar(255)
);

insert into touristattraction (tname,tdescription,city,tags) values ('Amalienborg Slot', 'Slot', 'København', 'børnevenlig');
insert into touristattraction (tname,tdescription,city,tags) values ('Tivoli', 'Forlystelsespark', 'København', 'børnevenlig');
insert into touristattraction (tname,tdescription,city,tags) values ('Fredensborg Slot', 'Slot', 'København', 'Gratis');
insert into touristattraction (tname,tdescription,city,tags) values ('København Zoo', 'Zoo', 'København', 'Natur');
commit;