package demo.hello.plaync.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloTemplateController {

	@GetMapping(value = "/hello")
	public void sayHello(ModelMap model) {
		model.addAttribute("blabla", "Hi! My name is...");
	}

	@GetMapping(value="/bannedwordsxss")
	public void bannedWordsXss (ModelMap model) {
	    model.addAttribute("bannedContent", "금칙어 테스트입니다. 유니코드, 한글. 필터링 되나요?");
	    model.addAttribute("xssContent", "XSS 테스트입니다. <script>alert('XSS');</script> <strong>HTML 태그</strong>가 되나요?");
	    model.addAttribute("bothContent", "금칙어 및 XSS 테스트입니다. 유니코드, 한글. 필터링 되나요? <script>alert('XSS');</script> <strong>HTML 태그</strong>가 되나요?");
	}

}