package com.example.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@GetMapping("/form")
	public String form(SurveyForm surveyForm, Model model) { 
		model.addAttribute("title", "Survey Form");
		return "survey/form";	
	}
	@PostMapping("/form")
	public String formGoBack(SurveyForm surveyForm, Model model) { 
		model.addAttribute("title", "Survey Form");
		return "survey/form";	
	}
	@PostMapping("/confirm")
	public String confirm(@Validated SurveyForm surveyForm, BindingResult result, Model model) {
		if(result.hasErrors()) {
			/* 當輸入有誤的話 */
			model.addAttribute("title", "Survey Form");
			return "survey/form";
		}
		model.addAttribute("title", "Confirm Page");
		return "survey/confirm";
	}
}
