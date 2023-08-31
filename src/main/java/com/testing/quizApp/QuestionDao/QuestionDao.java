package com.testing.quizApp.QuestionDao;

import com.testing.quizApp.service.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao extends JpaRepository<Question,  Integer> {

    @Query(value = "SELECT * FROM question q where q.id=:id ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)

    List<Question> findRandomQuestionById(String id, int numQ);



}
