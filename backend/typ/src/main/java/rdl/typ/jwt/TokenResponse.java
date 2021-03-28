package rdl.typ.jwt;


public class TokenResponse {
	private String accessToken;
	private String tokenType;
	
	public TokenResponse(String accessToken, String tokenType) {
		this.accessToken = accessToken;
		this.tokenType = tokenType;
	}
	@Override
	public String toString() {
		return "TokenResponse [accessToken=" + accessToken + ", tokenType=" + tokenType + "]";
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	
}
