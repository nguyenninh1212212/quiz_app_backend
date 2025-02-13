package App.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


//Entity để ánh xạ đến database tạo bảng mà không cần vào thao tác với mysql
//@Getter @Setter @NoArgsConstructor @AllArgsConstructor tự tạo getter, setter,constructor có tham số và không có tham số không cần phải viết thủ công
//@UuidGenerator sẽ tự động tạo id ngẫu nhiên không trùng lặp,đây là kiểu dữ liệu bit16 giúp tối ưu hóa truy vấn query

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @UuidGenerator
    private UUID id;

    @NotBlank(message = "Username không được để trống")
    @Column(unique = true, nullable = false)
    private String username;

    @Column( nullable = false)
    @NotBlank(message = "Password không được để trống")
    private String password;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Full name không được để trống")
    @Column( nullable = false)
    private String fullname;
}
