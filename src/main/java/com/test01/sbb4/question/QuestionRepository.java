package com.test01.sbb4.question;

import com.test01.sbb4.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
