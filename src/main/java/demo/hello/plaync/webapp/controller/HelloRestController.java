package demo.hello.plaync.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.hello.plaync.webapp.beans.SampleDomain;
import demo.hello.plaync.webapp.service.MssqlSampleService;

@RestController
public class HelloRestController {

	@GetMapping(value = "/rest/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayHello() {
		return "hello plaync";
	}
	
	@Autowired
	private MssqlSampleService mssqlSampleService;
	
	@GetMapping(value="/rest/test", produces=MediaType.APPLICATION_JSON_VALUE)
	public SampleDomain getPersonInfoByParam(@RequestParam(value="idPerson") String idPerson) {
		SampleDomain result = mssqlSampleService.getPersonInfo(idPerson);
	
		return result;
	}
	
	@GetMapping(value="/rest/test/{idPerson}", produces=MediaType.APPLICATION_JSON_VALUE)
	public SampleDomain getPersonInfoByPath(@PathVariable String idPerson) {
		SampleDomain result = mssqlSampleService.getPersonInfo(idPerson);
		
		return result;
	}

}