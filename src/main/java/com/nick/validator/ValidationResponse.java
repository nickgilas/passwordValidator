package com.nick.validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlAccessorType( XmlAccessType.FIELD )
@XmlRootElement( name = "validationResponse" )
public class ValidationResponse implements Serializable {

    private static final long serialVersionUID = -2915263712584012252L;
    
    @XmlElement(name = "validationMessage", type = String.class)
    private List<String> validationMessages = new ArrayList<String>();
    
    private boolean isValid;

    public List<String> getValidationMessages() {

        return validationMessages;
    }
    
    public void addValidationMessage(String message) {
    	
    	this.validationMessages.add(message);
    	
    }
    

    public void setValidationMessage(List<String> validationMessages) {

        this.validationMessages = validationMessages;
    }

    public boolean isValid() {

        return isValid;
    }

    public void setValid(boolean isValid) {

        this.isValid = isValid;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
