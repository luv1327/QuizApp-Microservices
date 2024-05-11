package com.quiz.services;

import com.quiz.dtos.QuestionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {
    @GetMapping("/question/quiz/{id}")
    List<QuestionDto> getQuestionByQuizId(@PathVariable Long id);
}
