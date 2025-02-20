package App.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "test_score",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "exam_id"})
)
public class TestScore {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double score;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
}
