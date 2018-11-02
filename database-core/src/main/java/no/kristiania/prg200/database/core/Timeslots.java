package no.kristiania.prg200.database.core;

import java.sql.Time;
import java.util.Objects;

public class Timeslots {
    private String time;
    Long id;

    public Timeslots() {
        this.time = time;
        this.id = id;
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
            return getClass().getSimpleName() + "{time=" + time + ",id=" + id + "}";
        }

}