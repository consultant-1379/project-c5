package com.cloudnative.cnmm.data.models.question;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Question {

    @Id
    public String id;

    public String primary;

    public String secondary;

    public int number;

    public String category;

    public List<Answer> answers;

    public Question(String id, int n, String category, List<Answer> answers) {
        this.id = id;
        this.number = n;
        this.category = category;
        this.answers = answers;
    }
}
