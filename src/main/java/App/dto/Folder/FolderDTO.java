package App.dto.Folder;

import App.model.entity.Folder;
import App.model.entity.Save;
import App.model.entity.Users;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
public class FolderDTO {
    private UUID id;
    private String name;
    private Users user;
    private Save save;

    public FolderDTO(Folder folder) {
        this.id = folder.getId();
        this.name = folder.getName();
        this.user = folder.getUser();
        this.save = folder.getSave();
    }

}
