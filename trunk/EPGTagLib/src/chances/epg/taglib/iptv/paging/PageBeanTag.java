package chances.epg.taglib.iptv.paging;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import chances.epg.taglib.bean.PageBean;
import chances.epg.taglib.utils.TagUtils;

public class PageBeanTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private int total;
	private int pageNo;
	private int pageSize=1;
	private String var;
	private String scope;
	
	@Override
	public int doStartTag() throws JspException {
		PageBean pageBean = new PageBean(total,pageSize,pageNo);
		TagUtils.setVar(pageContext,var,scope,pageBean);
		release();
		return SKIP_BODY;
	}
	
	@Override
	public void release(){
		this.total =0;
		this.pageNo =1;
		this.pageSize=0;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}


}
