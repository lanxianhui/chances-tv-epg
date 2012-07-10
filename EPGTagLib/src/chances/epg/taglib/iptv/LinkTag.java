package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import chances.epg.taglib.bean.Box;
import chances.epg.taglib.bean.Link;
import chances.epg.taglib.utils.HtmlUtils;
import chances.epg.taglib.utils.TagUtils;

public class LinkTag extends BodyTagSupport {
	private Link link = new Link();
	private boolean outputDisable;
	private Box box;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1743319371447795916L;

	@Override
	public int doStartTag() throws JspException {
		if (this.outputDisable) {
			return EVAL_BODY_INCLUDE;
		} else {
			return EVAL_BODY_BUFFERED;
		}
	}

	@Override
	public int doEndTag() throws JspException {
		if (this.outputDisable) {
			//String content = TagUtils.linkZone(pageContext, box, link);
			//TagUtils.write(pageContext, content);
		} else {
			String content = HtmlUtils.linkZone(pageContext, link,
					bodyContent.getString());
			TagUtils.write(pageContext, content);

		}
	
		return SKIP_BODY;
	}

	@Override
	public void setParent(Tag t) {
		this.link = new Link();
		if (t instanceof DivTag) {
			DivTag abstractBoxTag = (DivTag) t;
			this.box = abstractBoxTag.getBox();
			((DivTag) t).setLinkTag(this);
			outputDisable = true;
		} else {
			outputDisable = false;
		}

		super.setParent(t);
	}

	public String getHtml(Box box) throws JspException {
		String result = HtmlUtils.linkZone(pageContext, box, link);
		return result;
	}

	public String getKey() {
		return link.getKey();
	}

	public void setKey(String key) {
		link.setKey(key);
	}

	public String getAction() {
		return link.getAction();
	}

	public void setAction(String action) {
		link.setAction(action);
	}

	public String getHref() {
		return link.getHref();
	}

	public void setHref(String href) {
		link.setHref(href);
	}

	public String getLinkId() {
		return link.getLinkId();
	}

	public void setLinkId(String linkId) {
		link.setLinkId(linkId);
	}

	public String getOnMouseOver() {
		return link.getOnMouseOver();
	}

	public void setOnMouseOver(String onMouseOver) {
		link.setOnMouseOver(onMouseOver);
	}

	public String getOnMouseOut() {
		return link.getOnMouseOut();
	}

	public void setOnMouseOut(String onMouseOut) {
		link.setOnMouseOut(onMouseOut);
	}

	public String getOnFocus() {
		return link.getOnFocus();
	}

	public void setOnFocus(String onFocus) {
		link.setOnFocus(onFocus);
	}

	public String getOnBlur() {
		return link.getOnBlur();
	}

	public void setOnBlur(String onBlur) {
		link.setOnBlur(onBlur);
	}

	public String getExcludeParams() {
		return link.getExcludeParams();
	}

	public void setExcludeParams(String excludeParams) {
		link.setExcludeParams(excludeParams);
	}

	public String getTarget() {
		return link.getTarget();
	}

	public void setTarget(String target) {
		link.setTarget(target);
	}

}
