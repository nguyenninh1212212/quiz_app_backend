package App.service;

import App.dto.User.AuthRegDTO;
import App.model.entity.User;
import App.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Xử lý nghiệp vụ, gọi repository để lấy dữ liệu
@Service
public class UserServ implements UserDetailsService {
    //@Autowired dùng để tự động tiêm (inject) dependency vào các component mà không cần khởi tạo thủ công.
    private final UserRepo userRepo;


    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServ(UserRepo userRepo,BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public String Register(AuthRegDTO req) {
        try{
            List<String> errors = new ArrayList<>();
            if (req.getUsername().length() < 6) errors.add("Username must be at least 6 characters.");
            if (req.getPassword().length() < 6) errors.add("Password must be at least 6 characters.");
            String passwordHash = passwordEncoder.encode(req.getPassword());
            User user = new User().builder().username(req.getUsername()).password(passwordHash).email(req.getEmail()).fullname(req.getFullName()).build();
            userRepo.save(user);
            return "Đăng ký thành công!!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
