package com.api.open.read.api.generic.model;

import com.api.open.read.api.generic.enums.StatusEnum;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
public class CrudApiResponse<T> {

    @JsonProperty("status")
    private StatusEnum status;

    @JsonProperty("time_stamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    @JsonProperty("message")
    private String message;

    @JsonProperty("debug_message")
    private String debugMessage;

    @JsonProperty("error_list")
    private List<CrudApiResponseValidationError> errorList;

    @JsonProperty("object")
    private T object;

    private Page<T> pageData;

    @JsonProperty("objectList")
    private List<T> objectList;

    private CrudApiResponse() {
        timestamp = LocalDateTime.now();
    }

    public CrudApiResponse(StatusEnum status) {
        this();
        this.status = status;
    }

    public CrudApiResponse<T> addMessage(String message) {
        this.message = message;
        return this;
    }

    public CrudApiResponse<T> addDebugMessage(Throwable debugMessage) {
        this.debugMessage = debugMessage.getLocalizedMessage();
        return this;
    }

}
