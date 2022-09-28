package com.ailton.workshopmongo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorsEnum {

	NAO_ENCONTROU("1"),
	EMAIL_CADASTRADO("2"),
	DELECAO_CONCLUIDA("3")

    ;

    private final String code;
    
}
