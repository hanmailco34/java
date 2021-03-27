package rdl.typ.usr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rdl.typ.usr.dto.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
	  @Query("select m from User_Info m where userId = :userId and userPassword = :userPassword")
	  Optional<UserInfo> findMember(@Param("userId") String userId, @Param("userPassword") String userPassword);
}
