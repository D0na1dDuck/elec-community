package xyz.esp8266.community.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
