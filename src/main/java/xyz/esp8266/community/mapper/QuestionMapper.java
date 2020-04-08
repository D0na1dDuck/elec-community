package xyz.esp8266.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.esp8266.community.model.Question;

@Repository
@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,creator,tag,gmt_create,gmt_modified) values (#{title},#{description},#{creator},#{tag},#{gmtCreate},#{gmtModified})")
    void create(Question question);
}
