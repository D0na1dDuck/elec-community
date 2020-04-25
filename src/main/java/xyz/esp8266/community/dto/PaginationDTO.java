package xyz.esp8266.community.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liangjiakun
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;
    private Boolean showNext;
    private Boolean showFirstPage;
    private Boolean showEndPage;
    private Integer page;
    private List<Integer> pages;
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        pages = new ArrayList<>();
        final int SHOW_SCOPE = 3;
        totalPage = 0;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        this.page = page;

        pages.add(page);
        for (int i = 1; i <= SHOW_SCOPE; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        // 是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        // 是否展示下一页
        if (page.equals(totalPage)) {
            showNext = false;
        } else {
            showNext = true;
        }
        // 是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        // 是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
