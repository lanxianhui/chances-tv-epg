<%@page contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/epg-iptv.tld" prefix="epg"%>
<%@page import="chances.epg.taglib.bean.PageBean"%>
<%request.setAttribute("pageBean",new PageBean(15,6,3));%>

<epg:pageBean var="pageBean" pageNo="3" pageSize="6" total="15"  />
<epg:page>

<epg:body>
	
	<epg:paging id="my_id" showInfo="true" pageBean="${pageBean}" style="top:50px;left:20"
	vertical="false" space="10" buttonStyle="width:80px;height:20px"/>
	
	
	<epg:paging id="my_id" showPrior="true" showFirst="true" showLast="true" showNext="true" pageBean="${pageBean}" style="top:100px;left:20"
	vertical="true" space="10" buttonStyle="width:80px;height:20px"/>
 
	
	
	<epg:paging id="mg_id" pageBean="${pageBean}" 
		space="12" vertical="true"
		style="top:400px;left:20" buttonStyle="width:80px;height:20px">
	
		<epg:prior src="src2.jpg" grayedSrc="graysrc2.jpg"/>
		<epg:next src="src3.jpg" grayedSrc="graysrc3.jpg"/>
	
	</epg:paging>
</epg:body>
</epg:page>