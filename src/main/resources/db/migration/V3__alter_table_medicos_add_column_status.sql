alter table medicos add status tinyint not null;

update medicos set status = 1;

alter table medicos modify column status tinyint not null;