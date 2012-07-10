package chances.epg.taglib.bean;

public class PageLink {
	
	private String lastLink;
	private String nextLink;
	private String fristLink;
	private String privLink;
	private String path;
	private PageBean pageBean;
	public PageLink(PageBean bean ,String path) {
		this.path = path;
	}
	public String getLastLink() {
		return path+"?"+lastLink;
	}
	public void setLastLink(String lastLink) {
		this.lastLink = lastLink;
	}
	public String getNextLink() {
		return path+"?"+nextLink;
	}
	public void setNextLink(String nextLink) {
		this.nextLink = nextLink;
	}
	public String getFristLink() {
		return path+"?"+fristLink;
	}
	public void setFristLink(String fristLink) {
		this.fristLink = fristLink;
	}
	public String getPrivLink() {
		return path+"?"+privLink;
	}
	public void setPrivLink(String privLink) {
		this.privLink = privLink;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	
}
