package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import chances.epg.taglib.bean.Link;
import chances.epg.taglib.utils.TagUtils;

public class KeyEventTag extends TagSupport{

	private String key;
	private String action ;
	private String href;
	private String linkId;
	
	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	public String getKey() {
		return key;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		Link aLink = new Link();
		aLink.setAction(this.action);
		aLink.setHref(this.href);
		aLink.setLinkId(this.linkId);
		aLink.setKey(this.key);
		TagUtils.registeLink(pageContext, aLink);
		this.clear();
		return SKIP_BODY;
	}
	
	@Override
	public void release() {
		this.clear();
		super.release();
	}
	private void clear() {
		this.action = null;
		this.key = null;
		this.linkId = null;
		this.href= null;
	}

}
