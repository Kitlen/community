package life.majiang.community.model;

import lombok.Data;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2020-1-13
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-1-13		kitlen			Create file
 * =========================================================================
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private String description;
}
