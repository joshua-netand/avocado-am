package com.netand.avocado.commons.exception;


import com.netand.avocado.commons.model.ResultStatus;

public interface AvocadoExceptions {

	String getPrefix();

	ResultStatus getResultStatus();

	int getSerialNumber();

	String getFormat();

}
