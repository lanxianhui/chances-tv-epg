package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;

import chances.epg.taglib.utils.HtmlUtils;
import chances.epg.taglib.utils.TagUtils;

public class ImageTag extends AbstractBoxTag {
	private static final long serialVersionUID = 1L;
	public final static String POSTER_TYPE = "poster";
	public final static String TEMPLATE_TYPE = "template";
	public final static String CONTEXT_TYPE = "context";

	protected String type;

	private String src;

	private String hit;

	private int height;
	private int width;

	@Override
	public int doEndTag() throws JspException {
		if (this.height == 0 || width == 0) {
			this.height = super.box.getHeight();
			this.width = super.box.getWidth();
		}
		boolean genDiv = (super.box.getTop() + super.box.getLeft()) > 0;
		String imageSrc = src;
		if (src != null && src.startsWith("/")) {
			String root = TagUtils.getImagePathDefine(pageContext, type);
			imageSrc = pathJoin(root, src);
		}
		StringBuffer buffer = new StringBuffer();

		if (genDiv) {
			buffer.append(HtmlUtils
					.createElementBegin(pageContext, this, "div"));
		}
		HtmlUtils.createImageHtml(pageContext, buffer, this.getId(), imageSrc,
				width, height);
		if (genDiv) {
			buffer.append(HtmlUtils.createElementEnd(pageContext, "div"));
		}
		TagUtils.write(pageContext, buffer.toString());
		//this.release();
		return SKIP_BODY;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String pathJoin(String path, String fname) {

		path = (path == null ? "" : path);
		fname = (fname == null ? "" : fname);
		String result = path + fname;
		if (path.charAt(path.length() - 1) == '/') {
			if (fname.startsWith("/")) {
				// 都有"/"
				result = path + fname.substring(1);
			}
		} else {
			// 都没有"/"
			if (!fname.startsWith("/")) {
				result = path + "/" + fname;
			}
		}
		return result;
	}

	@Override
	public void release() {
		super.release();
		this.type = null;
		this.height = 0;
		this.width = 0;
		this.src = null;
		this.hit = null;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
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

}
