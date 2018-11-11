create table if not exists talks (
    talks_id serial primary key references tracks(talks_id),
    talks_title varchar not null,
    talks_topic varchar not null,
    talks_description varchar not null
);
