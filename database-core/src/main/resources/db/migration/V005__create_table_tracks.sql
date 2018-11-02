create table if not exists tracks (
    id serial primary key,
    tracks_tracks varchar not null,
    talks_id integer,
    days_id integer,
    timeslots_id integer,
    rooms_id integer
--     FOREIGN KEY (talks_id) REFERENCES talks(id),
--     FOREIGN KEY (days_id) REFERENCES days(id),
--     FOREIGN KEY (timeslots_id) REFERENCES timeslots(id),
--     FOREIGN KEY (rooms_id) REFERENCES rooms(id);
    );
