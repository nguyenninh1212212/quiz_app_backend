package App.dto.User;

import App.model.User;
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
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.username = username;
    }
}
