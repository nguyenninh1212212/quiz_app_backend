package App.repository;

import App.model.entity.Exam;
import App.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExamRepo extends JpaRepository<Exam, UUID> {
    List<Exam> findAllByUser(Users user);
}
