package com.student_sys.student_sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_sys.student_sys.model.Users;

public interface UserRepo extends JpaRepository<Users,Long>{

    boolean existsByUserName (String userName);
    
}
