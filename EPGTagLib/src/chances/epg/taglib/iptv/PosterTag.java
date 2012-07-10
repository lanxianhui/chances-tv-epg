package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;

public class PosterTag extends ImageTag{

	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		this.type ="poster";
		return super.doEndTag();
	}
}
