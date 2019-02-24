package jp.co.training.sns.Mapper;

import jp.co.training.sns.Entity.Follow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FollowMapper {

    /* フォロー処理 */
    @Insert("INSERT INTO follow (follow_id, follower_id, block_flag, mute_flag)" +
            " VALUES (#{followId}, #{followerId}, #{blockFlag}, #{muteFlag})")
    boolean register(Follow follow);

    /* ブロック＆ミュート更新処理 */
    @Update("UPDATE follow SET block_flag = #{blockFlag}, mute_flag = #{muteFlag}" +
            " WHERE follow_id = #{followId} AND follower_id = #{followerId}")
    boolean update(Follow follow);

    /* フォロー解除処理 */
    @Delete("DELETE FROM follow WHERE follow_id = #{followId} AND follower_id = #{followerId}")
    boolean delete(Follow follow);

    /* フォロー数取得 */
    @Select("SELECT COUNT(*) FROM follow WHERE follow_id = #{followId}")
    int countFollow(String followId);

    /* フォロワー数取得 */
    @Select("SELECT COUNT(*) FROM follow WHERE follower_id = #{followerId}")
    int countFollower(String followerId);
}

