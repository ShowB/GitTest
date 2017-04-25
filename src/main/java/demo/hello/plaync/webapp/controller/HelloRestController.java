package demo.hello.plaync.webapp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.hello.plaync.webapp.beans.SampleDomain;
import demo.hello.plaync.webapp.service.MssqlSampleService;

@RestController
public class HelloRestController {

	@RequestMapping(value = "/rest/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayHello() {
		return "hello plaync";
	}

	@Autowired
	private MssqlSampleService mssqlSampleService;

	@RequestMapping(value = "/test/person", produces = MediaType.APPLICATION_JSON_VALUE)
	List<SampleDomain> getPersonInfoByParam(@RequestParam(required=false) String idPerson) {
		return mssqlSampleService.getPersonInfo(idPerson);
	}

	@RequestMapping(value = "/test/person/{idPerson}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<SampleDomain> getPersonInfoByPath(@PathVariable String idPerson) {
		return mssqlSampleService.getPersonInfo(idPerson);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/test/addPerson", produces = MediaType.APPLICATION_JSON_VALUE)
	public int insertPersonInfo(@RequestParam HashMap<String, Object> parameterMap) {
		int cnt = mssqlSampleService.insertPersonInfo(parameterMap);
		return cnt;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/test/deletePerson", produces = MediaType.APPLICATION_JSON_VALUE)
	public int deletePerson(@RequestParam(required=true) String idPerson) {
		return mssqlSampleService.deletePerson(idPerson);
	}

}