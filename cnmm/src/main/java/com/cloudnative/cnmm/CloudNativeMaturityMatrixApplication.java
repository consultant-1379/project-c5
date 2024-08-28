package com.cloudnative.cnmm;

import com.cloudnative.cnmm.data.models.question.QuestionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class CloudNativeMaturityMatrixApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CloudNativeMaturityMatrixApplication.class, args);
        QuestionRepository repo = context.getBean(QuestionRepository.class);
        new InitialConfiguration(repo);
    }

}
