package jp.co.training.sns.Mapper;

import jp.co.training.sns.Entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
	
	/* ユーザ情報取得 */
	@Select("SELECT user_id AS userId, user_name AS userName, encoded_password AS encodedPassword," +
		" email AS email, comment AS comment, place AS place, birth_day AS birthDay," +
		" img_url AS imgUrl FROM user WHERE user_id = #{userId}")
	User findOne(String userId);
	
	/* ユーザ登録 */
	@Insert("INSERT INTO user (user_id, user_name, encoded_password, email, comment, place, birth_day, img_url)" +
		" VALUES (#{userId}, #{userName}, #{email}, #{comment}, #{place}, #{birthDay}, #{imgUrl})")
	boolean post(User user);
	
	/* ユーザ情報更新 */
	@Update("UPDATE user SET user_name = #{userName}, encoded_password = #{encodedPassword}, email = #{email}," +
			" comment = #{comment}, place = #{place}, birth_day = #{birthDay}, img_url = #{imgUrl} WHERE user_id = #{userId}")
	boolean update(User user);

	/* ユーザ消去 */
	@Delete("DELETE FROM user WHERE user_id = #{userId}")
	boolean delete(String userId);
	
	@Select("SELECT user_id AS userId, encoded_password AS encodedPassword FROM user WHERE user_id = #{userId}")
	User getPassword(String userId);
}
