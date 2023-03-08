package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "logs")
public class Logs {
	 @Id
	    @SequenceGenerator(name = "LOG_ID_GENERATOR", sequenceName = "LOG_ID_SEQ", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_ID_GENERATOR")
	    @Column(name = "ID")
	    private Integer id;

	 	@Column(name = "LIBRARY_ID")
	 	private Integer library_id;

	    @Column(name = "USER_ID")
	    private Integer user_id;

	    @Column(name = "RENT_DATE")
	    private LocalDateTime rent_date;

	    @Column(name = "RETURN_DATE")
	    private LocalDateTime return_date;

	    @Column(name = "RETURN_DUE_DATE")
	    private LocalDateTime return_due_date;

	    public Integer getId() {
	        return this.id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Integer getLibraryId() {
	        return this.library_id;
	    }

	    public void setLibraryId(Integer libnumber) {
	        this.library_id = libnumber;
	    }

	    public Integer getUserId() {
	        return this.user_id;
	    }

	    public void setUserId(Integer usernumber) {
	        this.user_id = usernumber;
	    }

	    public LocalDateTime getRentDate() {
	        return this.rent_date;
	    }

	    public void setRentDate(LocalDateTime rentdate) {
	    	this.rent_date = rentdate;
	    }

	    public LocalDateTime getReturnDate() {
	        return this.return_date;
	    }

	    public void setReturnDate(LocalDateTime returndate) {
	        this.return_date = returndate;
	    }

	    public LocalDateTime getReturnDueDate() {
	        return this.return_due_date;
	    }

	    public void setReturnDueDate(LocalDateTime returnduedate) {
	        this.return_due_date = returnduedate;
	    }

}
