package cn.hdlmx.amap.client.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 城市建议列表
 * <p>
 * 当搜索的文本关键字在限定城市中没有返回时会返回建议城市列表
 *
 * @author hdlmx
 */
public class SearchSuggestion {
    /**
     * 关键字
     */
    @ApiModelProperty("关键字")
    private String keywords;
}
