package   包 com.todonow.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class   类 Task   任务 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   私人 Long id;
    private   私人 String title;
    private   私人 String description   描述;
    private   私人 LocalDateTime createdAt;
    private   私人 LocalDateTime dueDate;
    private   私人 boolean completed   完成;

    // Constructors, getters, and setters
}


