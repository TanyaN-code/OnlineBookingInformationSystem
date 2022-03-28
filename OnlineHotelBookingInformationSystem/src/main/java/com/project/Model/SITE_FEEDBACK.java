package com.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class SITE_FEEDBACK {
	@Id
	@Column(name="USERID")
	private int UserID;
	
	@Column(name="FEEDBACK_SCORE")
	private int feedbackScore;
	
	@Column(name="JUSTIFICATION")
    private String justification;

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		this.UserID = userID;
	}

	public int getFeedbackScore() {
		return feedbackScore;
	}

	public void setFeedbackScore(int feedbackScore) {
		this.feedbackScore = feedbackScore;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public SITE_FEEDBACK(int userID) {
		super();
		UserID = userID;
	}
	
	
	
	
}
