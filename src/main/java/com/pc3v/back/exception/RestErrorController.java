package com.pc3v.back.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.pc3v.back.exception.ForumException.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class RestErrorController extends BasicErrorController {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(RestErrorController.class);

    public RestErrorController(
        ErrorAttributes errorAttributes) {
        super(errorAttributes, new ErrorProperties());
    }
    ErrorAttributeOptions options = ErrorAttributeOptions
            .defaults()
            .including(ErrorAttributeOptions.Include.MESSAGE)
            ;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ForumApiExceptionResponse> jsonError(HttpServletRequest request) {
        LOGGER.error("parse JSON error [code: {}, attributes: {}]",
            this.getStatus(request),
            this.getErrorAttributes(request, options));

        HttpStatus status = this.getStatus(request);
        ForumApiExceptionResponse exceptionResponse = new ForumApiExceptionResponse();
        exceptionResponse.setStatus(status.toString());
        exceptionResponse.setStatusCode(status.value());
        exceptionResponse
            .setMessage((String)
                this.getErrorAttributes(request, options).get("message"));
        exceptionResponse
            .setPath((String)
                this.getErrorAttributes(request, options).get("path"));
        exceptionResponse
            .setTimestamp((Date)
                this.getErrorAttributes(request, options).get("timestamp"));
        if (status.series() == Series.CLIENT_ERROR) {
            exceptionResponse.setErrorCode(ErrorCode.CLIENT_ERROR);
        } else if (status.series() == Series.SERVER_ERROR) {
            exceptionResponse.setErrorCode(ErrorCode.INTERNAL_ERROR);
        }

        return new ResponseEntity<>(exceptionResponse, status);
    }
}
