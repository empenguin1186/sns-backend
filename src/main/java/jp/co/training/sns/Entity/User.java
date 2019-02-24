package jp.co.training.sns.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class User implements Serializable {
	
	private String userId;
	
	private String userName;

	private String encodedPassword;
	
	private String comment;
	
	private String place;
	
	private long birthDay;
	
	private String imgUrl;
	
}
