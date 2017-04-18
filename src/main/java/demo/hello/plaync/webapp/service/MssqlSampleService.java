package demo.hello.plaync.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.hello.plaync.webapp.beans.SampleDomain;
import demo.hello.plaync.webapp.repository.mssqlsample.MssqlSampleMapper;

@Service
public class MssqlSampleService {
	
	@Autowired
	private MssqlSampleMapper mssqlSampleMapper;
	
	public SampleDomain getPersonInfo(String idPerson) {
		SampleDomain result = mssqlSampleMapper.getPersonInfo(idPerson);
		return result;
	}

}
