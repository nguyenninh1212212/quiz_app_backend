package App.service;

import App.dto.User.AuthRegDTO;
import App.model.entity.Users;
import App.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Xử lý nghiệp vụ, gọi repository để lấy dữ liệu
@Service
public class UserServ {
    //@Autowired dùng để tự động tiêm (inject) dependency vào các component mà không cần khởi tạo thủ công.
    private final UserRepo userRepo;


    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServ(UserRepo userRepo,BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public String Register(AuthRegDTO req) {
        try{
            List<String> errors = new ArrayList<>();
            if (req.getUsername().length() < 6) errors.add("Username must be at least 6 characters.");
            if (req.getPassword().length() < 6) errors.add("Password must be at least 6 characters.");
            String passwordHash = passwordEncoder.encode(req.getPassword());
            Users user = new Users().builder().username(req.getUsername()).password(passwordHash).email(req.getEmail()).fullname(req.getFullName()).build();
            userRepo.save(user);
            return "Đăng ký thành công!!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
