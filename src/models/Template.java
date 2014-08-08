package models;

public class Template {

	public int id;
	public String text;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int code = 1;
		code = code * prime + new Integer(id).hashCode();
		code = code * prime + (text == null ? 0 : text.hashCode());
		return code;
	}
	
	@Override
	public boolean equals(Object o) {
		Template other = (Template) o;
		if(other == null)
			return false;
		return id == other.id && text.equals(other.text);
	}
}
