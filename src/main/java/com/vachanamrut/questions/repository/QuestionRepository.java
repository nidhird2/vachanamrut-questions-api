package com.vachanamrut.questions.repository;

import com.vachanamrut.questions.model.Question;
import com.vachanamrut.questions.model.QuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, QuestionId> {
}
