package App.dto.Farvorite;

import App.model.entity.Exam;
import App.model.entity.Favorite;
import App.model.entity.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
public class FavoriteDTO {
    private UUID id;
    private Users user;
    private Exam exam;
    public FavoriteDTO(Favorite favorite) {
        this.id = favorite.getId();
        this.user = favorite.getUser();
        this.exam = favorite.getExam();
    }
}
