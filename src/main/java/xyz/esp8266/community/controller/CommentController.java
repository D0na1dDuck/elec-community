package xyz.esp8266.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.esp8266.community.dto.CommentDTO;
import xyz.esp8266.community.dto.ResultDTO;
import xyz.esp8266.community.exception.CustomizeErrorCode;
import xyz.esp8266.community.model.Comment;
import xyz.esp8266.community.model.User;
import xyz.esp8266.community.service.CommentService;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @ResponseBody
    @RequestMapping(value="/comment/", method=RequestMethod.POST)
    // 自动反序列化
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request
                       ){
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        // 枚举，这里需要校验父级是否存在
        comment.setType(commentDTO.getType());
        comment.setCommentator(user.getId());
        comment.setContent(commentDTO.getContent());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
