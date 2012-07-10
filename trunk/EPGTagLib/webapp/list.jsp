<%@page contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/epg-iptv.tld" prefix="epg"%>
<%@page import="chances.epg.taglib.bean.PageBean"%>
<%
request.setAttribute("papers",new String[]{"解放日报","上海证券报","新民晚报",
"文汇报","东方早报"});
%>

<epg:page>
	<epg:body style="margin: 0; background-image: url('detail.jpg')">
	
<%-- 	<epg:list horizontal="true" id="pager" style="left:10px;top:10px;width:385px;height:88px" 
	 items="${papers}" var="paper" indexVar="idx"  >
			<epg:cell style="width:98px;height:24px;" margin="left:15px">
				<epg:link href="web.jsp">
					${paper}
				</epg:link>
			</epg:cell>
	</epg:list>	
	 --%>	
	<epg:list id="pager" style="left:140px;top:144px;width:385px;height:88px" 
	 items="${papers}" var="paper" indexVar="idx"  >
			<epg:cell style="width:98px;height:24px;" margin="top:25px">
				<epg:link href="web.jsp">
					${paper}
				</epg:link>
			</epg:cell>
	</epg:list>
	

	</epg:body>
</epg:page>