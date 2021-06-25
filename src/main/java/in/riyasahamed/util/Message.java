package in.riyasahamed.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@JsonInclude(value = Include.NON_NULL)
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Message {

	@NonNull
	private String errorMessage;
	private String infoMessage;
	private Map<String, String> errors = new LinkedHashMap<>();
}
