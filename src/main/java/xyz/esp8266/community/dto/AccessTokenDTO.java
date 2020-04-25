package xyz.esp8266.community.dto;

import lombok.Data;

/**
 * @author Liangjiakun
 */

@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
