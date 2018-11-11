create table if not exists rooms (
    rooms_id serial not null,
    rooms_room varchar not null,
    constraint RoomsIdCreateTable primary key (rooms_id)
);
