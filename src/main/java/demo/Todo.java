package demo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Todo implements Serializable {
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(columnDefinition = "varchar(36)")
    @Id
    private String id;
    private String title;
    private boolean finished = false;

    public Todo() {
    }

    public Todo(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return "Todo(" + id + ", " + title + ", " + finished + ")";
    }
}