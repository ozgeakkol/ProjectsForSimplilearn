package com.example.sportyShoes.repository;

import com.example.sportyShoes.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

    // JPQL (Java Persistence Query language )
    @Query("select l from Login l where l.emailId = :emailId and l.password = :password and l.typeOfUser=:typeOfUser")
    public Login signIn(@Param("emailId") String emailId,
                        @Param("password") String password,
                        @Param("typeOfUser") String typeOfUser);

    // Native Query
    @Query(value="select * from login l where l.emailId = :emailId and l.password = :password and l.typeOfUser=:typeOfUser",nativeQuery = true)
    public Login signInWithNative(@Param("emailId") String emailId,
                                  @Param("password") String password,
                                  @Param("typeOfUser") String typeOfUser);
}