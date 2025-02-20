package App.service;

import App.dto.Exam.ExamDTO;
import App.dto.PageReponse;
import App.dto.User.UserDTO;
import App.model.entity.Exam;
import App.model.entity.Users;
import App.repository.ExamRepo;
import App.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamServ {
    @Autowired
    private ExamRepo examRepo;
    @Autowired
    private UserRepo userRepo;

    public PageReponse<ExamDTO> getExams(String username, int page, int limit) {
        try {
            Users user = userRepo.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            Pageable pageable = PageRequest.of(page, limit);
            Page<Exam> exams = examRepo.findAllByUser(user, pageable);

            List<ExamDTO> examList = exams.getContent().stream()
                    .map(exam -> ExamDTO.builder()
                            .owner(new UserDTO(exam.getUser()))
                            .created(exam.getCreated())
                            .docs(exam.getDocs())
                            .comments(exam.getComments())
                            .build())
                    .collect(Collectors.toList());

            return PageReponse.<ExamDTO>builder()
                    .page(exams.getNumber())
                    .limit(exams.getSize())
                    .total(exams.getTotalPages())
                    .data(examList)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
