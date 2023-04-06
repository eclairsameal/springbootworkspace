package com.example.demo.app;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SurveyForm {
    @Min(0)
    @Max(150)
    private int age;
    
	@Min(1)
    @Max(5)
    private int satisfaction;

	@NotNull
	@Size(min = 1, max = 200, message="Please input 200 characters or less")
    private String comment;
	
	public SurveyForm() {

	}
	
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
