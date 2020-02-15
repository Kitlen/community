package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2020-02-14
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-02-14		kitlen			Create file
 * =========================================================================
 */
@Data
public class QuestionDTO {
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
    private User user;
}
