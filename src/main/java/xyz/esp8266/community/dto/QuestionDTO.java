package xyz.esp8266.community.dto;

import lombok.Data;
import xyz.esp8266.community.model.User;

/**
 * @author Liangjiakun
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
