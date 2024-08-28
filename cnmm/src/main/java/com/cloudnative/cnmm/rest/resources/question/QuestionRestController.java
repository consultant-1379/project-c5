package com.cloudnative.cnmm.rest.resources.question;

import com.cloudnative.cnmm.data.models.question.Question;
import com.cloudnative.cnmm.data.models.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionRestController {


    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping(value = "/{number}")
    public Question getQuestionByNumber(@PathVariable int number) {
        return questionRepository.findByNumber(number);
    }

    @GetMapping(value = "/category/{category}")
    public Question getQuestionByCategory(@PathVariable String category) {
        return questionRepository.findByCategory(category);
    }

    @PostMapping
    public ResponseEntity<Object> addQuestion(@RequestBody Question question) {
        if (questionRepository.findByCategory(question.getCategory()) == null || question.getId() != null) {
            Question savedQuestion = questionRepository.save(question);
            return ResponseEntity.status(201).body(savedQuestion);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable String id) {
        questionRepository.deleteById(id);
    }

}
