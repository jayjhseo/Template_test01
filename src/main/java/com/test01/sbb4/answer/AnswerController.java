package com.test01.sbb4.answer;

import com.test01.sbb4.question.Question;
import com.test01.sbb4.question.QuestionRepository;
import com.test01.sbb4.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    @PostMapping("/create/{id}")
    public String create(Model model, @PathVariable("id") Integer id, String content) {
        Question question = this.questionService.getQuestion(id);
        this.answerService.createAnswer(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
