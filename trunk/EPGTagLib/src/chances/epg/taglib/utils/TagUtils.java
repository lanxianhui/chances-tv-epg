package chances.epg.taglib.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import chances.epg.taglib.bean.EPGPageContext;
import chances.epg.taglib.bean.Link;
import chances.epg.taglib.bean.PageBean;
import chances.epg.taglib.bean.PageLink;
import chances.epg.taglib.iptv.AbstractBoxTag;

public class TagUtils {

	private static final String PAGE_NO = "pageIndex";
	public static final String VALID_SCHEME_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-";

	public static String getForceImage(PageContext pageContext)
			throws JspException {

		String path = (String) pageContext.getAttribute("DEFAULT_FORCE_IMAGE");
		if (path == null) {
			path = "/images/force.gif";
		}
		return resolveUrl(path, null, pageContext);
	}

	/**
	 * 
	 * @param pageContext
	 * @param buffer
	 * @param imgBtn
	 */

	/**
	 * 
	 * @param pageContext
	 * @return
	 */
	public static Map<String, String> getParams(PageContext pageContext) {
		HashMap<String,String> map = new HashMap<String, String>();
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		Enumeration eums = request.getParameterNames();
		while (eums.hasMoreElements()) {
			String name = (String) eums.nextElement();
			String value = request.getParameter(name);
			map.put(name, value);
		}
		return map;
	}

	/**
	 * 鐢熸垚涓�釜鏌ヨ鍙傛暟
	 * 
	 * @param pageContext
	 * @param params
	 * @return
	 * @throws JspTagException
	 */
	public static String createQueryString(PageContext pageContext,
			Map<String, String> params) throws JspTagException {
		StringBuffer buffer = new StringBuffer();
		String enc = pageContext.getResponse().getCharacterEncoding();
		for (Entry<String, String> entry : params.entrySet()) {
			try {
				String name = URLEncoder.encode(entry.getKey(), enc);
				String value = URLEncoder.encode(entry.getValue(), enc);
				buffer.append(name).append("=").append(value);
				buffer.append("&");
			} catch (UnsupportedEncodingException e) {
				throw new JspTagException(e);
			}
		}
		buffer.deleteCharAt(buffer.length() - 1);
		return buffer.toString();
	}

	public static String resolveUrl(String url, String context,
			PageContext pageContext) throws JspException {
		// don't touch absolute URLs
		if (isAbsoluteUrl(url)) {
			return url;
		}

		// normalize relative URLs against a context root
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		if (context == null) {
			if (url.startsWith("/")) {
				return (request.getContextPath() + url);
			} else {
				return url;
			}
		} else {
			if (!context.startsWith("/") || !url.startsWith("/")) {
				throw new JspTagException("IMPORT_BAD_RELATIVE");
			}
			if (context.endsWith("/") && url.startsWith("/")) {
				// Don't produce string starting with '//', many
				// browsers interpret this as host name, not as
				// path on same host. Bug 22860
				// Also avoid // inside the url. Bug 34109
				return (context.substring(0, context.length() - 1) + url);
			} else {
				return (context + url);
			}
		}
	}

	public static boolean isAbsoluteUrl(String url) {
		// a null URL is not absolute, by our definition
		if (url == null) {
			return false;
		}

		// do a fast, simple check first
		int colonPos;
		if ((colonPos = url.indexOf(":")) == -1) {
			return false;
		}

		// if we DO have a colon, make sure that every character
		// leading up to it is a valid scheme character
		for (int i = 0; i < colonPos; i++) {
			if (VALID_SCHEME_CHARS.indexOf(url.charAt(i)) == -1) {
				return false;
			}
		}

		// if so, we've got an absolute url
		return true;
	}

	/**
	 * Strips a servlet session ID from <tt>url</tt>. The session ID is encoded
	 * as a URL "path parameter" beginning with "jsessionid=". We thus remove
	 * anything we find between ";jsessionid=" (inclusive) and either EOS or a
	 * subsequent ';' (exclusive).
	 */
	public static String stripSession(String url) {
		StringBuffer u = new StringBuffer(url);
		int sessionStart;
		while ((sessionStart = u.toString().indexOf(";jsessionid=")) != -1) {
			int sessionEnd = u.toString().indexOf(";", sessionStart + 1);
			if (sessionEnd == -1) {
				sessionEnd = u.toString().indexOf("?", sessionStart + 1);
			}
			if (sessionEnd == -1) // still
			{
				sessionEnd = u.length();
			}
			u.delete(sessionStart, sessionEnd);
		}
		return u.toString();
	}

	/**
	 * 
	 * @param pageContext
	 * @param pageBean
	 * @return
	 * @throws JspTagException
	 */
	public static PageLink createPageLink(PageContext pageContext,
			PageBean pageBean) throws JspTagException {

		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		String path = request.getServletPath();
		path =request.getRequestURI();
		PageLink result = new PageLink(pageBean, path);
		Map<String, String> params = getParams(pageContext);
		params.put(PAGE_NO, "1");
		result.setFristLink(createQueryString(pageContext, params));
		params.put(PAGE_NO, pageBean.getPageCount() + "");
		result.setLastLink(createQueryString(pageContext, params));
		params.put(PAGE_NO, pageBean.getNextPageNo() + "");
		result.setNextLink(createQueryString(pageContext, params));
		params.put(PAGE_NO, pageBean.getPrevPageNo() + "");
		result.setPrivLink(createQueryString(pageContext, params));

		return result;
	}

	public static String getContextPath(PageContext pageContext) {
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		return request.getContextPath();
	}

	public static String getImagePathDefine(PageContext pageContext, String type) {
		String path = null;

		if (type != null) {
			if ("context".equalsIgnoreCase(type)) {
				path = getContextPath(pageContext);
			} else {
				String value = type.toUpperCase()+ "_ROOT_PATH";
				path = (String) pageContext.findAttribute(value);
				if(path ==null){
					path = (String)pageContext.getServletContext().getInitParameter(value);	
				}
			}
		}
		if (path == null) {
			path = type;
		}
		return path;
	}

	/**
	 * 
	 * @param pageContext
	 * @param content
	 * @throws JspException
	 */
	public static void write(PageContext pageContext, String content)
			throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.write(content);
		} catch (IOException e) {
			throw new JspException(e);
		}
	}

	/**
	 * 
	 * @param tag
	 * @param keyEventEntry
	 */
	public static void registeLink(PageContext pageContext, Link link) {
		EPGPageContext epgPageContext = EPGPageContext
				.getEPGPageContext(pageContext);
		epgPageContext.addLink(link);
	}

	public static void setVar(PageContext pageContext, String var,
			String scope, Object obj) throws JspException {
		if (var == null) {
			throw new JspException("var is null");
		} else {
			if (scope == null) {
				pageContext.setAttribute(var, obj);
			} else {
				// todo 鏂囧瓧鍒ゆ柇scope
				pageContext.setAttribute(var, obj, PageContext.PAGE_SCOPE);
			}
		}

	}

	public static AbstractBoxTag findParentBoxTag(PageContext pageContext,
			Tag tag) {
		AbstractBoxTag  result= null ;
		Tag aParentTag = tag.getParent() ;
		if(aParentTag == null){
			return null;
		}else{
			if(aParentTag instanceof AbstractBoxTag){
				return (AbstractBoxTag) aParentTag;
			}else{
				findParentBoxTag(pageContext,aParentTag);
			}
		}
		return result;
		
	}

}
