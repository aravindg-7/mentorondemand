package com.cognizant.iiht.searchservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="skill")
public class Skill {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
	private long id;
	
	@NotNull
	@Column(name="sk_name")
	private String name;
	
	@OneToMany(mappedBy = "skillId",cascade=CascadeType.ALL)
    private List<MentorSkill> mskill;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<MentorSkill> getMskill() {
//		return mskill;
//	}

	public void setMskill(List<MentorSkill> mskill) {
		this.mskill = mskill;
	}
	
	
}
