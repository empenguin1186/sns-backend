package jp.co.training.sns.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TweetPost implements Serializable {

	@JsonProperty("status_code")
	private int statusCode;

	private String message;
}
