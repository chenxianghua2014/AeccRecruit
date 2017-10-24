/**   
* @Title LoginBlankList.java 
* @Package com.ttgis.recruit.interceptors 
* @Description TODO 
* @author hua
* @date 2016年9月2日 下午1:54:45 
* @version V1.0   
*/
package com.ttgis.recruit.interceptors;

/** 
* @ClassName LoginBlankList 
* @Description TODO 
* @author cxh 
* @date 2016年9月2日 下午1:54:45 
*  
*/
public class LoginBlankList {
    public static final String NO_INTERCEPTOR_PATH = "/((Main)|(LoginFrmFirst)|(LinkListJson)|(GroupIntroduction)|(TalentStrategy)"
    	+ "|(InformationCenter)|(SearchEnterprise)|(SearchPosition)|(LoginFrm)|(UserLogin)"
	   /*后台用户*/
	+ "|(htRecruit)|(zzjgLogin)"
    	+ "|(UserLogout)|(logout)|(zzjgLogout)|(zhmm)|(checkUserIsCZ)|(successCzUserUpdPD)"
    	+ "|(images)|(image)|(shangchuan)|(css)|(js)"
    	+ "|(DLcpgl)|(CpglLogin)"
    	+ "|(register)|(checkUserIdcard)|(checkUserName)|(checkUserTelephone)|(checkUserSfzh)|(registerUser)"
    	+ "|(expjl)"
    	//测评页面
    	+ "|(DLcpgl)|(cpglKszl)|(cpglKssm)|(cpglKssm1)|(cpglKssm2)|(cpglGxsm)|(successSubmit)|(successSubmit1)"
    	+ "|(successSubmit2)|(cpglCpsj)|(CpglLogin)|(CpglLogout)|(querySj)|(TestSubmit)"
    	+ "|(glgTszgSubmit)|(queryJsgSj)|(JsgSjSubmit)|(queryGlgEng)|(GlgEngSubmit)|(querySjgx)|(TestSubmitgx)"
    	+ "|(ShowCharts)|(checkKscj)|(queryByGxcsId)|(JsgEngSubmit)|(checkGxcs)|(queryJsgEng)|(Gxcs)|(cpgljsgGxsm)"
    	+ ")/*.*"; // 不对匹配该值的访问路径拦截（正则）
    
    //无需xss过滤的列表
    //程序中富文本编辑器百度editor，过滤时会出现格式错误，将这些字段列表加入了下列白名单
    public static final String NO_FILTER_PATH = "((bbsNr)|(bbsReviewNr)|(reviewReplyNr)|(reviewNr)|(reviewNr)|(bbsNr)"
    	+ "|(mbglContent)|(mbglContent)|(articleContent)|(articleReviewNr)|(bbsNrueditor)|(articleContent)|(xqqzNr)|(xqqzReviewNr)"
    	+ "|(tkglSttg)|(tkglStxxA)|(tkglStxxB)|(tkglStxxC)|(tkglStxxD)|(sttg)|(stxxa)|(stxxb)"
    	+ "|(SendMessage)"
    	+ "|(stxxc)|(stxxd)|(xcxxContent)|(xcxxContent)|(xqqzReviewNr)|(xqqzNr)|(zjgzGznr)|(Content)|(zpxwContent)|(articleReviewNr))";
}
