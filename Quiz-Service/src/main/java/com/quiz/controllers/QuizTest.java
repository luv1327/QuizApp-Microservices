package com.quiz.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz-test")
public class QuizTest {
    @GetMapping("")
    public String quizTest(){
        return "This is a quiz test";
    }
}
