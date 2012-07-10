package chances.epg.taglib.iptv;

public class GridIndex  implements java.io.Serializable{


	private static final long serialVersionUID = 1L;
	
	private int index;
	private int colIndex;
	private int rowIndex;
	private int length;
	private int top;
	private int left;
	private int rows;
	private int cols;
	private boolean varNull;
	
	public GridIndex(int rows, int cols,int length){
		this.rows = rows;
		this.cols = cols;
		this.length = length;
	}
	
	public void moveNext(){
		if(colIndex < cols-1){
			colIndex ++;
		}else{
			colIndex =0;
			rowIndex++;
		}
		index++;
	}

	public boolean hasElement(){
		return index<length;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getColIndex() {
		return colIndex;
	}
	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public boolean isVarNull() {
		return varNull;
	}

	public void setVarNull(boolean varNull) {
		this.varNull = varNull;
	}
}
