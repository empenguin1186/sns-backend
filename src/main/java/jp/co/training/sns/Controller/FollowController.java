package jp.co.training.sns.Controller;

import jp.co.training.sns.Entity.Follow;
import jp.co.training.sns.Mapper.FollowMapper;
import jp.co.training.sns.Response.TweetPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="follow", produces=MediaType.APPLICATION_JSON_VALUE)
public class FollowController {

	@Autowired
	private FollowMapper followMapper;

	@RequestMapping(value="post", method = RequestMethod.POST)
	public TweetPost postFollow(@RequestBody Follow follow){
		boolean isSuccess = followMapper.register(follow);
		int statusCode = isSuccess ? 200 : 400;
		String message = isSuccess ? "Success" : "Failure";
		return new TweetPost(statusCode, message);
	}

	@RequestMapping(value="{userId}/follow", method = RequestMethod.GET)
	public int getFollow(@PathVariable String userId){
		int count = followMapper.countFollow(userId);
		return count;
	}
}
