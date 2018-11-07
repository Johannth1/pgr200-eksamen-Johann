package no.kristiania.prg200.database.core;

import java.sql.Time;
import java.util.Objects;

public class Timeslots {
    Long id;
    private String time;


    public Timeslots(Long id, String time) {
        this.id = id;
        this.time = time;

    }

    public Timeslots() {
        this.id = id;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Timeslots)){
            return false;
        }
        Timeslots otherTimeslots =(Timeslots) o;
        return Objects.equals(time, otherTimeslots.time)
                && Objects.equals(id, otherTimeslots.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, id);
    }

        @Override
        public String toString () {

        return getClass().getSimpleName() + "{ Timeslot = " + time
                                          + ", ID = "       + id
                                          + " }";
        }

}