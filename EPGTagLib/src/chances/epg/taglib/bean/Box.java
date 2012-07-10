package chances.epg.taglib.bean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import chances.epg.taglib.utils.CSSUtils;

public class Box implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BoxStyle cssStyle;
	private BoxStyle marginStyle;
	private BoxStyle paddingStyle;
	private Box parent;

	private List<Box> children = new ArrayList<Box>();

	public Box getParent() {
		return parent;
	}

	public void setParent(Box parent) {
		this.parent = parent;
	}

	public List<Box> getChildren() {

		return children;
	}

	public void setChildren(List<Box> children) {
		this.children = children;
	}

	public Box() throws JspException {
		this("", "", "");
		this.setPosition("absolute");
	}
	public Box(String cssStyle) throws JspException {
		this(cssStyle, "", "");
		this.setPosition("absolute");
	}

	public Box(String cssStyle, String marginStyle, String paddingStyle)
			throws JspException {
		super();
		cssStyle = (cssStyle==null)?"":cssStyle;
		this.cssStyle = CSSUtils.createBoxStyle(cssStyle);
		marginStyle = (marginStyle==null)?"":marginStyle;
		this.marginStyle = CSSUtils.createBoxStyle(marginStyle);
		paddingStyle = (paddingStyle==null)?"":paddingStyle;
		this.paddingStyle = CSSUtils.createBoxStyle(paddingStyle);

	}

	public String getPosition() {
		return this.cssStyle.getPosition();
	}

	public void setPosition(String position) {
		this.cssStyle.setPosition(position);
	}

	public int getWidth() {
		return this.cssStyle.getWidth();
	}

	public void setWidth(int width) {
		this.cssStyle.setWidth(width);
	}

	public int getHeight() {
		return this.cssStyle.getHeight();
	}

	public void setHeight(int height) {
		this.cssStyle.setHeight(height);
	}

	public int getLeft() {
		return this.cssStyle.getLeft();
	}

	public void setLeft(int left) {
		this.cssStyle.setLeft(left);
	}

	public int getTop() {
		return this.cssStyle.getTop();
	}

	public void setTop(int top) {
		this.cssStyle.setTop(top);
	}

	@Override
	protected void finalize() throws Throwable {
		this.children.clear();
		super.finalize();
	}

	public void addChild(Box child) {
		this.children.add(child);

	}

	public int getMarginTop() {
		return this.marginStyle.getTop();
	}

	public int getMarginLeft() {
		return this.marginStyle.getLeft();

	}

	public int getMarginBottom() {
		return this.marginStyle.getBottom();
	}

	public int getMarginRight() {
		return this.marginStyle.getRight();
	}

	public int getPaddingTop() {
		return this.paddingStyle.getTop();
	}

	public int getPaddingLeft() {
		return this.paddingStyle.getLeft();

	}

	public int getPaddingBottom() {
		return this.paddingStyle.getBottom();
	}

	public int getPaddingRight() {
		return this.paddingStyle.getRight();
	}

	@Override
	public String toString() {
		return this.cssStyle.toString();
	}

}
