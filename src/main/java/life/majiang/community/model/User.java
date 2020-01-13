package life.majiang.community.model;

import lombok.Data;

/**
 * qingcong All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2020-01-10
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-01-10		kitlen			Create file
 * =========================================================================
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private String bio;
    private Long gmtCreate;
    private Long gmtModified;
}
