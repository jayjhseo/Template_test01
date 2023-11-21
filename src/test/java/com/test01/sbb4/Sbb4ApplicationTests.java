package com.test01.sbb4;

import com.test01.sbb4.answer.Answer;
import com.test01.sbb4.answer.AnswerRepository;
import com.test01.sbb4.question.Question;
import com.test01.sbb4.question.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Sbb4ApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Test
	@DisplayName("질문 생성")
	void test01() {
		Question q1 = new Question();
		q1.setSubject("1번 질문");
		q1.setContent("1번 질문 내용");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("2번 질문");
		q2.setContent("2번 질문 내용");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
	@Test
	@DisplayName("질문에 대한 대답 생성")
	void test02() {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question question = oq.get();

		Answer a = new Answer();
		a.setContent("1번 질문의 Answer");
		a.setQuestion(question);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);

	}
}
