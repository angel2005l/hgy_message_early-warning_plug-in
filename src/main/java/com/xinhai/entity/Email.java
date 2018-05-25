package com.xinhai.entity;

public class Email {
	private String eTitle;
	private String sendName;
	private String email;
	private String html;

	public Email() {
	}

	public String geteTitle() {
		return eTitle;
	}

	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	@Override
	public String toString() {
		return "Email [eTitle=" + eTitle + ", sendName=" + sendName + ", email=" + email + ", html=" + html + "]";
	}

}
