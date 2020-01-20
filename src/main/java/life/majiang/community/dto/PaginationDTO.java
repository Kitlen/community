package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2020-1-14
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2020-1-14		kitlen			Create file
 * =========================================================================
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevios = true;
    private Boolean showFirstPage = true;
    private Boolean showNext = true;
    private Boolean showEndPage = true;
    private Integer totalPage = 0;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        totalPage = (int) Math.ceil(totalCount / size);

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);//+1
            }
        }


        //是否展示上一页
        if (page == 1) {
            showPrevios = false;
        }

        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        }

        //是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        }
    }
}
