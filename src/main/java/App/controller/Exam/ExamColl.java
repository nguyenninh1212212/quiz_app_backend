package App.controller.Exam;

import App.dto.Exam.ExamDTO;
import App.dto.PageReponse;
import App.service.ExamServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exams")
public class ExamColl {
    @Autowired
    private ExamServ examServ;

    @GetMapping("")
    public ResponseEntity<?> getExams(@RequestParam(required = true) String username ,@RequestParam(required = true) int page,@RequestParam(required = true) int limit) {
            try {
                PageReponse<ExamDTO> result = examServ.getExams(username,page,limit);
                return  ResponseEntity.ok(Map.of("message","sucessfully","data",result));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
}
