package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.servlet.http.Cookie;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2020-01-10
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-01-10		kitlen			Create file
 * =========================================================================
 */
@Repository
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,avatar_url,account_id,token,gmt_create,gmt_modified) values (#{name},#{avatarUrl},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id=#{creator}")
    User findById(@Param("creator") Long creator);

    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id=#{id}")
    void update(User dbUser);
}
