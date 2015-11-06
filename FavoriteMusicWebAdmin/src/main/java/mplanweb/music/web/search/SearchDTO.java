package mplanweb.music.web.search;

import java.util.List;

public class SearchDTO {
	private String artist;
	private String title;
	private String album;
	private String year;
	private String img;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public SearchDTO() {

	}

	public SearchDTO(String artist, String title, String album, String year,
			String img) {
		super();
		this.artist = artist;
		this.title = title;
		this.album = album;
		this.year = year;
		this.img = img;

	}
}
