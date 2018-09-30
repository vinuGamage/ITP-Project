package POJO_MODEL.user_management;

import java.sql.Date;

import POJO_MODEL.employee_hr_payroll_management.converters.DateConverter;

public class Email {
	private int emailId;
	private String sender;
	private String receiver;
	private String subject;
	private String content;
	private Date sentDate = DateConverter.getCurrentSqlDate();
	
	public Email(int emailId, String sender, String receiver, String subject, String content, Date sentDate) {
		this.emailId = emailId;
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.content = content;
		this.sentDate = sentDate;
	}
	
	public Email(String sender, String receiver, String subject, String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.content = content;
	}
	
	public int getEmailId() {
		return emailId;
	}
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
}
