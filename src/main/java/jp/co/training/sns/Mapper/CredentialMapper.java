package jp.co.training.sns.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper
@Component
public interface CredentialMapper {

    /* Role取得 */
    @Select("SELECT role FROM role WHERE user_name = #{userName}")
    Set<String> getRoles(String userName);

    /* Authority取得 */
    @Select("SELECT authority FROM authority WHERE user_name = #{userName}")
    Set<String> getAuthorites(String userName);

}
