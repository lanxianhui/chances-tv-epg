package chances.epg.taglib.utils;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;

import chances.epg.taglib.bean.Box;
import chances.epg.taglib.bean.ImageButton;
import chances.epg.taglib.bean.Link;
import chances.epg.taglib.iptv.AbstractBoxTag;

public class HtmlUtils {
	public static String createElementBegin(PageContext pageContext,
			AbstractBoxTag tag, String tagName) {
		StringBuffer params = new StringBuffer();
		tag.getBox().setPosition("absolute");
		getNameValueStr(params, "style", tag.getBox().toString());
		getNameValueStr(params, "id", tag.getId());
		getNameValueStr(params, "class", tag.getStyleClass());
		StringBuffer content = new StringBuffer();
		content.append("<" + tagName);
		String paramStr = params.toString();
		if (paramStr.length() > 0) {
			content.append(" ");
			content.append(paramStr);
		}
		content.append(">");
		return content.toString();
	}

	public static String createElementEnd(PageContext pageContext,
			String tagName) {

		StringBuffer content = new StringBuffer();
		content.append("</");
		content.append(tagName);
		content.append(">");
		return content.toString();
	}

	public static void createImageHtml(PageContext pageContext,
			StringBuffer buffer, String id, String imageSrc, int width,
			int height) {
		buffer.append("<img");
		getNameValueStr(buffer, "id", id);
		getNameValueStr(buffer, "src",imageSrc);
		getNameValueStr(buffer, "width", width + "");
		getNameValueStr(buffer, "height", height + "");
		getNameValueStr(buffer, "border", "0");
		buffer.append("/>");

	}

	public static void createImageHtml(PageContext pageContext,
			StringBuffer buffer, ImageButton imgBtn) {
		buffer.append("<img");
		getNameValueStr(buffer, "id", imgBtn.getId());
		if (!imgBtn.isTransparent()) {
			if (imgBtn.isDisabled()) {
				getNameValueStr(buffer, "src", imgBtn.getGrayedSrc());
			} else {
				getNameValueStr(buffer, "src", imgBtn.getSrc());
			}
		} else {
			if (!imgBtn.isDisabled()) {
				getNameValueStr(buffer, "src",
						(String) pageContext
								.getAttribute("default_force_image"));
			}

		}
		getNameValueStr(buffer, "width", imgBtn.getWidth() + "");
		getNameValueStr(buffer, "height", imgBtn.getHeight() + "");
		getNameValueStr(buffer, "border", "0");
		buffer.append("/>");

	}

	public static String createText(PageContext pageContext, Box box,
			String content) {
		StringBuffer buffer = new StringBuffer();
		if (box != null) {
			buffer.append("\r\n<span");
			getNameValueStr(buffer, "style", box.toString());
		}
		buffer.append(">");
		buffer.append(content);
		if (box != null) {
			buffer.append("\r\n</span>\r\n");
		}
		return buffer.toString();

	}

	public static StringBuffer getNameValueStr(StringBuffer buffer,
			String name, String value) {

		if (value == null || value.length() == 0) {
			return buffer;
		}
		if (buffer.length() > 0) {
			buffer.append(" ");
		}
		buffer.append(name);
		buffer.append("=");
		buffer.append("\"");
		buffer.append(value);
		buffer.append("\"");
		return buffer;
	}

	public static String linkZone(PageContext pageContext, Box box,
			String href, ImageButton imageButton) {
		StringBuffer buffer = new StringBuffer();
		if (box != null) {
			buffer.append("\r\n<div");
			getNameValueStr(buffer, "style", box.toString());
		}
		buffer.append(">\r\n");
		buffer.append("\t<a ");
		getNameValueStr(buffer, "href", href);
		buffer.append(">\r\n\t\t");
		createImageHtml(pageContext, buffer, imageButton);
		buffer.append("\r\n\t</a>");
		if (box != null) {
			buffer.append("\r\n</div>\r\n");
		}
		return buffer.toString();
	}

	public static String linkZone(PageContext pageContext, Link link,
			String string) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("<a ");
		getNameValueStr(buffer, "href", link.getHref());
		buffer.append(">\r\n\t");
		buffer.append(string);
		buffer.append("\r\n\t</a>");

		return buffer.toString();
	}

	/**
	 * 
	 * @param pageContext
	 * @param box
	 * @param href
	 * @param content
	 * @return
	 */
	public static String linkZone(PageContext pageContext, Box box,
			String href, String content) {
		StringBuffer buffer = new StringBuffer();
		if (box != null) {
			buffer.append("\r\n<div");
			getNameValueStr(buffer, "style", box.toString());
		}
		buffer.append(">");
		buffer.append("<a ");
		getNameValueStr(buffer, "href", href);
		buffer.append(">\r\n");
		buffer.append(content);
		buffer.append("\r\n</a>");
		if (box != null) {
			buffer.append("\r\n</div>\r\n");
		}
		return buffer.toString();
	}

	/**
	 * 
	 * @param pageContext
	 * @param box
	 * @param imageButton
	 * @return
	 */
	public static String linkZone(PageContext pageContext, Box box,
			ImageButton imageButton) {
		StringBuffer buffer = new StringBuffer();
		Link alink = imageButton.getLink();
		String link = null;
		if (alink != null) {
			link = alink.getHref();
		}
		if (box != null) {
			buffer.append("\r\n<div");
			getNameValueStr(buffer, "style", box.toString());
		}
		buffer.append(">\r\n");
		if (!imageButton.isDisabled()) {
			buffer.append("\t<a ");
			getNameValueStr(buffer, "href", link);
			buffer.append(">\r\n\t\t");
		}
		createImageHtml(pageContext, buffer, imageButton);
		if (!imageButton.isDisabled()) {
			buffer.append("\r\n\t</a>");
		}
		if (box != null) {
			buffer.append("\r\n</div>\r\n");
		}
		return buffer.toString();
	}

	/**
	 * 
	 * @param pageContext
	 * @param box
	 * @param href
	 * @return
	 * @throws JspException
	 */
	public static String linkZone(PageContext pageContext, Box box, Link link)
			throws JspException {
		StringBuffer buffer = new StringBuffer();
		if (box != null) {
			buffer.append("\r\n<div");
			getNameValueStr(buffer, "style", box.toString());
		}
		buffer.append(">\r\n");
		buffer.append("<a ");
		getNameValueStr(buffer, "href", link.getHref());
		buffer.append(">\r\n");
		buffer.append("\r\n<img  ");
		getNameValueStr(buffer, "border", "0");
		String imgSrc = TagUtils.getForceImage(pageContext);
		getNameValueStr(buffer, "src", imgSrc);
		getNameValueStr(buffer, "width", "" + box.getWidth());
		getNameValueStr(buffer, "height", "" + box.getHeight());
		buffer.append("/>");
		buffer.append("\r\n</a>");
		if (box != null) {
			buffer.append("\r\n</div>\r\n");
		}
		return buffer.toString();
	}

	public static String createFormQuery(PageContext pageContext,
			Map<String, String> params, String formId) throws JspTagException {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<form ");
		getNameValueStr(buffer, "id", formId);
		getNameValueStr(buffer, "name", formId);
		buffer.append(">\r\n");
		for (Entry<String, String> entry : params.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();
			buffer.append("<input ");
			getNameValueStr(buffer, "name", name);
			getNameValueStr(buffer, "type", "hidden");
			getNameValueStr(buffer, "value", value);
			getNameValueStr(buffer, "id", name);
			buffer.append("/>\r\n");
		}
		buffer.append("/r/n</form>");
		return buffer.toString();
	}

}
