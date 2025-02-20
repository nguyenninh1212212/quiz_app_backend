package App.repository;

import App.model.entity.Exam;
import App.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExamRepo extends JpaRepository<Exam, UUID> {
    Page<Exam> findAllByUser(User user, Pageable pageable);
}
