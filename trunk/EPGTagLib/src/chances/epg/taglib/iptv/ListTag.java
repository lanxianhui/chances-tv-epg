package chances.epg.taglib.iptv;

import javax.servlet.jsp.JspException;

public class ListTag extends GridTag {

	private  boolean horizontal;
	
	private  String icon;

	private  String lineImage;
	

	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		if(this.horizontal){
			this.setCols(this.varList.size());
			this.setRows(1);
		}else{
			this.setCols(1);
			this.setRows(this.varList.size());
		}
		return super.doStartTag();
	}

	public boolean isHorizontal() {
		return horizontal;
	}



	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}



	public String getIcon() {
		return icon;
	}



	public void setIcon(String icon) {
		this.icon = icon;
	}





	public String getLineImage() {
		return lineImage;
	}



	public void setLineImage(String lineImage) {
		this.lineImage = lineImage;
	}





}
