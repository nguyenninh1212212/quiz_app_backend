package App.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class School {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "school",cascade = CascadeType.ALL)
    private List<Exam> exams;

}
