package App.dto.User;

import App.dto.Farvorite.FavoriteDTO;
import App.dto.Folder.FolderDTO;
import App.model.entity.Favorite;
import App.model.entity.Folder;
import App.model.entity.Notification;
import App.model.entity.User;
import jakarta.persistence.Entity;
import lombok.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class UserDTO {
    private String fullname;
    private List<FavoriteDTO> favorites;
    private List<FolderDTO> folders;
    private List<Notification> notifications;
    private LocalDateTime createdAt;

    public UserDTO(User user) {
        this.fullname = user.getFullname();
        this.favorites = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }
}
