package com.ailton.workshopmongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class BusinessException extends ResponseStatusException {

    private final ErrorsEnum error;
    private final Object[] args;

    public BusinessException(HttpStatus status, ErrorsEnum error, Object... args) {
        super(status);
        this.error = error;
        this.args = args;
        log.info("BusinessException {}: args {} ", error, formatArgumento(args));
    }

    public BusinessException(HttpStatus status, ErrorsEnum error, String reason, Object... args) {
        super(status, reason);
        this.error = error;
        this.args = args;
        log.info("BusinessException Reason:{} ErrorCode:{}: args {} ", reason, error, formatArgumento(args) );
    }

	private String formatArgumento(Object... args) {
		String strArgs= "";
        if(args != null ) {
        	if(args.length > 0 ) {
        		for (int i = 0; i < args.length; i++) {
        			for (int j = 0; j < args.length; j++) {
        				strArgs += args[j] + ", ";
					}
				}
        	}
        }
        return strArgs;
	}

    public BusinessException(HttpStatus status, ErrorsEnum error, String reason, Throwable cause, Object... args) {
        super(status, reason, cause);
        this.error = error;
        this.args = args;
    }
}
