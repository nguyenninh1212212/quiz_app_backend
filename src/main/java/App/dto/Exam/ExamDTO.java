package App.dto.Exam;

import App.dto.User.UserDTO;
import App.model.entity.Comment;

import lombok.*;

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
