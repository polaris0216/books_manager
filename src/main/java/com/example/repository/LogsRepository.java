package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Logs;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Integer> {
    // emailと一致するユーザを取得する
    //public Logs findByEmail(String email);
}