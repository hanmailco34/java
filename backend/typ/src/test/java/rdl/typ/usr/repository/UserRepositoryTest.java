package rdl.typ.usr.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest{

	@Autowired
	public UserRepository userRepo;
	
	@Test
	public void 로그인테스트() {
		String userId = "drrg";
		String userPassword = "123123#l2";
		
	}
	
}

