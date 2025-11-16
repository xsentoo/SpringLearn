package com.Ecommerce.LearnEcommerce.repository;

import com.Ecommerce.LearnEcommerce.entity.UserEntity;
import com.Ecommerce.LearnEcommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
