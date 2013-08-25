package gmailmonitor.beans;

public class NetworkException extends Exception {

	 private String exceptionMessage;
	 private String humanReadableExceptionMessage;
	 
	 
	 public String getExceptionMessage() {
		return exceptionMessage;
	}
	 
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	public String getHumanReadableExceptionMessage() {
		return humanReadableExceptionMessage;
	}
	
	
	public void setHumanReadableExceptionMessage(
			String humanReadableExceptionMessage) {
		this.humanReadableExceptionMessage = humanReadableExceptionMessage;
	}
	
	
}
