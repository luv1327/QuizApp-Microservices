package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    private QuizRepository quizRepository;
    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizList = quizRepository.findAll();
        return quizList.stream().peek(quiz -> quiz.setQuestions(questionClient.getQuestionByQuizId(quiz.getId()))).collect(Collectors.toList());
    }

    @Override
    public Quiz get(Long id) {
        Quiz foundQuiz = quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz Not Found"));
        foundQuiz.setQuestions(questionClient.getQuestionByQuizId(foundQuiz.getId()));
        return foundQuiz;
    }
}
