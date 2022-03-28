package com.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.SITE_FEEDBACK;
import com.project.Repository.FeedbackRepository;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepository repo;
	public List<SITE_FEEDBACK> findByUserId(int UserID) {
		return repo.findByUserID(UserID);
	}
	public SITE_FEEDBACK addfeedback(SITE_FEEDBACK f) {
		return repo.save(f);
	}
	
}
