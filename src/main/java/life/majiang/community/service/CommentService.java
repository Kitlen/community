package life.majiang.community.service;

import life.majiang.community.dto.CommentDto;
import life.majiang.community.enums.CommentTypeEnum;
import life.majiang.community.exception.CustomizeErrorCode;
import life.majiang.community.exception.CustomizeException;
import life.majiang.community.mapper.CommentMapper;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.model.Comment;
import life.majiang.community.model.User;
import life.majiang.community.result.ResultBody;
import life.majiang.community.utils.ResultUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public void insert(CommentDto commentDto, HttpServletRequest request) {
        if (commentDto.getParentId() == null || commentDto.getParentId() == 0 ) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if(commentDto.getType() == null || !CommentTypeEnum.isExist(commentDto.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_ERROR);
        }

        if (commentDto.getType().equals(CommentTypeEnum.COMMENT.getType())) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(commentDto.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
//            Comment dbComment = new Comment();
            BeanUtils.copyProperties(commentDto, dbComment);
            dbComment.setGmtCreate(System.currentTimeMillis());
            dbComment.setGmtModified(dbComment.getGmtCreate());
            dbComment.setCommentator(0);
            dbComment.setLikeCount(0L);
            commentMapper.insert(dbComment);

        } else {
            //回答问题
            questionMapper.selectByPrimaryKey(commentDto.getParentId());



        }

//        User user = (User) request.getSession().getAttribute("user");
        /*if (user == null) {
            return ResultUtils.error():
        }*/
        Comment comment = new Comment();
        BeanUtils.copyProperties(comment, comment);
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setCommentator(0);
        comment.setLikeCount(0L);
        commentMapper.insert(comment);
    }

}
