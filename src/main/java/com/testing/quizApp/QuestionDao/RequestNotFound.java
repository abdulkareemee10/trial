package com.testing.quizApp.QuestionDao;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RequestNotFound  extends  RuntimeException{
    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public RequestNotFound(String message, String resourceName, String fieldName, Object fieldValue) {
        super((String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue)));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public RequestNotFound(String question, String id, long id1) {
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}


