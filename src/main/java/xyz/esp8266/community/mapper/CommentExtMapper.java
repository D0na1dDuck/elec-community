package xyz.esp8266.community.mapper;

import xyz.esp8266.community.model.Comment;
import xyz.esp8266.community.model.Question;

public interface CommentExtMapper {
    int incCommentCount(Comment record);
}
