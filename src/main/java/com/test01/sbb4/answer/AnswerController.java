package com.test01.sbb4.answer;

import com.test01.sbb4.question.Question;
import com.test01.sbb4.question.QuestionRepository;
import com.test01.sbb4.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    @PostMapping("/create/{id}")
    public String create(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult) {
        Question question = this.questionService.getQuestion(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.createAnswer(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
}
