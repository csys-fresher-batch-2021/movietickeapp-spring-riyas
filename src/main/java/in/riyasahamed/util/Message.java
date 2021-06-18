package in.riyasahamed.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(value = Include.NON_NULL)
@Data
public class Message {
	private String errorMessage;
	private String infoMessage;
	private Map<String, String> errors = new LinkedHashMap<>();
}
