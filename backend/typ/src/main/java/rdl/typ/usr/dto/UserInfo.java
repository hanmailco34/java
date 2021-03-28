package rdl.typ.usr.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "User_Info")
public class UserInfo {
		@Column(name = "user_num")
		private Long userNum;
		@Id
		@Column(name = "user_id")
		private String userId;
		@Column(name = "user_password")
		private String userPassword;
		@Column(name = "user_email")
		private String userEmail;
		public Long getUserNum() {
			return userNum;
		}
		public void setUserNum(Long userNum) {
			this.userNum = userNum;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserPassword() { 
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		@Override
		public String toString() {
			return "UserInfo [userNum=" + userNum + ", userId=" + userId + ", userPassword=" + userPassword + ", userEmail="
					+ userEmail + "]";
		}
}
