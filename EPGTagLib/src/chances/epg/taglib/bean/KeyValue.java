package chances.epg.taglib.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class KeyValue implements java.io.Serializable {

	private static final long serialVersionUID = -3600832288001442475L;
	private String key;
	private String value;

	public KeyValue() {
		super();
	}

	public KeyValue(String key, String value) {
		this();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {

		return key + "=" + value;
	}

	public String toParamString() throws UnsupportedEncodingException {
		return toParamString("UTF-8");
	}
	public String toParamString(String encoder) throws UnsupportedEncodingException {
		String aValue = URLEncoder.encode(value,encoder );
		return key + "=" + aValue;
	}

}
