package gmailmonitor.beans;

public class ResponseException extends Exception {
	 private String responseMessage;
	 private String humanReadableResponseMessage;
	 private String inValidNumber;
	 
	public String getInValidNumber() {
		return inValidNumber;
	}
	public void setInValidNumber(String inValidNumber) {
		this.inValidNumber = inValidNumber;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getHumanReadableResponseMessage() {
		return humanReadableResponseMessage;
	}
	public void setHumanReadableResponseMessage(String humanReadableResponseMessage) {
		this.humanReadableResponseMessage = humanReadableResponseMessage;
	}
	    

}
