package rdl.typ.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
	  @ExceptionHandler(TokenInvalidException.class)
	    public @ResponseBody Map<String,Object> handleBusinessException(TokenInvalidException ex) {
	        Map<String,Object> result = new HashMap<String,Object>();
	        result.put("status", "OOPS");
	        result.put("msg", ex.getMessage());
	        return result;
	    }
}
