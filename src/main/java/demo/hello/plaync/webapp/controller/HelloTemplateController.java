package demo.hello.plaync.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.hello.plaync.webapp.beans.SampleDomain;
import demo.hello.plaync.webapp.service.MssqlSampleService;

@Controller
public class HelloTemplateController {
	
	@Autowired
	private MssqlSampleService mssqlSampleService;

	@RequestMapping(value = "/hello")
	public void sayHello(ModelMap model) {
		model.addAttribute("blabla", "Hi! My name is...");
	}

	@RequestMapping(value="/bannedwordsxsss")
	public void bannedWordsXss(ModelMap model) {
	    model.addAttribute("bannedContent", "금칙어 테스트입니다. 유니코드, 한글. 필터링 되나요?");
	    model.addAttribute("xssContent", "XSS 테스트입니다. <script>alert('XSS');</script> <strong>HTML 태그</strong>가 되나요?");
	    model.addAttribute("bothContent", "금칙어 및 XSS 테스트입니다. 유니코드, 한글. 필터링 되나요? <script>alert('XSS');</script> <strong>HTML 태그</strong>가 되나요?");
	}
	
	@RequestMapping(value="/person")
	public String person(@RequestParam(required=false, value="idPerson") String idPerson, ModelMap model) {
		
		List<SampleDomain> map = mssqlSampleService.getPersonInfo(idPerson);
		
		model.addAttribute("list", map);
		
		return "person";
	}

}