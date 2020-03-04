package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import life.majiang.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    /**
     * 增加阅读数
     * @param id 问题id
     */
    void incView(Question record);

    /**
     * 增加回复数
     * @param id 问题id
     */
    void incCommentCount(Question record);
}