package demo.hello.plaync.webapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import demo.hello.plaync.webapp.beans.SampleDomain;
import demo.hello.plaync.webapp.repository.mssqlsample.MssqlSampleMapper;

@Service
@Transactional(readOnly=true)
public class MssqlSampleService {
	
	@Autowired
	private MssqlSampleMapper mssqlSampleMapper;
	
	public List<SampleDomain> getPersonInfo(String idPerson) {
		return mssqlSampleMapper.getPersonInfo(idPerson);
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public int insertPersonInfo(HashMap<String, Object> person) {
        int cnt = 0;
        	
        cnt = mssqlSampleMapper.insertPersonInfo(person);
        
        // 익셉션 발생시키기 위한 에러코드
        String.valueOf(null);
		
		return cnt;
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public int deletePerson(String idPerson) {
		return mssqlSampleMapper.deletePerson(idPerson);
	}

}
