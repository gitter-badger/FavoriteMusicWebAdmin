package mplanweb.music.web.contents;

public class Ssearch {
	private int start; // ?˜?´ì§? ?‹œ?‘ê°?
	private int limit; // ?˜?´ì§? ì¹´ìš´?Š¸
	private int page;
	private String searchColumn; // ê²??ƒ‰?‹œ ?‚¬?š©?˜?Š” ì»¬ëŸ¼ëª?
	private String searchText; // ê²??ƒ‰?–´
	private String startDate; // ?‹œ?‘?¼
	private String endDate; // ì¢…ë£Œ?¼

	public int getStart() {

		return start;
	}

	public void setStart(int start) {

		this.start = start;
	}

	public int getLimit() {

		return limit;
	}

	public void setLimit(int limit) {

		this.limit = limit;
	}

	public int getPage() {

		return page;
	}

	public void setPage(int page) {

		this.page = page;
	}

	public String getSearchColumn() {

		return searchColumn;
	}

	public void setSearchColumn(String searchColumn) {

		this.searchColumn = searchColumn;
	}

	public String getSearchText() {

		return searchText;
	}

	public void setSearchText(String searchText) {

		this.searchText = searchText;
	}

	public String getStartDate() {

		return startDate;
	}

	public void setStartDate(String startDate) {

		this.startDate = startDate;
	}

	public String getEndDate() {

		return endDate;
	}

	public void setEndDate(String endDate) {

		this.endDate = endDate;
	}
}
