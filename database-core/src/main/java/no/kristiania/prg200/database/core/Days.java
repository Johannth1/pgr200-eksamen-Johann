package no.kristiania.prg200.database.core;

import java.util.Objects;

public class Days {

    Long id;
    String days;
    String date;


    public Days(Long id, String days, String date){
        this.id = id;
        this.days = days;
        this.date = date;
    }



    public  String getDays() {
        return days;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setDays(String days) {
        this.days = days;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Days)){
            return false;
        }
        Days otherDays =(Days) o;
        return Objects.equals(days, otherDays.days)
                && Objects.equals(date, otherDays.date)
                && Objects.equals(id, otherDays.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, date, id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{days=" + days
                + ",date=" + date
                + ",id="   + id  + "}";
    }
}
