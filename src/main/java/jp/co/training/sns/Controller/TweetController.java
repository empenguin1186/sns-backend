package jp.co.training.sns.Controller;

import jp.co.training.sns.Mapper.TweetMapper;
import jp.co.training.sns.Entity.Tweet;
import jp.co.training.sns.Response.TweetPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tweets")
public class TweetController {
	
	@Autowired
	TweetMapper tweetMapper;
	
	@RequestMapping(path = "{tweetId}", method = RequestMethod.GET)
	public Tweet getByTweetId(@PathVariable int tweetId){
		return tweetMapper.findOne(tweetId);
	}
	
	@RequestMapping(path = "submit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TweetPost postTweet(@RequestBody Tweet tweet){
		boolean isSuccess = tweetMapper.post(tweet);
		int statusCode = isSuccess ? 200 : 400;
		String message = isSuccess ? "Success" : "Failure";
		TweetPost result = new TweetPost(statusCode, message);
		return result;
	}
	
	@RequestMapping(path = "{tweetId}/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TweetPost deleteTweet(@PathVariable int tweetId){
		boolean isDelete = tweetMapper.delete(tweetId);
		int statusCode = isDelete ? 200 : 400;
		String message = isDelete ? "Success" : "Failure";
		TweetPost result = new TweetPost(statusCode, message);
		return result;
	}
	
	@RequestMapping(path = "{userId}/myself", method = RequestMethod.GET)
	public List<Tweet> getMyTweets(@PathVariable String userId){
		return tweetMapper.findByMyself(userId);
	}

	@RequestMapping(path = "{userId}/follow", method = RequestMethod.GET)
	public List<Tweet> getTweetsByFollow(@PathVariable String userId){
		return tweetMapper.findByFollow(userId);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Tweet> getTweetsByKeyword(@RequestParam String keyword){
		return tweetMapper.findByKeyword(keyword);
	}
}
