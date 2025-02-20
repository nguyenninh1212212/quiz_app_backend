package App.controller.User;

import App.dto.User.AuthLogDTO;
import App.dto.User.AuthRegDTO;
import App.model.entity.Users;
import App.service.JwtService;
import App.service.UserServ;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class UserColl {

    @Autowired
    private UserServ userServ;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtSer;

    @PostMapping("/auth/register")
    public ResponseEntity<?> Register(@RequestBody AuthRegDTO authRegDTO) {
        try {
            String isRegistered = userServ.Register(authRegDTO);
            return ResponseEntity.ok(Map.of("Message", "Đăng ký thành công","data",isRegistered));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("Error", "Lỗi hệ thống: " + e.getMessage()));
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> Login(@RequestBody AuthLogDTO req, HttpServletResponse response) {
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
            if (auth.isAuthenticated()) {
                String accessToken = jwtSer.generateAccessToken(req.getUsername());
                String refreshToken = jwtSer.generateRefreshToken(req.getUsername());

                // Đặt cookie chứa token
                Cookie cookie = new Cookie("token", accessToken);
                cookie.setHttpOnly(false);
                cookie.setSecure(false);
                cookie.setPath("/");
                cookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(cookie);

                    return ResponseEntity.ok(Map.of(
                        "accessToken", accessToken,
                        "refreshToken", refreshToken
                ));
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Login failed"));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("Error", "Lỗi hệ thống: " + e.getMessage()));
        }
    }
}
