package jp.co.training.sns.Controller;

import jp.co.training.sns.Entity.Tweet;
import jp.co.training.sns.Entity.UserCredential;
import jp.co.training.sns.Mapper.CredentialMapper;
import jp.co.training.sns.Mapper.TweetMapper;
import jp.co.training.sns.Mapper.UserMapper;
import jp.co.training.sns.Entity.User;
import jp.co.training.sns.Model.UserDetail;
import jp.co.training.sns.Response.TweetPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="user", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {
  
  @Autowired
  private UserMapper userMapper;
  
  @Autowired
  private TweetMapper tweetMapper;

  @Autowired
  private CredentialMapper credentialMapper;

  @RequestMapping(value="{userId}",method=RequestMethod.GET)
  public User getUser(@PathVariable String userId) {
  	/* 修正後のUserクラス = 現状のUser(profile)クラス + 自分のツイート一覧(List<Tweet>)にすべきか　*/
  	User user = userMapper.findOne(userId);
//  	if(Objects.isNull(user)) 該当ユーザが存在しない場合のレスポンスはどうするか？
    return user;
  }
	
  @RequestMapping(value="post",method=RequestMethod.POST)
  public TweetPost postUser(@RequestBody User user) {
  	/* 返り値のクラス名(TweetPost)は要検討 */
  	boolean isSuccess = userMapper.post(user);
  	int statusCode = isSuccess ? 200 : 400;
  	String message = isSuccess ? "Success" : "Failure";
	  return new TweetPost(statusCode, message);
  }
	
  @RequestMapping(value="{userId}/delete",method=RequestMethod.POST)
  public TweetPost deleteUser(@PathVariable String userId) {
  	boolean isSuccess = userMapper.delete(userId);
  	int statusCode = isSuccess ? 200 : 400;
  	String message = isSuccess ? "Success" : "Failure";
  	return new TweetPost(statusCode, message);
  }
	
  @RequestMapping(value="put",method=RequestMethod.POST)
  public TweetPost putUser(@RequestBody User user) {
  	/* SQLとHTTP METHODの記述を統一する */
  	boolean isSuccess = userMapper.update(user);
  	int statusCode = isSuccess ? 200 : 400;
  	String message = isSuccess ? "Success" : "Failure";
  	return new TweetPost(statusCode, message);
  }

  @RequestMapping(value="{userId}/details", method=RequestMethod.GET)
  public UserDetail getUserDetails(@PathVariable String userId) {
  	User user = userMapper.findOne(userId);
  	List<Tweet> tweets = tweetMapper.findByMyself(userId);
  	return new UserDetail(user, tweets);
  }

  @RequestMapping(value="{userId}/credentials", method = RequestMethod.GET, produces = "application/json")
  public UserCredential getCredential(@PathVariable String userId){
      User user = userMapper.findOne(userId);
      Set<String> roles = credentialMapper.getRoles(userId);
      Set<String> authorities = credentialMapper.getAuthorites(userId);

      /* Builderメソッドを使用すると正常なレスポンスが取得できない */
      UserCredential credential = new UserCredential();
      credential.setUserName(userId);
      credential.setEncodedPassword(user.getEncodedPassword());
      credential.setRoles(roles);
      credential.setAithorities(authorities);

//      UserCredential credential = UserCredential.builder()
//              .userName(userId)
//              .encodedPassword(user.getEncodedPassword())
//              .roles(roles)
//              .aithorities(authorities)
//              .build();
      return credential;
  }
}
