package com.cloudnative.cnmm.data.models.question;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Answer {

    public String answer;
    public int value;

    public Answer(String answerDetails, int value) {
        this.answer = answerDetails;
        this.value = value;
    }
}
