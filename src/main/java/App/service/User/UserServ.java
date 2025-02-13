package App.service.User;

import App.model.User;
import App.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Xử lý nghiệp vụ, gọi repository để lấy dữ liệu
@Service
public class UserServ {
    //@Autowired dùng để tự động tiêm (inject) dependency vào các component mà không cần khởi tạo thủ công.
    private final UserRepo userRepo;

    @Autowired
    public UserServ(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
