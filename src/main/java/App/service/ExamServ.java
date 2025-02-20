package App.service;

import App.dto.Exam.ExamDTO;
import App.dto.User.UserDTO;
import App.model.entity.Exam;
import App.model.entity.Users;
import App.repository.ExamRepo;
import App.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ExamDTO> getExams(String username) {
        try{
            Users user=userRepo.findByUsername(username).orElseThrow(()->new RuntimeException("User not found"));
            List<ExamDTO> result=examRepo.findAllByUser(user).stream().map(exam ->ExamDTO.builder().owner(new UserDTO(exam.getUser())).created(exam.getCreated()).docs(exam.getDocs()).comments(exam.getComments()).created(exam.getCreated()).build()).collect(Collectors.toList());
            return result;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
