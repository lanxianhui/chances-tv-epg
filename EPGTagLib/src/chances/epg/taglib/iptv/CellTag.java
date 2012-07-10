package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;

import chances.epg.taglib.bean.Box;

public class CellTag extends DivTag {

	private static final long serialVersionUID = 1L;
	private int height;
	private int width;
	private String caption;


	public void cacle(Box parentBox, GridIndex gridIndex) {
		int aTop = box.getHeight() * gridIndex.getRowIndex()
				+ this.box.getMarginTop() * (gridIndex.getRowIndex() )
				+ parentBox.getTop();
		int aLeft = box.getWidth() * gridIndex.getColIndex()
				+ this.box.getMarginLeft() * (gridIndex.getColIndex() )
				+ parentBox.getLeft();
		box.setTop(aTop);
		box.setLeft(aLeft);
	}

	@Override
	public int doStartTag() throws JspException {
		this.box = new Box(this.getStyle(), this.getMargin(), this.getPadding());
		if (this.getParent() != null) {
			if (this.getParent() instanceof GridTag) {
				GridTag aGridTag = (GridTag) this.getParent();
				GridIndex gIndex = aGridTag.getGridIndex();
				this.pageContext.setAttribute(aGridTag.getIndexVar(), gIndex.getIndex());
				this.cacle(aGridTag.getBox(), gIndex);

			}
		}
		writeBegin();
		return EVAL_BODY_INCLUDE;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void release() {
		super.release();
	}

	

	@Override
	public int doEndTag() throws JspException {

		int result = super.doEndTag();
	
		return result;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

}
