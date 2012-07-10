package chances.epg.taglib.bean;

import javax.servlet.jsp.JspException;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class BoxTest {

	@Test
	public void testToString() throws JspException {
		Box box = new  Box("","","");
		String css= "position: absolute; left: 10px; top: 15px; width: 20px; heigth: 30px";
		box.setPosition("absolute");
		box.setLeft(10);
		box.setTop(15);
		box.setWidth(20);
		box.setHeight(30);
		assertEquals(css,box.toString());
	}

}
