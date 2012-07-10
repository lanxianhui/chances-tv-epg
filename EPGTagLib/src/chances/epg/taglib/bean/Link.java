package chances.epg.taglib.bean;

public class Link implements java.io.Serializable {
	private String key;
	private String action ;
	private String href;
	private String linkId;
	private String onMouseOver;
	private String onMouseOut;
	private String onFocus;
	private String onBlur;
	private String excludeParams;
	private String target;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1363286393742966923L;

	public Link(String href) {
	  this.href = href;
	}

	public Link() {
		super();
	}

	public Link(String href, int key2) {
		this(href);
		this.key = key2+"";
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getOnMouseOver() {
		return onMouseOver;
	}

	public void setOnMouseOver(String onMouseOver) {
		this.onMouseOver = onMouseOver;
	}

	public String getOnMouseOut() {
		return onMouseOut;
	}

	public void setOnMouseOut(String onMouseOut) {
		this.onMouseOut = onMouseOut;
	}

	public String getOnFocus() {
		return onFocus;
	}

	public void setOnFocus(String onFocus) {
		this.onFocus = onFocus;
	}

	public String getOnBlur() {
		return onBlur;
	}

	public void setOnBlur(String onBlur) {
		this.onBlur = onBlur;
	}

	public String getExcludeParams() {
		return excludeParams;
	}

	public void setExcludeParams(String excludeParams) {
		this.excludeParams = excludeParams;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
