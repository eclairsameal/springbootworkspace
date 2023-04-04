package com.example.demo.app.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	
	@GetMapping("/form")
	public String form(InquiryForm inquiryForm, Model model,
			@ModelAttribute("complete") String complete) { /*"complete"剛剛addFlashAttribute設定的關鍵識別字*/
		model.addAttribute("title", "Inquiry Form");
		return "inquiry/form";	
	}
	
	@PostMapping("/form")
	public String formGoBack(InquiryForm inquiryForm, Model model) {
		model.addAttribute("title", "Inquiry Form");
		return "inquiry/form";	
	}/*GoBack 是用Post方法, 所以要多新增一個Post的function*/
	
	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm, BindingResult result, Model model) {
		if(result.hasErrors()) {
			/* 當輸入有誤的話 */
			model.addAttribute("title", "Inquiry Form");
			return "inquiry/form";
		}
		model.addAttribute("title", "Confirm Page");
		return "inquiry/confirm";
	}
	@PostMapping("/complete")
	public String complete(@Validated InquiryForm inquiryForm, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("title", "Inquiry Form");
			return "inquiry/form";
		}
		redirectAttributes.addFlashAttribute("complete", "Registered!");/*關鍵識別字, 想顯示的字*/
		return "redirect:/inquiry/form";
	}/**/

}
