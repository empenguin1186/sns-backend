package jp.co.training.sns.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserCredential {

    private String userName;

    private String encodedPassword;

    private Set<String> roles;

    private Set<String> aithorities;
}
