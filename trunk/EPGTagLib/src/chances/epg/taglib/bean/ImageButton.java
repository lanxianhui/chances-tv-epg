package chances.epg.taglib.bean;

public class ImageButton implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String src;
	private String grayedSrc;
	private int height;
	private int width;
	private boolean transparent ;
	private boolean disabled ;
	private int type;
	private String id;
	private Link link = new Link();
	public ImageButton() {
		super();
	}
	public ImageButton(String image) {
		this();
		this.src = image;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getGrayedSrc() {
		return grayedSrc;
	}
	public void setGrayedSrc(String grayedSrc) {
		this.grayedSrc = grayedSrc;
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
	public boolean isTransparent() {
		return transparent;
	}
	public void setTransparent(boolean transparent) {
		this.transparent = transparent;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public void setLink(Link link) {
		this.link = link;
	}
	public Link getLink() {
		return link;
	}
}
