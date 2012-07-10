package chances.epg.taglib.iptv.paging;

import javax.servlet.jsp.JspException;

import chances.epg.taglib.bean.Box;
import chances.epg.taglib.bean.ImageButton;
import chances.epg.taglib.bean.Link;
import chances.epg.taglib.bean.PageBean;
import chances.epg.taglib.bean.PageLink;
import chances.epg.taglib.iptv.AbstractBoxTag;
import chances.epg.taglib.utils.HtmlUtils;
import chances.epg.taglib.utils.KeyEvent;
import chances.epg.taglib.utils.TagUtils;

public class PagingTag extends AbstractBoxTag {
	public final static int FIRST_BUTTON_TYPE = 1;
	public final static int FRIOI_BUTTON_TYPE = 2;
	public final static int NEXT_BUTTON_TYPE = 3;
	public final static int LAST_BUTTON_TYPE = 4;

	private static final long serialVersionUID = 4946769727340628527L;
	private boolean vertical;
	private int space;
	private boolean keyEnable;
	private String method;
	private String prefix;
	private String buttonStyle;
	private boolean showFirst;
	private boolean showPrior = true;
	private boolean showNext = true;
	private boolean showLast;
	private boolean showInfo;

	private ImageButton nextBtn;
	private ImageButton priorBtn;
	private ImageButton lastBtn;
	private ImageButton firstBtn;

	private boolean hasImageButton;
	private int btnCount;
	ImageButton[] buttons;
	private Box btnBox;
	protected PageBean pageBean;

	@Override
	public int doEndTag() throws JspException {
		this.btnBox = new Box(this.buttonStyle, "", "");
		this.btnBox.setTop(box.getTop());
		this.btnBox.setLeft(box.getLeft());
		btnBox.setPosition("absolute");
		PageLink aPageLink = TagUtils.createPageLink(pageContext, pageBean);
		if (!this.hasImageButton) {
			this.initButton();
		}
		this.handleButton(aPageLink);
		StringBuffer htmlBuffer = new StringBuffer();
		for (int i = 0; i < this.buttons.length; i++) {
			htmlBuffer.append(HtmlUtils
					.linkZone(pageContext, btnBox, buttons[i]));
			this.moveBtnBox();
		}
		if (this.showInfo) {
			htmlBuffer.append(HtmlUtils.createText(
					pageContext,
					btnBox,
					this.pageBean.getCurrentPageNo() + "/"
							+ this.pageBean.getPageCount()));
		}

		TagUtils.write(pageContext, htmlBuffer.toString());
		this.release();
		super.doEndTag();
		return SKIP_BODY;
	}

	/**
	 * 为背景模式构造出图片
	 * 
	 * @throws JspException
	 */
	private void initButton() throws JspException {
		String image = TagUtils.getForceImage(pageContext);
		if (this.showFirst) {
			this.firstBtn = new ImageButton(image);
			this.btnCount++;
		}

		if (this.showPrior) {
			this.priorBtn = new ImageButton(image);
			this.btnCount++;
		}

		if (this.showNext) {
			this.nextBtn = new ImageButton(image);
			this.btnCount++;
		}
		if (this.showLast) {
			this.lastBtn = new ImageButton(image);
			this.btnCount++;
		}
	}

	private void handleButton(PageLink pageLink) {
		this.buttons = new ImageButton[this.btnCount];
		int i = 0;
		Link aLink = null;
		if (this.showFirst) {
			this.firstBtn.setWidth(btnBox.getWidth());
			this.firstBtn.setHeight(btnBox.getHeight());
			this.firstBtn.setDisabled(pageBean.isFirst());
			buttons[i] = this.firstBtn;
			aLink = new Link(pageLink.getFristLink());
			this.firstBtn.setLink(aLink);
			i++;
		}

		if (this.showPrior) {
			priorBtn.setWidth(btnBox.getWidth());
			priorBtn.setHeight(btnBox.getHeight());
			priorBtn.setDisabled(pageBean.isFirst());
			aLink = new Link(pageLink.getPrivLink(), KeyEvent.getKey(
					KeyEvent.KEY_PAGE_UP, pageContext));
			this.priorBtn.setLink(aLink);
			buttons[i] = this.priorBtn;
			i++;
		}
		if (this.showNext) {
			nextBtn.setWidth(btnBox.getWidth());
			nextBtn.setHeight(btnBox.getHeight());
			nextBtn.setDisabled(pageBean.isLast());
			aLink = new Link(pageLink.getNextLink(), KeyEvent.getKey(
					KeyEvent.KEY_PAGE_DOWN, pageContext));
			this.nextBtn.setLink(aLink);
			buttons[i] = this.nextBtn;
			i++;
		}
		if (this.showLast) {
			lastBtn.setWidth(btnBox.getWidth());
			lastBtn.setHeight(btnBox.getHeight());
			lastBtn.setDisabled(pageBean.isLast());
			aLink = new Link(pageLink.getLastLink());
			this.lastBtn.setLink(aLink);
			buttons[i] = this.lastBtn;
			i++;
		}
	}

	public void abc() {

	}

	protected void moveBtnBox() {
		if (this.isVertical()) {
			btnBox.setTop(space + btnBox.getTop() + this.btnBox.getHeight());
		} else {
			btnBox.setLeft(space + btnBox.getLeft() + this.btnBox.getWidth());
		}
	}

	/**
	 * 注册一个导航按钮
	 * 
	 * @param type
	 * @param imageBtn
	 */
	public void registeButton(int type, ImageButton imageBtn) {
		hasImageButton = true;
		this.btnCount++;
		switch (type) {
		case FIRST_BUTTON_TYPE:
			this.showFirst = true;
			this.firstBtn = imageBtn;
			break;
		case FRIOI_BUTTON_TYPE:
			this.showPrior = true;
			this.priorBtn = imageBtn;
			break;

		case NEXT_BUTTON_TYPE:
			this.showNext = true;
			this.nextBtn = imageBtn;
			break;

		case LAST_BUTTON_TYPE:
			this.showLast = true;
			this.lastBtn = imageBtn;
			break;
		}
	}

	@Override
	public void release() {
		this.btnBox = null;
		this.btnCount = 0;
		this.buttons = null;
		this.buttonStyle = null;
		this.vertical = true;
		this.showFirst = false;
		this.showInfo =false;
		this.showLast = false;
		this.showNext = true;
		this.showPrior = true;
		this.nextBtn = null;
		this.firstBtn = null;
		this.priorBtn = null;
		this.lastBtn = null;
		this.hasImageButton = false;
		super.release();
	}

	public void setPageBean(Object pageBean) throws JspException {
		if (pageBean instanceof PageBean) {
			this.pageBean = (PageBean) pageBean;
		} else {
			throw new JspException("pageBean not instance of PageBean.class");
		}
	}

	public String getButtonStyle() {
		return buttonStyle;
	}

	public void setButtonStyle(String buttonStyle) {
		this.buttonStyle = buttonStyle;
	}

	public boolean isShowFirst() {
		return showFirst;
	}

	public void setShowFirst(boolean showFirst) {
		this.showFirst = showFirst;
	}

	public boolean isShowPrior() {
		return showPrior;
	}

	public void setShowPrior(boolean showPrior) {
		this.showPrior = showPrior;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	public boolean isShowLast() {
		return showLast;
	}

	public void setShowLast(boolean showNext) {
		this.showLast = showNext;
	}

	public boolean isShowInfo() {
		return showInfo;
	}

	public void setShowInfo(boolean showInfo) {
		this.showInfo = showInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isVertical() {
		return vertical;
	}

	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public ImageButton getNextBtn() {
		return nextBtn;
	}

	public void setNextBtn(ImageButton nextBtn) {
		this.nextBtn = nextBtn;
	}

	public ImageButton getPriorBtn() {
		return priorBtn;
	}

	public void setPriorBtn(ImageButton priorBtn) {
		this.priorBtn = priorBtn;
	}

	public ImageButton getLastBtn() {
		return lastBtn;
	}

	public void setLastBtn(ImageButton lastBtn) {
		this.lastBtn = lastBtn;
	}

	public ImageButton getFirstBtn() {
		return firstBtn;
	}

	public void setFirstBtn(ImageButton firstBtn) {
		this.firstBtn = firstBtn;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}

	public boolean isKeyEnable() {
		return keyEnable;
	}

	public void setKeyEnable(boolean keyEnable) {
		this.keyEnable = keyEnable;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}
