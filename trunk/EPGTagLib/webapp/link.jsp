<%@page contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/epg-iptv.tld" prefix="epg"%>

<%
request.setAttribute("papers",new String[]{"解放日报","上海证券报","新民晚报",
"文汇报","东方早报","新闻晨报","参考消息","南方周末","人民日报","手机报"});
%>

<epg:page>
	<epg:body style="margin: 0; background-image: url('detail.jpg')">
	<epg:div id="pager" style="left:140px;top:144px;width:385px;height:88px" > 
		<epg:link href="333">web</epg:link>
	</epg:div>
	<%-- <epg:link href="333">2</epg:link>  --%>
	</epg:body>
</epg:page>