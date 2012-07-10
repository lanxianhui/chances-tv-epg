package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;

import chances.epg.taglib.bean.ImageButton;
import chances.epg.taglib.utils.HtmlUtils;

public class ImageButtonTag extends AbstractBoxTag {
	
	private static final long serialVersionUID = 1L;
	protected ImageButton imageButton = new ImageButton();

	@Override
	public void release() {
		this.imageButton = new ImageButton();
		super.release();
	}
	@Override
	public int doEndTag() throws JspException {
	   StringBuffer buffer = new StringBuffer();
	   HtmlUtils.createImageHtml(this.pageContext,buffer,imageButton);
	  return SKIP_BODY;
	}
	public String getSrc() {
		return imageButton.getSrc();
	}
	public void setSrc(String src) {
		imageButton.setSrc(src);
	}
	public String getGrayedSrc() {
		return imageButton.getGrayedSrc();
	}
	public void setGrayedSrc(String grayedSrc) {
		imageButton.setGrayedSrc(grayedSrc);
	}

	public int getHeight() {
		return imageButton.getHeight();
	}
	public void setHeight(int height) {
		imageButton.setHeight(height);
	}
	public int getWidth() {
		return imageButton.getWidth();
	}
	public void setWidth(int width) {
		imageButton.setWidth(width);
	}
	public boolean isTransparent() {
		return imageButton.isTransparent();
	}
	public void setTransparent(boolean transparent) {
		imageButton.setTransparent(transparent);
	}
	public void setDisabled(boolean disabled) {
		imageButton.setDisabled(disabled);
	}
	public int getType() {
		return imageButton.getType();
	}
	public int hashCode() {
		return imageButton.hashCode();
	}
	public boolean isDisabled() {
		return imageButton.isDisabled();
	}
	public void setType(int type) {
		imageButton.setType(type);
	}

}
