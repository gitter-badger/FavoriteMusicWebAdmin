package mplanweb.music.web.contents;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Jsontotal implements Serializable {

	private Object data;
	private List<?> items; // ?��?��?���??�� 출력?��?�� ?��코드 리스?��
	private String msg; // 리턴 메시�?
	private Object success;
	private int total;

	public Object getData() {

		return data;
	}

	public void setData(Object data) {

		this.data = data;
	}

	public List<?> getItems() {

		return items;
	}

	public void setItems(List<?> items) {

		this.items = items;
	}

	public String getMsg() {

		return msg;
	}

	public void setMsg(String msg) {

		this.msg = msg;
	}

	public Object getSuccess() {

		return success;
	}

	public void setSuccess(Object success) {

		this.success = success;
	}

	public int getTotal() {

		return total;
	}

	public void setTotal(int total) {

		this.total = total;
	}

}
