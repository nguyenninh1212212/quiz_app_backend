package App.repository;

import App.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Repository dùng giao tiếp với database
//JPA sẽ giúp làm việc với cơ sở dữ liệu (Database) mà không cần viết câu lệnh SQL trực tiếp.
//Sẽ có vài câu truy vấn mình cần tự viết và có nhiều câu truy vấn JPA đã viết cho rồi nên không cầ khai báo trong này
//UUID cần viết theo kiểu của ID đã khai báo Bên model.User
@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    //SELECT * FROM User WHERE fullname = ? ->có thể nhiều người cùng tên nên dùng list
    Optional<User> findByUsername(String username);
}
