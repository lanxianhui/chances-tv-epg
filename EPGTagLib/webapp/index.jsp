<%@page contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/epg-iptv.tld" prefix="epg"%>
<%@page import="chances.epg.taglib.bean.PageBean"%>
<%
request.setAttribute("papers",new String[]{"grid","image","link","list","paging","text","参考消息","南方周末","人民日报"});

request.setAttribute("link",new String[]{"grid.jsp","image.jsp","link.jsp","list.jsp","paging.jsp","text.jsp","参考消息","南方周末","人民日报"});

request.setAttribute("blogs",new String[]{"上海热线","新浪","搜狐","腾迅","和迅","人民网","网易","21CN"});

request.setAttribute("broadcasts",new String[]{"徐静蕾","李晨鹏","潘石屹 ","牛刀","任自强","黄健翔","韩寒","易中天"});

request.setAttribute("pageBean",new PageBean(15,6,2));
%>

<epg:page>
	<epg:body style="margin: 0; background-image: url('detail.jpg')">
	<epg:grid id="pager" style="left:140px;top:144px;width:385px;height:88px" rows="3" cols="3"  items="${papers}" var="paper" indexVar="idx"  >
			<epg:cell style="width:98px;height:24px;" margin="top:25px;left:15px">
				<epg:link href="${link[idx]}">${paper}</epg:link>
			</epg:cell>
	</epg:grid>
	
	<epg:paging buttonStyle="width:82px;height:32px"  space="39" style="left:152px;top:458px" pageBean="${pageBean}"/>
	</epg:body>
</epg:page>