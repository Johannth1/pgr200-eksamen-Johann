package no.kristiania.prg200.database.core;

import java.util.Objects;


public class Rooms {
    Long id;
    private String room;

    public Rooms(Long id, String room) {
        this.id = id;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rooms)){
            return false;
        }
        Rooms otherRooms =(Rooms) o;
        return Objects.equals(room, otherRooms.room)
                && Objects.equals(id, otherRooms.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, id);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "{id=" + id + ",room=" + room + "}";
    }

}