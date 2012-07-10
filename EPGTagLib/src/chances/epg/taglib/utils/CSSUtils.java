package chances.epg.taglib.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSStyleDeclaration;

import chances.epg.taglib.bean.BoxStyle;

import com.steadystate.css.parser.CSSOMParser;

public class CSSUtils {
	static CSSOMParser cssParser = new CSSOMParser();

	/**
	 * 将CSS中的参数转换为一个Map
	 * @param css css字符串
	 * @return  java.util.Map
	 * @throws IOException
	 */
	public static Map<String, String> parse(String css) throws IOException {
		HashMap<String, String> result = new HashMap<String, String>();

		InputSource ins = new InputSource(new StringReader(css));

		CSSStyleDeclaration cssDec = cssParser.parseStyleDeclaration(ins);
		int length = cssDec.getLength();
		for (int i = 0; i < length; i++) {
			String name = cssDec.item(i);
			result.put(name, cssDec.getPropertyValue(name));
		}
		return result;
	}
	/**
	 * 根据CSS创建一个定位数据对象
	 * @param css
	 * @return
	 * @throws JspException
	 */
	public static BoxStyle createBoxStyle(String css) throws JspException {

		CSSStyleDeclaration result;
		try {
			result = parseStyle(css);
			return new BoxStyle(result);
		} catch (IOException e) {
			throw new JspException(e);
		}
		
	}
	
	protected static CSSStyleDeclaration parseStyle(String css) throws IOException {
		InputSource ins = new InputSource(new StringReader(css));
		CSSStyleDeclaration result = cssParser.parseStyleDeclaration(ins);
		return result;
	}

	
}
