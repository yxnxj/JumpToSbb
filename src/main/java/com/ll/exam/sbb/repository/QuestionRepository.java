package com.ll.exam.sbb.repository;

import com.ll.exam.sbb.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
