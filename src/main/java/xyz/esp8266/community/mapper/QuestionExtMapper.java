package xyz.esp8266.community.mapper;

import xyz.esp8266.community.model.Question;
import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);
}
