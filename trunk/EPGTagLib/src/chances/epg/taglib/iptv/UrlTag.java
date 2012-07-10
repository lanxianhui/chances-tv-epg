package chances.epg.taglib.iptv;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.tagext.TagSupport;

public class UrlTag extends TagSupport {


	private static final long serialVersionUID = 1L;
	
	private Object value;
	
	private String type;
	
	private String var;
	
	private Map<String,String> params ;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void release() {		
		super.release();
		if(this.params!=null){
			this.params.clear();
		}
		this.params = null;
		this.value =null;
		this.type = null;
		this.var = null;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void addParam(String name, String paramValue) {
		if(this.params==null){
			this.params= new HashMap<String,String>();
		}
		 this.params.put(name,paramValue);
	}
	
}
