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
		System.out.println("getStart : " + start);
		return start;
	}

	public void setStart(int start) {
		System.out.println("setStart : " + start);
		this.start = start;
	}

	public int getLimit() {
		System.out.println("getLimit : " + limit);
		return limit;
	}

	public void setLimit(int limit) {
		System.out.println("setLimit : " + limit);
		this.limit = limit;
	}

	public int getPage() {
		System.out.println("getPage : " + page);
		return page;
	}

	public void setPage(int page) {
		System.out.println("setPage : " + page);
		this.page = page;
	}

	public String getSearchColumn() {
		System.out.println("getSearchColumn : " + searchColumn);
		return searchColumn;
	}

	public void setSearchColumn(String searchColumn) {
		System.out.println("setSearchColumn : " + searchColumn);
		this.searchColumn = searchColumn;
	}

	public String getSearchText() {
		System.out.println("getSearchText : " + searchText);
		return searchText;
	}

	public void setSearchText(String searchText) {
		System.out.println("setSearchText : " + searchText);
		this.searchText = searchText;
	}

	public String getStartDate() {
		System.out.println("getStartDate : " + startDate);
		return startDate;
	}

	public void setStartDate(String startDate) {
		System.out.println("setStartDate : " + startDate);
		this.startDate = startDate;
	}

	public String getEndDate() {
		System.out.println("getEndDate : " + endDate);
		return endDate;
	}

	public void setEndDate(String endDate) {
		System.out.println("setEndDate : " + endDate);
		this.endDate = endDate;
	}
}
