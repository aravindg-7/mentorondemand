package com.cognizant.iiht.searchservice.model;

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
@Table(name = "mentorskill")
public class MentorSkill {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ms_id")
	private long id;
	
	@NotNull
	@Column(name="ms_rating")
	private int rating;
	
	@NotNull
	@Column(name="ms_exp")
	private float experience;
	
	@ManyToOne
	@JoinColumn(name="ms_us_id")
	private Mentor mentorId;
	
	@ManyToOne
	@JoinColumn(name="ms_sk_id")
	private Skill skillId;
	
	
	
	public Mentor getMentorId() {
		return mentorId;
	}

	public Skill getSkillId() {
		return skillId;
	}

	public void setSkillId(Skill skillId) {
		this.skillId = skillId;
	}

	public void setMentorId(Mentor mentorId) {
		this.mentorId = mentorId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}
	
	

}
