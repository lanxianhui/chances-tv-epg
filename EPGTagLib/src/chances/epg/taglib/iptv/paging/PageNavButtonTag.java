package chances.epg.taglib.iptv.paging;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import chances.epg.taglib.iptv.ImageButtonTag;

public abstract class PageNavButtonTag extends ImageButtonTag{

	private static final long serialVersionUID = 1L;

	public abstract int getType();
	
	public void register(){
		Tag tag = this.getParent();
		if(tag != null){
			PagingTag pageingTag = (PagingTag) tag;
			pageingTag.registeButton(this.getType(), super.imageButton);
		}
	}

	@Override
	public int doEndTag() throws JspException {
		this.register();
		return SKIP_BODY;
	}

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}
	
}
