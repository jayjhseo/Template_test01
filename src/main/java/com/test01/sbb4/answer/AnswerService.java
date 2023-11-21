package com.test01.sbb4.answer;

import com.test01.sbb4.question.Question;
import com.test01.sbb4.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    public void createAnswer(Question question, String content) {
        Answer a = new Answer();
        a.setContent(content);
        a.setQuestion(question);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }
}
