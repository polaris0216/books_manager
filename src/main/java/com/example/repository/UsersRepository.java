package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	 // 以降の設問で必要に応じて機能を実装すること
}
