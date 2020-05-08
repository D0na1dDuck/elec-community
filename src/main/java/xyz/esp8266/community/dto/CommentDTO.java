package xyz.esp8266.community.dto;

import lombok.Data;
import xyz.esp8266.community.model.User;

@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private String content;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private User user;
    private Integer commentCount;
}
