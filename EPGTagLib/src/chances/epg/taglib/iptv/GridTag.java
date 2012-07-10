package chances.epg.taglib.iptv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.logging.Log;

import chances.epg.taglib.utils.TagLogFactory;

public class GridTag extends AbstractBoxTag {

	private static final long serialVersionUID = 1L;
	private static Log logger = TagLogFactory.getGridTagLog();
	private GridIndex gridIndex;
	private int cols;
	private int rows;
	private Object items;
	protected List<Object> varList;
	private String var;
	private Iterator<Object> iter;
	private Object varObj;
	private String indexVar;
	private int begin;
	private int end;

	public void init(){
		int len = cols * rows;
		gridIndex = new GridIndex(rows, cols, len);	
		if (varList.size() < len) {
			int j = len - varList.size();
			for (int i = 0; i < j; i++) {
				varList.add(null);
			}
		}
		this.iter = varList.iterator();
	}

	@Override
	public int doEndTag() throws JspException {
		logger.info("DoEnd");
		super.doEndTag();
		this.release();
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		super.doStartTag();
		init();
		this.varObj = this.iter.next();
		this.pageContext.setAttribute(this.var, varObj);
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {
		if (!iter.hasNext()) {
			return SKIP_BODY;
		}
		this.varObj = iter.next();
		this.gridIndex.moveNext();
		this.gridIndex.setVarNull(this.varObj == null);
		if (this.gridIndex.getIndex() < this.gridIndex.getLength()) {
			this.pageContext.setAttribute(this.var, this.varObj);
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}

	public void release() {
		super.release();
		this.gridIndex = null;
		this.items = null;
		this.cols = 0;
		this.rows = 0;
		if (varList != null) {
			this.varList.clear();
		}
		this.varList = null;
		this.indexVar = null;
		this.var = null;
	}

	public GridIndex getGridIndex() {
		return gridIndex;
	}

	public void setGridIndex(GridIndex gridIndex) {
		this.gridIndex = gridIndex;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Object getItems() {
		return items;
	}

	public void setItems(Object items) {
		this.items = items;
		varList = new ArrayList<Object>();
		if (this.items.getClass().isArray()) {
			Object[] arr = (Object[]) items;
			for (int i = 0; i < arr.length; i++) {
				this.varList.add(arr[i]);
			}
		} else if (items instanceof Collection) {
			varList.addAll((Collection) this.items);
		}

		
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getIndexVar() {
		return indexVar;
	}

	public void setIndexVar(String indexVar) {
		this.indexVar = indexVar;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
