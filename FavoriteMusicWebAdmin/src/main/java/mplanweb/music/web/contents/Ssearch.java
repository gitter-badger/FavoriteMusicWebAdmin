package mplanweb.music.web.contents;

public class Ssearch {
	private int start; // ?��?���? ?��?���?
	private int limit; // ?��?���? 카운?��
	private int page;
	private String searchColumn; // �??��?�� ?��?��?��?�� 컬럼�?
	private String searchText; // �??��?��
	private String startDate; // ?��?��?��
	private String endDate; // 종료?��

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
