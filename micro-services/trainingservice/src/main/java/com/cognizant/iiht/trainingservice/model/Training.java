package com.cognizant.iiht.trainingservice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "training")
public class Training {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tr_id")
    private long id;
	
	@NotNull
	@Column(name="tr_status")
	private String status;
	
	@NotNull
	@Column(name="tr_progress")
	private int progress;
	
	@Column(name="tr_rating")
	private float rating;
	
	@NotNull
	@Column(name="tr_startdate")
	private Date startdate;
	
	@NotNull
	@Column(name="tr_enddate")
	private Date enddate;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="tr_us_id")
	private User user;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="tr_me_id")
	private Mentor mentor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="tr_sk_id")
	private Skill skill;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
}
