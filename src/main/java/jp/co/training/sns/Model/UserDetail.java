package jp.co.training.sns.Model;

import jp.co.training.sns.Entity.Tweet;
import jp.co.training.sns.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDetail {

	private User user;

	private List<Tweet> tweets;
}
