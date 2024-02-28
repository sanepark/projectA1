package com.projectA1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectA1.model.FitnessCenter;
import com.projectA1.repository.FitnessCenterRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FitnessCenterService {

	private final FitnessCenterRepository fitnesscenterrepository;
	
	// 추가
	public void join(FitnessCenter fitnesscenter) {
		fitnesscenterrepository.save(fitnesscenter);
	}
	
	//  상세보기
	public Optional<FitnessCenter> view(Long id) {
        return fitnesscenterrepository.findById(id);
    }
	
	//  전체보기
	 public List<FitnessCenter> viewAll() {
	        return fitnesscenterrepository.findAll();
	    }
	
	
	//  수정 => 주소, 전화번호, 일일권 수정가능
	@Transactional
	public void update(FitnessCenter fitnesscenter) {
		FitnessCenter f = fitnesscenterrepository.findById(fitnesscenter.getId()).get();
		f.setAddress(fitnesscenter.getAddress());
		f.setPhoneNumber(fitnesscenter.getPhoneNumber());
		f.setOpenTime(fitnesscenter.getOpenTime());
		f.setClosingTime(fitnesscenter.getClosingTime());
	}
	
	
	// 삭제
	@Transactional
	 public void deleteFitnessCenter(Long id) {
	        fitnesscenterrepository.deleteById(id);
	    }


}
