package App.model.entity;

import App.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    @Id
    @UuidGenerator
    private UUID id;
    @NotBlank(message = "Không được để trống")
    @Column(nullable = false, unique = true)
    private String username;
    @NotBlank(message = "Không được để trống")
    @Column(nullable = false)
    @NotBlank(message = "Không được để trống")
    private String password;
    @NotBlank(message = "Không được để trống")
    @Column(nullable = false)
    @NotBlank(message = "Không được để trống")
    private String fullname;
    @NotBlank(message = "Không được để trống")
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Role role;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime upadated;
}
