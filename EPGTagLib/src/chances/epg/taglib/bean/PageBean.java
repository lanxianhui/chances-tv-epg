package chances.epg.taglib.bean;

public class PageBean {
	int total;
	int step;
	int currentPageNo;
	int lastRecordNum;
	int lastPageNo;
	
	public PageBean(int total, int step, int currentPageNo){
		this.currentPageNo = currentPageNo;
		this.total = total;
		this.step = step ;
		cacl();
	}
	
	private void cacl(){
		this.lastPageNo = this.total /this.step;
		this.lastRecordNum = this.total % this.step;
		if(lastRecordNum ==0 ){
			this.lastRecordNum = this.step;
		}else{
			this.lastPageNo++;
		}
	}
	
	
	
	public int getPageCount(){
		return lastPageNo;
	}
	public int getOffset(){
		return (this.currentPageNo -1)* this.step;
	}
	
	public int getNextPageNo(){
		if(this.currentPageNo==this.lastPageNo){
			return this.lastPageNo;
		}else{
			return this.currentPageNo+1;
		}
	}
	
	public int getPrevPageNo(){
		if(this.currentPageNo==1){
			return this.currentPageNo;
		}else{
			return this.currentPageNo-1;
		}
	}
	
	public boolean hasNext(){
		return this.currentPageNo < this.lastPageNo;
	}
	
	public boolean hasPrev(){
		return this.currentPageNo> 1;
	}

	public boolean isFirst() {
		return this.currentPageNo ==1;
	}
	
	public boolean isLast() {
		return this.currentPageNo == this.getPageCount();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getLastRecordNum() {
		return lastRecordNum;
	}

	public void setLastRecordNum(int lastRecordNum) {
		this.lastRecordNum = lastRecordNum;
	}

	public int getLastPageNo() {
		return lastPageNo;
	}

	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}
}
