package rdl.typ.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import rdl.typ.comm.CommonCode;

@ControllerAdvice
public class ExceptionController {
	
	  @ExceptionHandler(TokenInvalidException.class)
	    public @ResponseBody Map<String,Object> handleBusinessException(TokenInvalidException ex) {
	        Map<String,Object> result = new HashMap<String,Object>();
	        result.put(CommonCode.STATUS, CommonCode.FAIL);
	        result.put(CommonCode.MESSAGE, ex.getMessage());
	        return result;
	    }
	  @ExceptionHandler(LoginFailException.class)
	    public @ResponseBody Map<String,Object> handleBusinessException(LoginFailException ex) {
	        Map<String,Object> result = new HashMap<String,Object>();
	        result.put(CommonCode.STATUS, CommonCode.FAIL);
	        result.put(CommonCode.MESSAGE, ex.getMessage());
	        return result;
	    }
}
