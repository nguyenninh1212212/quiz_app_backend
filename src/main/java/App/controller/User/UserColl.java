package App.controller.User;

import App.dto.User.AuthRegDTO;
import App.model.User;
import App.service.User.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserColl {

    @Autowired
    private UserServ userServ;

    @PostMapping("/auth/register")
    public ResponseEntity<?> Register(@RequestBody AuthRegDTO authRegDTO) {
        try {
            String isRegistered = userServ.Register(authRegDTO);
            return ResponseEntity.ok(Map.of("Message", "Đăng ký thành công","data",isRegistered));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("Error", "Lỗi hệ thống: " + e.getMessage()));
        }
    }
}
