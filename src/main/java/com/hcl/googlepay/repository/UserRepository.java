package com.hcl.googlepay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.googlepay.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
