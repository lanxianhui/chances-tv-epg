package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import chances.epg.taglib.bean.Box;
import chances.epg.taglib.utils.HtmlUtils;
import chances.epg.taglib.utils.TagUtils;

public class TextTag extends AbstractBoxTag {

	private static final long serialVersionUID = 1L;

	private int max;

	private String suffix;

	private LinkTag linkTag;

	private String fontStyle;

	private String value;

	private String align;

	private String vAlign;
	
	private int size;
	
	private String marquee;


	@Override
	public int doEndTag() throws JspException {
		String content = this.value;
		if (content == null) {
			content = this.bodyContent.getString();
		}
		if (content == null) {
			return SKIP_BODY;
		}
		content = content.trim();
		if (content.length() > this.max) {
			int suffixLen = 0;
			if (this.suffix != null) {
				suffixLen = this.suffix.length();
			}
			content = content.substring(this.max - suffixLen);
			content = content + (this.suffix == null ? "" : this.suffix);

		}
		if (linkTag == null) {
			content = HtmlUtils.createText(pageContext, box, content);
			TagUtils.write(pageContext, content);
		}
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		int height = 0;
		int width = 0;
		AbstractBoxTag aBoxTag = TagUtils.findParentBoxTag(pageContext, this);
		if (aBoxTag != null) {
			Box aParentBox = aBoxTag.getBox();
			;
			if (this.vAlign == null) {
				box.setTop(aParentBox.getTop() + aParentBox.getPaddingTop());
			} else {
				if ("top".equals(this.vAlign)) {
					height = aParentBox.getTop();
				} else if ("bottom".equals(this.vAlign)) {
					height = aParentBox.getTop() + box.getHeight()
							- box.getHeight();
				} else if ("center".equals(this.vAlign)) {
					height = (aParentBox.getHeight() + box.getHeight()) / 2;
					height = aParentBox.getTop() + height;
				}
				box.setTop(height);
			}
			if (this.align == null) {
				box.setLeft(aParentBox.getLeft() + aParentBox.getPaddingLeft());
			} else {
				if ("left".equals(this.vAlign)) {
					width = aParentBox.getLeft();
				} else if ("right".equals(this.vAlign)) {
					width = aParentBox.getLeft() + box.getWidth()
							- box.getWidth();
				} else if ("center".equals(this.vAlign)) {
					width = (aParentBox.getWidth() + box.getWidth()) / 2;
					width = aParentBox.getWidth() + width;
				}
				box.setLeft(width);
			}
		}
		Tag aTag = this.getParent();
		if (aTag instanceof LinkTag) {
			this.linkTag = (LinkTag) aTag;
		}

		return EVAL_BODY_BUFFERED;
	}

	private void caleValign() {

	}

	public LinkTag getLinkTag() {
		return linkTag;
	}

	public void setLinkTag(LinkTag linkTag) {
		this.linkTag = linkTag;
	}

	public String getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getvAlign() {
		return vAlign;
	}

	public void setvAlign(String vAlign) {
		this.vAlign = vAlign;
	}

	public int getSize() {
    	return size;
    }

	public void setSize(int size) {
		this.setMax(size);
    	this.size = size;
    }

	public String getMarquee() {
    	return marquee;
    }

	public void setMarquee(String marquee) {
    	this.marquee = marquee;
    }

}
