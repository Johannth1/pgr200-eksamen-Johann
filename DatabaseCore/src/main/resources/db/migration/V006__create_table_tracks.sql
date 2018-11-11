create table if not exists tracks (
    tracks_id serial primary key,
    tracks_tracks varchar not null,
    talks_id integer not null,
    days_id integer not null,
    timeslots_id integer not null,
    rooms_id integer not null
--     FOREIGN KEY (talks_id) REFERENCES talks(talks_id)
--     FOREIGN KEY (days_id) REFERENCES days(id),
--     FOREIGN KEY (timeslots_id) REFERENCES timeslots(id),
--     FOREIGN KEY (rooms_id) REFERENCES rooms(id);
    );