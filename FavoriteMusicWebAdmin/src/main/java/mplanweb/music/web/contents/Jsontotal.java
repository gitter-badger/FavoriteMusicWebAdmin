package mplanweb.music.web.contents;

import java.io.Serializable;
import java.util.List;



@SuppressWarnings("serial")
public class Jsontotal implements Serializable{
	
	private Object data;
	private List<?> items; // ?��?��?���??�� 출력?��?�� ?��코드 리스?��
	private String msg; // 리턴 메시�?
	private Object success;
	private int total;
	public Object getData() {
		System.out.println("getData  : " + data);
		return data;
	}
	public void setData(Object data) {
		System.out.println("setData  : " + data);
		this.data = data;
	}
	public List<?> getItems() {
		System.out.println("getItems  : " + items);
		return items;
	}
	public void setItems(List<?> items) {
		System.out.println("setItems  : " + items);
		this.items = items;
	}
	public String getMsg() {
		System.out.println("getMsg  : " + msg);
		return msg;
	}
	public void setMsg(String msg) {
		System.out.println("setMsg  : " + msg);
		this.msg = msg;
	}
	public Object getSuccess() {
		System.out.println("getSuccess  : " + success);
		return success;
	}
	public void setSuccess(Object success) {
		System.out.println("setSuccess  : " + success);
		this.success = success;
	}
	public int getTotal() {
		System.out.println("getTotal  : " + total);
		return total;
	}
	
	public void setTotal(int total) {
		System.out.println("setTotal  : " + total);
		this.total = total;
	}
	
	

}
