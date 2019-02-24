package jp.co.training.sns.Mapper;

import jp.co.training.sns.Entity.Tweet;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TweetMapper {
	
	/* ツイート取得　*/
	@Select("SELECT tweet_id AS tweetId, content AS content," +
		" tweet_user AS tweetUser, attachment AS attachment," +
		" favorite AS favorite, retweet AS retweet, reply_to AS replyTo," +
		" time AS time FROM tweet WHERE tweet_id = #{tweetId}")
	Tweet findOne(int tweetId);
	
	/* ツイート作成　*/
	@Insert("INSERT INTO tweet (content, tweet_user, attachment, favorite, retweet, reply_to, time)" +
		" VALUES (#{content}, #{tweetUser}, #{attachment}, #{favorite}, #{retweet}, #{replyTo}, #{time})")
	boolean post(Tweet tweet);
	
	/* イイね＆RT数変更　*/
	@Update("UPDATE tweet SET favorite = #{favorite}, retweet = #{retweet} WHERE tweet_id = #{tweetId}")
	boolean update(Tweet tweet);
	
	/* ツイート消去　*/
	@Delete("DELETE FROM tweet WHERE tweet_id = #{tweetId}")
	boolean delete(int tweetId);
	
	/* フォローユーザのツイート取得 */
	@Select("SELECT tweet_id AS tweetId, content AS content," +
		" tweet_user AS tweetUser, attachment AS attachment," +
		" favorite AS favorite, retweet AS retweet," +
		" reply_to AS replyTo, time AS time FROM tweet" +
		" WHERE tweet_user = ANY (SELECT follower_id FROM follow" +
		" WHERE follow_id = #{userId})")
	List<Tweet> findByFollow(String userId);
	
	/* キーワード検索 */
	@Select("SELECT tweet_id AS tweetId, content AS content," +
		" tweet_user AS tweetUser, attachment AS attachment," +
		" favorite AS favorite, retweet AS retweet," +
		" reply_to AS replyTo, time AS time FROM tweet" +
		" WHERE content LIKE CONCAT('%', #{keyword}, '%')")
	List<Tweet> findByKeyword(String keyword);
	
	/* 自分のツイート取得 */
	@Select("SELECT tweet_id AS tweetId, content AS content," +
		" tweet_user AS tweetUser, attachment AS attachment," +
		" favorite AS favorite, retweet AS retweet," +
		" reply_to AS replyTo, time AS time FROM tweet" +
		" WHERE tweet_user = #{userId}")
	List<Tweet> findByMyself(String userId);
}
