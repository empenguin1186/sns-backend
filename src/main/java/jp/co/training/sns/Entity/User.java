package jp.co.training.sns.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class User implements Serializable {
	
	private String userId;
	
	private String userName;

	private String encodedPassword;

	private String email;

	private String comment;
	
	private String place;
	
	private LocalDate birthDay;
	
	private String imgUrl;
	
}
