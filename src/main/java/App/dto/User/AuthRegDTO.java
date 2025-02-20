package App.dto.User;

import App.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AuthRegDTO {
    private String username;
    private String password;
    private String email;
    private String fullName;

    public AuthRegDTO(User user) {
        this.email = user.getEmail();
        this.fullName = user.getFullname();
        this.password = user.getPassword();
        this.username = getUsername();
    }
}
