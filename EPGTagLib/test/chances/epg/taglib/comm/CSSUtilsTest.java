package chances.epg.taglib.comm;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import chances.epg.taglib.utils.CSSUtils;

public class CSSUtilsTest {

	
	String css= "position:absolute; left:10px;top:15px;width:20px;height:30px;margin-top:25px;margin-left:15px";
	
	@Test
	public void testParse() throws IOException {
		Map<String, String> result = CSSUtils.parse(css);
		assertEquals("absolute",result.get("position"));
		assertEquals("10px",result.get("left"));
		assertEquals("15px",result.get("top"));
		assertEquals("25px",result.get("margin-top"));
		assertEquals("15px",result.get("margin-left"));
	}

	
	
	@Test
	public void testParseBox() throws IOException {
		/*
		Box box = CSSUtils.parseBox(css);
		assertEquals("absolute",box.getPosition());
		assertEquals(10,box.getLeft());
		assertEquals(15,box.getTop());
		*/
	}
}
