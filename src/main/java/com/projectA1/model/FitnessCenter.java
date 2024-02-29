// FitnessCenter.java
package com.projectA1.model;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

//FitnessCenter.java
@Entity(name = "f_center")
@Getter
@Setter
public class FitnessCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String address;
	private String phoneNumber;
	private Long dailyPassPrice;


	private LocalTime openTime;


	private LocalTime closingTime;

	// 수정된 부분: Owner와의 관계 설정
	@OneToMany(mappedBy = "fitnessCenter", cascade = CascadeType.ALL)
	private List<Owner> owners; // 이 FitnessCenter를 소유한 Owner 목록
}
