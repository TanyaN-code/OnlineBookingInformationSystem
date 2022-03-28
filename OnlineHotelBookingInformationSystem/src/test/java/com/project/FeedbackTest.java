package com.project;




import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

//import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.Model.SITE_FEEDBACK;
import com.project.Repository.FeedbackRepository;
import com.project.Service.FeedbackService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackTest {
	
	@MockBean
	private FeedbackRepository repo;
	
	@Autowired
	private FeedbackService service;
	

	@Test
	public void SaveFeedbackAddTest()
	{
		SITE_FEEDBACK obj=new SITE_FEEDBACK(101);
		when(repo.save(obj)).thenReturn(obj);
		assertEquals(obj,service.addfeedback(obj));
	}
	
	//fetchFeedbackByUserId
	@Test
	public void getFeedbackByUserID()
	{
	int userid =-702;
	when(repo.findByUserID(userid)).thenReturn(Stream.of(new SITE_FEEDBACK(702)).collect(Collectors.toList()));
	assertEquals(1,service.findByUserId(userid).size());
	}

}
