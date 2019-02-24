package jp.co.training.sns.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Follow implements Serializable {
	
	private String followId;
	
	private String followerId;
	
	private boolean blockFlag;
	
	private boolean muteFlag;
}
