package com.ttgis.recruit.domain;

import java.io.Serializable;
import java.util.Date;

public class Resume implements Serializable
{
	private static final long serialVersionUID = 3089891437062436437L;
	private String resumeId;
	private Date resumeAddtime;
	private long resumeDelflag;

	private String resumeName;
	private String resumeSex;
	private String resumeSfzh;
	private String resumeBirthday;
	private String resumeRxqhkszcsProvince;
	private String resumeRxqhkszcsCity;
	private String resumeMqszcsProvince;
	private String resumeMqszcsCity;
	private String resumePhotos;
	//自制简历
    private String resumeZzjl;
    
	private String resumeTelphone;
	private String resumeEmail;
	private String resumeFj;
	private String resumeFjid;
	
	public String getResumeZzjl() {
		return resumeZzjl;
	}

	public void setResumeZzjl(String resumeZzjl) {
		this.resumeZzjl = resumeZzjl;
	}



	public String getResumeFj()
	{
		return resumeFj;
	}

	public void setResumeFj(String resumeFj)
	{
		this.resumeFj = resumeFj;
	}


	public String getResumeFjid()
	{
		return resumeFjid;
	}

	public String ResumeFjid()
	{
		return resumeFjid;
	}

	public void setResumeFjid(String resumeFjid)
	{
		this.resumeFjid = resumeFjid;
	}

	public String ResumePhotos()
	{
		return resumePhotos;
	}

	public String getResumePhotos()
	{
		return resumePhotos;
	}

	public void setResumePhotos(String resumePhotos)
	{
		this.resumePhotos = resumePhotos;
	}

	public String ResumeSfzh()
	{
		return resumeSfzh;
	}

	public String getResumeSfzh()
	{
		return resumeSfzh;
	}

	public void setResumeSfzh(String resumeSfzh)
	{
		this.resumeSfzh = resumeSfzh;
	}

	public String getResumeId()
	{
		return resumeId;
	}

	public void setResumeId(String resumeId)
	{
		this.resumeId = resumeId;
	}

	public Date getResumeAddtime()
	{
		return resumeAddtime;
	}

	public void setResumeAddtime(Date resumeAddtime)
	{
		this.resumeAddtime = resumeAddtime;
	}

	public long getResumeDelflag()
	{
		return resumeDelflag;
	}

	public void setResumeDelflag(long resumeDelflag)
	{
		this.resumeDelflag = resumeDelflag;
	}

	public String getResumeName()
	{
		return resumeName;
	}

	public void setResumeName(String resumeName)
	{
		this.resumeName = resumeName;
	}

	public String getResumeSex()
	{
		return resumeSex;
	}

	public void setResumeSex(String resumeSex)
	{
		this.resumeSex = resumeSex;
	}

	public String getResumeBirthday()
	{
		return resumeBirthday;
	}

	public void setResumeBirthday(String resumeBirthday)
	{
		this.resumeBirthday = resumeBirthday;
	}

	public String getResumeRxqhkszcsProvince()
	{
		return resumeRxqhkszcsProvince;
	}

	public void setResumeRxqhkszcsProvince(String resumeRxqhkszcsProvince)
	{
		this.resumeRxqhkszcsProvince = resumeRxqhkszcsProvince;
	}

	public String getResumeRxqhkszcsCity()
	{
		return resumeRxqhkszcsCity;
	}

	public void setResumeRxqhkszcsCity(String resumeRxqhkszcsCity)
	{
		this.resumeRxqhkszcsCity = resumeRxqhkszcsCity;
	}

	public String getResumeMqszcsProvince()
	{
		return resumeMqszcsProvince;
	}

	public void setResumeMqszcsProvince(String resumeMqszcsProvince)
	{
		this.resumeMqszcsProvince = resumeMqszcsProvince;
	}

	public String getResumeMqszcsCity()
	{
		return resumeMqszcsCity;
	}

	public void setResumeMqszcsCity(String resumeMqszcsCity)
	{
		this.resumeMqszcsCity = resumeMqszcsCity;
	}

	public String getResumeTelphone()
	{
		return resumeTelphone;
	}

	public void setResumeTelphone(String resumeTelphone)
	{
		this.resumeTelphone = resumeTelphone;
	}

	public String getResumeEmail()
	{
		return resumeEmail;
	}

	public void setResumeEmail(String resumeEmail)
	{
		this.resumeEmail = resumeEmail;
	}

}