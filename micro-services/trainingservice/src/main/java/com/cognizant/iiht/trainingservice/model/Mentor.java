package com.cognizant.iiht.trainingservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "mentor")
public class Mentor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "me_id")
    private long id;
	
	@NotNull
	@Column(name="me_url")
	private String url;
	
	@NotNull
	@Column(name="me_experience")
	private float experience;
	
	@NotNull
	@Column(name="me_slot")
	private String slot;
	
	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	@OneToMany(mappedBy = "mentorId",cascade=CascadeType.ALL)
    private List<MentorSkill> mskill;
	
	@OneToOne
	@JoinColumn(name="me_us_id")
	private User user;
	
	
//	public User getUser() {
//		return user;
//	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public List<MentorSkill> getMskill() {
		return mskill;
	}

	public void setMskill(List<MentorSkill> mskill) {
		this.mskill = mskill;
	}


	
	
}
