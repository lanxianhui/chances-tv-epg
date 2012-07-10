package chances.epg.taglib.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TagLogFactory {
	public static Log getGridTagLog(){
		return LogFactory.getLog("grid");
	}
	public static Log getBoxTagLog(){
		return LogFactory.getLog("box");
	}
	
	
}
