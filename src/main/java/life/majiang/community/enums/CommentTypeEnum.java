package life.majiang.community.enums;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2020-3-1
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-3-1		kitlen			Create file
 * =========================================================================
 */

public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (type.equals(commentTypeEnum.getType())) {
                return true;
            }
        }

        return false;
    }
}
