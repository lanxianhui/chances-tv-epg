package chances.epg.taglib.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.css.CSSStyleDeclaration;

public class BoxStyle {

	static Pattern pattern = Pattern.compile("\\d+");
	private CSSStyleDeclaration cssStyle;

	public BoxStyle(CSSStyleDeclaration style) {
		this.cssStyle = style;
	}

	public String getPosition() {
		return this.getStyleValue("position");
	}

	public void setPosition(String position) {
		if (cssStyle != null) {
			cssStyle.setProperty("position", position, "");
		}
	}

	public int getWidth() {
		return getStyleIntValue("width");
	}

	public void setWidth(int width) {
		setStyleIntValue("width", width);
	}

	public int getHeight() {
		return getStyleIntValue("height");
	}

	public void setHeight(int height) {
		setStyleIntValue("heigth", height);
	}

	public int getLeft() {
		return getStyleIntValue("left");
	}

	public void setLeft(int left) {
		setStyleIntValue("left", left);
	}

	public int getTop() {
		return getStyleIntValue("top");
	}

	public void setTop(int top) {
		setStyleIntValue("top", top);
	}

	public String getStyleValue(String property) {

		return cssStyle.getPropertyValue(property);
	}

	public void setStyleValue(String property, String value) {
		if (cssStyle != null) {
			cssStyle.setProperty(property, value, "");
		}
	}

	protected void setStyleIntValue(String property, int width) {
		if (cssStyle != null) {
			cssStyle.setProperty(property, width + "px", "");
		}
	}

	protected int getStyleIntValue(String property) {
		if (cssStyle != null) {
			String value = cssStyle.getPropertyValue(property);
			if (value != null) {
				return getIntValue(value);
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return this.cssStyle.getCssText();
	}

	public int getBottom() {
		return this.getStyleIntValue("bottom");
	}

	public int getRight() {
		return this.getStyleIntValue("right");
	}

	public int getIntValue(String value) {
		Matcher m = pattern.matcher(value);
		if (m.find()) {
			return Integer.parseInt(m.group());
		}
		return 0;
	}

}
