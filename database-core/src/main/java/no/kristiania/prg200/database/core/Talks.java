package no.kristiania.prg200.database.core;

import java.util.Objects;

public class Talks {


    private String title, description, topic;
    private Long id;

    public Talks() {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Talks)){
            return false;
        }
        Talks otherTalks =(Talks) o;
        return Objects.equals(title, otherTalks.title)
                && Objects.equals(description, otherTalks.description)
                && Objects.equals(topic, otherTalks.topic)
                && Objects.equals(id, otherTalks.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, topic, id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{title="   + title     + ",description="
                                          + description + ",topic=" + topic
                                          + "id=" + id  + "}";
    }
}
