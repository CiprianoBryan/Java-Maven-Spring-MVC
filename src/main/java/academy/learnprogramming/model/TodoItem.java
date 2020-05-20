package academy.learnprogramming.model;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {
    // == fields ==
    private int id;
    private String title;
    private String details;
    private LocalDate deadLine;

    public TodoItem(int id, String title, String details, LocalDate deadLine) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.deadLine = deadLine;
    }
}
