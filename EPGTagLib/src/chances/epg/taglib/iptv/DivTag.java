package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;

import chances.epg.taglib.utils.HtmlUtils;
import chances.epg.taglib.utils.TagUtils;


public class DivTag extends  AbstractBoxTag {

	private static final long serialVersionUID = 1L;
	protected LinkTag linkTag;
	
	public String getElementName(){
		return "div";
	}
	protected void writeBegin() throws JspException {
		
		String content = HtmlUtils.createElementBegin(pageContext, this, this.getElementName());
		TagUtils.write(this.pageContext, content);

	}
	
	protected void writeEnd() throws JspException {
		String content = HtmlUtils.createElementEnd(pageContext,  this.getElementName());
		TagUtils.write(this.pageContext, content);
	}
	@Override
	public int doStartTag() throws JspException {
		
	 int result = super.doStartTag();
	 writeBegin();
	 return result;
	}
	@Override
	public int doEndTag() throws JspException {
		 int result =  super.doEndTag();
		 writeEnd();
		 if(this.linkTag!=null){
			 TagUtils.write(pageContext, linkTag.getHtml(this.box));
		 }
		 return result;
	}
	public LinkTag getLinkTag() {
		return linkTag;
	}

	public void setLinkTag(LinkTag linkTag) {
		this.linkTag = linkTag;
	}
}
