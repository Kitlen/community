package life.majiang.community.model;

import lombok.Data;

@Data
public class Comment {
    private Long id;

    private Long parentId;

    private Integer type;

    private Integer commentator;

    private String content;

    private Long likeCount;

    private Long gmtCreate;

    private Long gmtModified;
}