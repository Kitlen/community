package life.majiang.community.dto;

import lombok.Data;

/**
 * qingcong All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2019-12-24
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2019-12-24		kitlen			Create file
 * =========================================================================
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
