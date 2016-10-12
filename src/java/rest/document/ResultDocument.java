/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.document;

import java.io.Serializable;

/**
 *
 * @author macintoshhd
 */
public class ResultDocument implements Serializable{
    private long resultCode;
    private String resultMessage;
    private String resultValue;

    public ResultDocument(long resultCode, String resultMessage, String resultValue) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.resultValue = resultValue;
    }

    public ResultDocument() {
    }

    public ResultDocument(long resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }
    
    

    public long getResultCode() {
        return resultCode;
    }

    public void setResultCode(long resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
    
}
