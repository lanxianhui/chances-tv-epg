package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;

import chances.epg.taglib.bean.Box;
import chances.epg.taglib.utils.TagLogFactory;

public  class AbstractBoxTag extends BodyTagSupport {

	private Log logger = TagLogFactory.getBoxTagLog();
	private String style;
	private String styleClass;
	private String margin;
	private String padding;
	private String elementId;
	protected Box box;
	protected String onClick;
	protected String href;
	protected String template;
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		logger.info("doStartTag");

		this.box = new Box(style, margin, padding);
		return EVAL_BODY_INCLUDE;
	}


	@Override
	public int doEndTag() throws JspException {

		logger.info("doEnd ");
		return super.doEndTag();
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		logger.info("set param");
		this.style = style;
	}



	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	@Override
	public void release() {
		this.box = null;
		this.elementId = null;
		this.style = null;
		this.styleClass = null;
		this.href = null;
		this.onClick = null;
		super.release();
	}

	@Override
	public void doInitBody() throws JspException {
		logger.info("doInit");
		super.doInitBody();
		this.box = new Box();
		Tag aTag = super.getParent();
		if (aTag instanceof AbstractBoxTag && aTag != null) {
			AbstractBoxTag boxTag = (AbstractBoxTag) aTag;
			boxTag.addChild(box);
			this.box.setParent(boxTag.getBox());
		}
	}

	private void addChild(Box child) {
		this.box.addChild(child);

	}

	public Box getBox() {
		return box;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public String getPadding() {
		return padding;
	}

	public void setPadding(String padding) {
		this.padding = padding;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		logger.info("do setpageContext ");
		super.setPageContext(pageContext);
	}

	@Override
	public void setBodyContent(BodyContent b) {
		logger.info("do setBodyContent ");
		super.setBodyContent(b);
	}


	public String getTemplate() {
		return template;
	}


	public void setTemplate(String template) {
		this.template = template;
	}
}
