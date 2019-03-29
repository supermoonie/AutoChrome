package com.github.supermoonie.type.page;

import lombok.Data;

import java.util.List;

/**
 * @author wangchao
 */
@Data
public class GetNavigationHistoryResult {

    private Integer currentIndex;

    private List<NavigationEntry> entries;

}
