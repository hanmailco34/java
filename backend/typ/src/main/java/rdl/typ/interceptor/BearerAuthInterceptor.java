package rdl.typ.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import rdl.typ.exception.TokenInvalidException;
import rdl.typ.jwt.AuthorizationExtractor;
import rdl.typ.jwt.JwtTokenProvider;

@Component
public class BearerAuthInterceptor implements HandlerInterceptor {
	private AuthorizationExtractor authExtractor;
	private JwtTokenProvider jwtTokenProvider;

	public BearerAuthInterceptor(AuthorizationExtractor authExtractor, JwtTokenProvider jwtTokenProvider) {
		this.authExtractor = authExtractor;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println(">>> interceptor.preHandle 호출");
		String token = authExtractor.extract(request, "Bearer");
		 
		if (token.isEmpty()) {
			throw new TokenInvalidException("No Token. need Login");
		}

		if (!jwtTokenProvider.validateToken(token)) {
			throw new TokenInvalidException("invalid Token");
		}
		String userId = jwtTokenProvider.getSubject(token);
		request.setAttribute("userId", userId);
		return true;
	}
}
