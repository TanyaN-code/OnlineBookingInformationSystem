package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exception.OHISBusinessException;
import com.project.Model.SITE_FEEDBACK;
import com.project.Service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController 
{
	@Autowired
	FeedbackService service;
	

	@RequestMapping(value="/addFeedback",method =RequestMethod.POST )
	public ResponseEntity<SITE_FEEDBACK> addFeedback(@RequestBody SITE_FEEDBACK S){
		service.addfeedback(S);
		System.out.println(S);
		return new ResponseEntity<SITE_FEEDBACK>(S,HttpStatus.OK);
		
	} 
	
	@GetMapping("/fetchbyUserId/UserID")
	public ResponseEntity<List<SITE_FEEDBACK>> fetchByUserId(@RequestParam int UserID){
		String status=null;
		List<SITE_FEEDBACK> obj=service.findByUserId(UserID);
		if(obj.isEmpty()) {
			status="succesfully retrived";
			System.out.println(status);
		}
		else  {
			throw new OHISBusinessException("please enter valid id");
		}
		return new ResponseEntity<List<SITE_FEEDBACK>>(obj,HttpStatus.OK);
	
		}
	}
