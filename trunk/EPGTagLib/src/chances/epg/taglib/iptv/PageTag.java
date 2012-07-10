package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import chances.epg.taglib.bean.EPGPageContext;
import chances.epg.taglib.utils.TagUtils;

public class PageTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		try {
		  EPGPageContext.createEPGPageContext(pageContext);
		} catch (JspException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int doEndTag() throws JspException {
		TagUtils.write(pageContext, "</html>");
		EPGPageContext.removeEPGPageContext(pageContext);
		return SKIP_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		TagUtils.write(pageContext, "<html>");
		return EVAL_BODY_INCLUDE;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
