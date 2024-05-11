package com.question.services;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {
    Question add(Question question);
    List<Question> get();
    Question get(Long id);
    List<Question> getByQuizId(Long id);
}
