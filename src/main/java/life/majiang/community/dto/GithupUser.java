package life.majiang.community.dto;

import lombok.Data;

/**
 * qingcong All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2019-12-31
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2019-12-31		kitlen			Create file
 * =========================================================================
 */
@Data
public class GithupUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
