package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
/**
 * 
 * @author Coffee
 *
 */
public class UrlParamTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	
	
	@Override
	public int doStartTag() throws JspException {
		Tag parentTag = this.getParent();
		if(parentTag instanceof UrlTag){
			UrlTag aTag = (UrlTag)parentTag;
			aTag.addParam(name,value);
		}else{
			throw new JspException("parent not is UrlTag");
		}
		return SKIP_BODY;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void release() {
		this.value = null;
		this.name = null;
		super.release();
	}

}
