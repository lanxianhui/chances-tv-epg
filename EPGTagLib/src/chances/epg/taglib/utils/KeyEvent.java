package chances.epg.taglib.utils;

import java.util.HashMap;

import javax.servlet.jsp.PageContext;

public class KeyEvent {

	public static String KEY_PAGE_DOWN = "KEY_PAGE_DOWN";
	public static String KEY_PAGE_UP = "KEY_PAGE_UP";
	public static String KEY_UP = "KEY_DOWN";
	public static String KEY_DOWN = "KEY_UP";
	public static String KEY_LEFT = "KEY_LEFT";
	public static String KEY_RIGHT = "KEY_RIGHT";
	public static String KEY_NUM = "KEY_NUM";
	public static String KEY_RETURN  ="KEY_RETURN";
	public static String KEY_OK = "KEY_OK";

	public static int ON_KEY_NUM = 0x0030;
	public static int ON_KEY_UP = 0x0026;
	public static int ON_KEY_DOWN = 0x0028;
	public static int ON_KEY_LEFT = 0x0025;
	public static int ON_KEY_RIGHT = 0x0027;
	public static int ON_KEY_ON = 0x0027;
	public static int ON_KEY_PAGE_UP = 0x0002;
	public static int ON_KEY_PAGE_DOWN = 0x0002;
	public static int ON_KEY_RETURN = 0x002;
	public static int ON_KEY_OK = 0x013;
	
	public static HashMap<String ,Integer> keyMap = new HashMap<String ,Integer>();
	
	static {
		keyMap.put(KEY_PAGE_DOWN, ON_KEY_PAGE_DOWN);
		keyMap.put(KEY_PAGE_UP, ON_KEY_PAGE_UP);
		keyMap.put(KEY_RETURN, ON_KEY_RETURN);
		keyMap.put(KEY_OK, ON_KEY_OK);
		
	}

	public static int getKey(String name, PageContext pageContext) {
		Integer keyValue =  keyMap.get(name);
		if(keyValue!=null){
			return keyValue.intValue();
		}else{
			return -1;
		}
	}

	/*
	 * keyCodeArray["remotePlayPause"] = 0x0107; keyCodeArray["remoteBack"] =
	 * 0x0008; keyCodeArray["onKeyNumChar"] = 0x0030; keyCodeArray["onKeyUp"] =
	 * 0x0026; keyCodeArray["onKeyDown"] = 0x0028; keyCodeArray["onKeyLeft"] =
	 * 0x0025; keyCodeArray["onKeyRight"] = 0x0027; keyCodeArray["onKeyOK"] =
	 * 0x000D; keyCodeArray["onKeySpacebar"] = 0x0020;
	 * keyCodeArray["remoteLastChannel"] = 0x0118;
	 * keyCodeArray["remoteVolumePlus"] = 0x0103;
	 * keyCodeArray["remoteVolumeMinus"] = 0x0104;
	 * keyCodeArray["remoteVolumeMute"] = 0x0105; keyCodeArray["remoteStop"] =
	 * 0x010E; keyCodeArray["remoteFastForword"] = 0x0108;
	 * keyCodeArray["remoteFastRewind"] = 0x0109; keyCodeArray["remoteGoEnd"] =
	 * 0x010A; keyCodeArray["remoteGoBeginning"] = 0x010B;
	 * keyCodeArray["onKeyRed"] = 0x0113; keyCodeArray["onKeyGreen"] = 0x0114;
	 * keyCodeArray["onKeyYellow"] = 0x0115; keyCodeArray["onKeyBlue"] = 0x0116;
	 * keyCodeArray["onKeyGrey"] = 0x0117; keyCodeArray["remoteMenu"] = 0x0110;
	 * keyCodeArray["remoteInputMode"] = 0x011B; keyCodeArray["remoteHelp"] =
	 * 0x011C; keyCodeArray["remoteInfo"] = 0x010c;
	 * keyCodeArray["remoteKeyInterx"] = 0x010D;
	 * keyCodeArray["remoteChannelPlus"] = 0x0101;
	 * keyCodeArray["remoteChannelMinus"] = 0x0102;
	 * keyCodeArray["remoteLocation"] = 0x010F; keyCodeArray["remoteAudioTrack"]
	 * = 0x0106; keyCodeArray["remoteFavorite"] = 0x0119;
	 * keyCodeArray["remoteBookmark"] = 0x011A; keyCodeArray["remotePlayNext"] =
	 * 0x0022; keyCodeArray["remotePlayLast"] = 0x0021;
	 * keyCodeArray["virtualEvent"] = 0x0300;
	 */
}
