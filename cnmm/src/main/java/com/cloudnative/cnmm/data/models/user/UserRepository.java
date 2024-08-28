package com.cloudnative.cnmm.data.models.user;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author Nicholas Murray (EINRUCM)
 * The Database repository for the User data model.
 */
public interface UserRepository extends MongoRepository<User, String> {
    public User findByCompanyName(String companyName);

    public User findByFirstNameAndLastName(String firstName, String lastName);

    public User findByFirstNameAndLastNameAndCompanyName(String firstName, String lastName, String companyName);

    public void deleteById(String id);
}
