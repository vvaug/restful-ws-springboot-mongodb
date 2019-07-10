package com.vvaugusto.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private Date date;
	private AuthorDTO author;
	
	public CommentDTO(String text, Date date, AuthorDTO author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}
	public CommentDTO() {
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public AuthorDTO getAuthor() {
		return author;
	}
	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDTO other = (CommentDTO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
}
