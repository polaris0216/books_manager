package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Logs;
import com.example.repository.LogsRepository;


@Service
public class LogsService {
	  private final LogsRepository logsRepository;

	    @Autowired
	    public LogsService(LogsRepository logsRepository) {
	        this.logsRepository = logsRepository;
	    }

	    public List<Logs> findAll() {
	        return this.logsRepository.findAll();
	    }

	    public Logs findById(Integer id) {
			Optional<Logs> optionalLogs = this.logsRepository.findById(id);
			Logs logs = optionalLogs.get();
			// TODO 自動生成されたメソッド・スタブ
			return logs;
		}

	    public Logs update(Integer id, String returnDueDate, LoginUser loginUser) {
	    	Logs logs = new Logs();
//
//	    	LocalDate now = LocalDate.now();
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	        String dateString = now.format(formatter);

	    	logs.setLibraryId(id);
	    	logs.setUserId(loginUser.getId());
	    	logs.setRentDate(LocalDateTime.now());
	    	logs.setReturnDueDate(LocalDateTime.parse(returnDueDate + "T00:00:00"));
	    	return this.logsRepository.save(logs);

}
