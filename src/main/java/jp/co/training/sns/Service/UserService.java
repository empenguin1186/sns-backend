package jp.co.training.sns.Service;

import jp.co.training.sns.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
//	public void create(User user) {
//		userMapper.register(user);
//	}
}
