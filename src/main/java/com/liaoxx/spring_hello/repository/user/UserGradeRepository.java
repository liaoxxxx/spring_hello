package com.liaoxx.spring_hello.repository.user;

import com.liaoxx.spring_hello.entity.user.UserGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserGradeRepository extends JpaRepository<UserGrade, Integer>, JpaSpecificationExecutor<UserGrade> {
}