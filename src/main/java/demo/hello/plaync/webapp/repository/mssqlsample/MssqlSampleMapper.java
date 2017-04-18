package demo.hello.plaync.webapp.repository.mssqlsample;

import org.apache.ibatis.annotations.Param;

import demo.hello.plaync.webapp.beans.SampleDomain;

public interface MssqlSampleMapper {

	SampleDomain getPersonInfo(@Param("idPerson") String idPerson);

}