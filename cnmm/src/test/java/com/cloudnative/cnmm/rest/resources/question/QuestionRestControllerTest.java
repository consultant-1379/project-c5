package com.cloudnative.cnmm.rest.resources.question;

import com.cloudnative.cnmm.data.models.question.Answer;
import com.cloudnative.cnmm.data.models.question.Question;
import com.cloudnative.cnmm.data.models.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequestMapping(path = "/question")
class QuestionRestControllerTest {

    Answer answer1 = new Answer("Answer 1", 2);
    Answer answer2 = new Answer("Answer 2", 3);
    List<Answer> answerList = Arrays.asList(answer1, answer2);

    Question question = new Question("1", 1, "Category 1", answerList);

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionRestController questionRestController;

    @Test
    public void addQuestionTest() {
        when(questionRepository.save(question)).thenReturn(question);
        assertEquals(questionRestController.addQuestion(question).getBody(), question);
    }

    @Test
    public void getQuestionByNumberTest() {
        question.setNumber(1);
        when(questionRepository.findByNumber(1)).thenReturn(question);
        assertEquals(questionRestController.getQuestionByNumber(1), question);
        assertNull(questionRestController.getQuestionByNumber(3));
    }

    @Test
    public void getQuestionByCategoryTest() {
        question.setCategory("Category 1");
        when(questionRepository.findByCategory("Category 1")).thenReturn(question);
        assertEquals(questionRestController.getQuestionByCategory("Category 1"), question);
        assertNull(questionRestController.getQuestionByCategory("Category 2"));
    }

    @Test
    public void deleteQuestionTest() {
        Question testQuestion = new Question("2", 2, "Category Test", answerList);
        questionRepository.insert(testQuestion);
        questionRestController.deleteQuestion(testQuestion.getId());
        assertNull(questionRestController.getQuestionByNumber(2));
    }

    @Test
    public void getAllQuestionsTest() {
        List<Question> questionList = new ArrayList<>();
        questionList.add(question);
        when(questionRepository.findAll()).thenReturn(questionList);
        questionRepository.insert(question);
        assertEquals(questionRestController.getAllQuestions().get(0), question);
    }


}
