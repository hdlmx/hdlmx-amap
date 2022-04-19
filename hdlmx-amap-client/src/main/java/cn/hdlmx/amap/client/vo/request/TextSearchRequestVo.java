package cn.hdlmx.amap.client.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author hdlmx
 */
@Data
@ApiModel("关键字搜索 request")
public class TextSearchRequestVo extends BaseAMapWebApiRequestVo {
    @ApiModelProperty(value = "查询关键字", notes = "规则： 多个关键字用“|”分割。若不指定city，并且搜索的为泛词（例如“美食”）的情况下，返回的内容为城市列表以及此城市内有多少结果符合要求", required = true)
    private String keywords;

    @ApiModelProperty(value = "查询POI类型", notes = "可选值：分类代码 或 汉字（若用汉字，请严格按照附件之中的汉字填写）")
    private String types;

    @ApiModelProperty(value = "查询城市", notes = "可选值：城市中文、中文全拼、citycode、adcode\n" +
            "\n" +
            "如：北京/beijing/010/110000")
    private String city;
    @ApiModelProperty(value = "仅返回指定城市数据", notes = "可选值：true/false")
    private boolean citylimit = false;

    @ApiModelProperty(value = "是否按照层级展示子POI数据", notes = "可选值：children=1\n" +
            "\n" +
            "当为0的时候，子POI都会显示。\n" +
            "\n" +
            "当为1的时候，子POI会归类到父POI之中。\n" +
            "\n" +
            "\n" +
            "\n" +
            "仅在extensions=all的时候生效")
    private Integer children = 0;

    @ApiModelProperty(value = "每页记录数据", notes = "强烈建议不超过25，若超过25可能造成访问报错")
    @Min(1)
    @Max(25)
    private Integer offset = 20;

    @ApiModelProperty(value = "当前页数", notes = "最大翻页数100")
    @Max(100)
    @Min(1)
    private Integer page = 1;

}
