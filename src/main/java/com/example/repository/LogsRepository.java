package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Logs;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Integer> {

//	public Optional<Logs> findFirstByLibraryIdOrderByRentDateDesc(Integer id);

	public Optional<Logs> findFirstByLibraryIdAndUserIdOrderByRentDateDesc(Integer id, Integer userId);
	public List<Logs> findByUserId(Integer userId);

	//public Logs findByEmail(String email);
	// emailと一致するユーザを取得する
    //public Logs findByEmail(String email);
}