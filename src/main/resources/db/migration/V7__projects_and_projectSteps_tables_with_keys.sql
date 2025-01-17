create table projects
(
    id          int primary key auto_increment,
    description varchar(100) not null
);
alter table task_group
    add column project_id int null;
alter table task_group
    add foreign key (project_id) references projects (id);

create table project_steps
(
    id               int primary key auto_increment,
    description      varchar(100) not null,
    project_id       int          not null,
    foreign key (project_id) references projects (id),
    days_to_deadline int          not null
);