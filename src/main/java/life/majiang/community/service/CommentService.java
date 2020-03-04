package life.majiang.community.service;

import life.majiang.community.dto.CommentDto;
import life.majiang.community.enums.CommentTypeEnum;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import life.majiang.community.mapper.CommentMapper;
import life.majiang.community.mapper.QuestionExtMapper;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.model.Comment;
import life.majiang.community.model.Question;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * All rights reserved.
 * <p>
 * Author:
 * Version: 1.0
 * Created Time:
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         						Create file
 * =========================================================================
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;

    private static final Log logger = LogFactory.getLog(CommentService.class);

    /**
     * 回复评论
     * @param commentDto
     * @param request
     */
    @Transactional(rollbackFor = Exception.class)
    public void insert(CommentDto commentDto, HttpServletRequest request) {
        if (commentDto.getParentId() == null || commentDto.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if (commentDto.getType() == null || !CommentTypeEnum.isExist(commentDto.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_ERROR);
        }

        if (commentDto.getType().equals(CommentTypeEnum.COMMENT.getType())) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(commentDto.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
        } else {
            //回答问题
            Question question = questionMapper.selectByPrimaryKey(commentDto.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
            logger.info("OK");
        }

        Comment dbComment = new Comment();
        BeanUtils.copyProperties(commentDto, dbComment);
        dbComment.setGmtCreate(System.currentTimeMillis());
        dbComment.setGmtModified(dbComment.getGmtCreate());
        dbComment.setCommentator(0L);
        dbComment.setLikeCount(0L);
        commentMapper.insert(dbComment);

    }

}
