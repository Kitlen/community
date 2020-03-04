package life.majiang.community.dto;

import lombok.Data;

/**
 * All rights reserved.
 * <p>
 * Author:
 * Version: 1.0
 * Created Time:
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         						Create file
 * =========================================================================
 */
@Data
public class CommentDto {
    private Long parentId;
    private String content;
    private Integer type;
}
