package com.vachanamrut.questions.controller;

import com.vachanamrut.questions.exception.ResourceNotFoundException;
import com.vachanamrut.questions.model.Question;
import com.vachanamrut.questions.model.QuestionId;
import com.vachanamrut.questions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("questions")
    public List<Question> getAllQuestion(){
        return this.questionRepository.findAll();
    }

    @GetMapping("questions/{location}/{section}/{question_number}")
    public ResponseEntity<Question> getQuestionById(@PathVariable(value = "location") String location,
                                                    @PathVariable(value = "section") int section,
                                                    @PathVariable(value = "question_number") int no) throws ResourceNotFoundException {
        QuestionId questionId = new QuestionId(location, section, no);
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("question not found."));
        return ResponseEntity.ok().body(question);
    }

    @PostMapping("/questions")
    public Question createQuestion(@RequestBody Question question){
        return this.questionRepository.save(question);
    }

    @DeleteMapping("questions/{location}/{section}/{question_number}")
    public Map<String,Boolean> deleteQuestionById(@PathVariable(value = "location") String location,
                                                  @PathVariable(value = "section") int section,
                                                  @PathVariable(value = "question_number") int no) throws ResourceNotFoundException {
        QuestionId questionId = new QuestionId(location, section, no);
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("question not found."));

        this.questionRepository.delete(question);
        Map<String,Boolean> returnBody = new HashMap<>();
        returnBody.put("deleted", true);

        return returnBody;
    }

}
