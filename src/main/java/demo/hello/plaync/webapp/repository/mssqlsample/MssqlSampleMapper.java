package demo.hello.plaync.webapp.repository.mssqlsample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import demo.hello.plaync.webapp.beans.SampleDomain;

public interface MssqlSampleMapper {

	// 회원정보 조회
	List<SampleDomain> getPersonInfo(@Param("idPerson") String idPerson);

	// 회원정보 등록
	int insertPersonInfo(@Param("person") Map<String, Object> person);

	// 회원정보 삭제
	int deletePerson(@Param("idPerson") String idPerson);
}