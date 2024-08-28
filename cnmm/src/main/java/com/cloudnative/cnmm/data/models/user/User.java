package com.cloudnative.cnmm.data.models.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Map;

/**
 * @Author Nicholas Murray (einrucm)
 * The User data model for storing user information.
 */
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    public String id;

    public String firstName;

    public String lastName;

    public String companyName;

    public Map<String, Double> scores;

    public User(String firstName, String lastName, String companyName, Map<String, Double> scores) {
        setFirstName(firstName);
        setLastName(lastName);
        setCompanyName(companyName);
        setScores(scores);
    }
}
