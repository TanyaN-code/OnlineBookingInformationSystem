package com.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Model.SITE_FEEDBACK;

@Repository
public interface FeedbackRepository extends JpaRepository<SITE_FEEDBACK, Integer> 
{
	@Query("select e from SITE_FEEDBACK e where e.UserID=:UserID")
	List<SITE_FEEDBACK> findByUserID(@Param("UserID") int UserID);
}
