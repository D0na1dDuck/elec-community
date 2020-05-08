package xyz.esp8266.community.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.esp8266.community.dto.CommentCreateDTO;
import xyz.esp8266.community.dto.CommentDTO;
import xyz.esp8266.community.dto.ResultDTO;
import xyz.esp8266.community.enums.CommentTypeEnum;
import xyz.esp8266.community.exception.CustomizeErrorCode;
import xyz.esp8266.community.model.Comment;
import xyz.esp8266.community.model.User;
import xyz.esp8266.community.service.CommentService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @ResponseBody
    @RequestMapping(value="/comment", method=RequestMethod.POST)
    // 自动反序列化
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request
                       ){
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if(commentCreateDTO ==null || StringUtils.isBlank(commentCreateDTO.getContent())){
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setType(commentCreateDTO.getType());
        comment.setCommentator(user.getId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        commentService.insert(comment);
        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value="/comment/{id}", method=RequestMethod.GET)
    public ResultDTO comments(@PathVariable(name = "id") Long id){
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}
