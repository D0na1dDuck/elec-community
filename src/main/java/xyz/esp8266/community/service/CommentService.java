package xyz.esp8266.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.esp8266.community.enums.CommentTypeEnum;
import xyz.esp8266.community.exception.CustomizeErrorCode;
import xyz.esp8266.community.exception.CustomizeException;
import xyz.esp8266.community.mapper.CommentMapper;
import xyz.esp8266.community.mapper.QuestionExtMapper;
import xyz.esp8266.community.mapper.QuestionMapper;
import xyz.esp8266.community.model.Comment;
import xyz.esp8266.community.model.Question;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;
    public void insert(Comment comment) {
        // 在回复过程中遭遇问题同时被删除出现的情况
        if(comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if(comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_NOT_FOUND);
        }
        if(comment.getType() == CommentTypeEnum.COMMENT.getType()){
            // 回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getId());
            if(dbComment == null){
                // 评论不存在
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
        }else{
            // 回复问题
            Question question =  questionMapper.selectByPrimaryKey(comment.getId());
            if(question == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            questionExtMapper.incCommentCount(question);
        }
    }
}
