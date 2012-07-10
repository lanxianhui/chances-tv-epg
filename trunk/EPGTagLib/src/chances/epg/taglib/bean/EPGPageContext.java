package chances.epg.taglib.bean;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class EPGPageContext implements java.io.Serializable {
	/**
	 * 
	 */
	
	public static String EPG_PAGE_CONTEXT_NAME ="EPGPageContext";
	
	private static final long serialVersionUID = 1L;
	private List<Link> links;

	private Box body;
	
	public EPGPageContext() throws JspException{
		body = new Box();
	}

	
	public void addLink(Link link){
		this.links.add(link);
	}
	
	public Box getBody() {
		return body;
	}


	public void setBody(Box body) {
		this.body = body;
	}
	
	
	public static EPGPageContext getEPGPageContext(PageContext pageContext){
		return (EPGPageContext) pageContext.getAttribute(EPG_PAGE_CONTEXT_NAME);
	}

	public static EPGPageContext createEPGPageContext(PageContext pageContext) throws JspException{
		EPGPageContext result = new EPGPageContext();
		pageContext.setAttribute(EPG_PAGE_CONTEXT_NAME, result);
		return result;
	}
	
	public static void removeEPGPageContext(PageContext pageContext) throws JspException{
		pageContext.removeAttribute(EPG_PAGE_CONTEXT_NAME);
	}
	

}
