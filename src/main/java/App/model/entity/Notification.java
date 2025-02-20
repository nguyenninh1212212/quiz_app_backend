package App.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    @Id
    @UuidGenerator
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String content;
    private String sender;
    private LocalDateTime created;
}
