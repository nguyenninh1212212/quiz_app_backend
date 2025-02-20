package App.dto.Folder;

import App.model.entity.Folder;
import App.model.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
public class FolderDTO {
    private UUID id;
    private String name;
    private User user;

    public FolderDTO(Folder folder) {
        this.id = folder.getId();
        this.name = folder.getName();
        this.user = folder.getUser();
    }

}
