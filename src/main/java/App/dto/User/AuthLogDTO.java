package App.dto.User;

import App.model.User;
import lombok.NoArgsConstructor;

//DTO sex lấy ra những dữ liệu mình cần ,ở đây Auth mình sẽ là dữ liệu để đăng nhập

@NoArgsConstructor
public class AuthLogDTO {
    private String username;
    private String password;

    public AuthLogDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
