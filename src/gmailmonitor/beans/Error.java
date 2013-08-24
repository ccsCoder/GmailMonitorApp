/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.beans;

/**
 *
 * @author CodeBeast
 */
public class Error {
    private String errorMessage;
    private String humanReadableErrorMessage;
    private Class exceptionClass;
    
    public Error(final String errorMessage,final Class exceptionClass) {
        
        this.errorMessage=errorMessage;
        this.exceptionClass=exceptionClass;
        this.humanReadableErrorMessage = errorMessage+" Class: "+this.exceptionClass;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getHumanReadableErrorMessage() {
        return humanReadableErrorMessage;
    }

    public void setHumanReadableErrorMessage(String humanReadableErrorMessage) {
        this.humanReadableErrorMessage = humanReadableErrorMessage;
    }
    
    
    
}
