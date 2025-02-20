package App.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    private Users user;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] docs;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    private int count;
    private int favourite;
    private LocalDateTime created;
    private LocalDateTime updated;
}
