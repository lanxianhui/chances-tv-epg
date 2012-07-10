package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;

import chances.epg.taglib.utils.HtmlUtils;
import chances.epg.taglib.utils.TagUtils;




public class BodyTag extends  AbstractBoxTag {

	public  static String ELEMENT_NAME = "body";
	private String onLoad;
	private String onUnload;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String getElementName() {
		return "body";
	}
	
	

	public String getOnLoad() {
		return onLoad;
	}

	public void setOnLoad(String onLoad) {
		this.onLoad = onLoad;
	}

	public String getOnUnload() {
		return onUnload;
	}

	public void setOnUnload(String onUnload) {
		this.onUnload = onUnload;
	}



	@Override
	public int doStartTag() throws JspException {
		int result =  super.doStartTag();
		String content = HtmlUtils.createElementBegin(pageContext, this, ELEMENT_NAME);
		TagUtils.write(pageContext, content);
		return result;
	}



	@Override
	public int doEndTag() throws JspException {
		String content = HtmlUtils.createElementEnd(pageContext, ELEMENT_NAME);
		TagUtils.write(pageContext, content);
		return super.doEndTag();
	}
}
