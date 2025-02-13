package App.model;

import App.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

// Entity ánh xạ đến database
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @UuidGenerator
    private UUID id;

    @NotBlank(message = "Username không được để trống")
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Password không được để trống")
    private String password;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Full name không được để trống")
    @Column(nullable = false)
    private String fullname;

    @Enumerated(EnumType.STRING) // Sử dụng Enum thay vì String
    @Column(nullable = false)
    private Role role;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    // Khi tạo user, tự động set thời gian tạo và role mặc định
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (role == null) {
            role = Role.USER;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
