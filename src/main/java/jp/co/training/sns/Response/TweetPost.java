package jp.co.training.sns.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TweetPost implements Serializable {
	private int statusCode;
	
	private String message;
}
