package com.cloudnative.cnmm.data.models.question;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {

    public Question findByNumber(int value);
    public Question findByCategory(String category);
    public void deleteById(String id);
}