create table if not exists talks (
    id serial primary key,
    talks_title varchar not null,
    talks_topic varchar not null,
    talks_description varchar not null
);
