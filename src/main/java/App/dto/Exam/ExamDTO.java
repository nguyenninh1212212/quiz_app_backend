package App.dto.Exam;

import App.dto.User.UserDTO;
import App.model.entity.Comment;
import App.model.entity.Users;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamDTO {
    private UUID id;
    private UserDTO owner;
    private byte[] docs;
    private List<Comment> comments;
    private LocalDateTime created;
}
