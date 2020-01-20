package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2020-1-13
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-1-13		kitlen			Create file
 * =========================================================================
 */
@Repository
@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset,@Param("size") Integer size);


    @Select("select count(1) from question")
    Integer count();

}
