package cn.hdlmx.amap.client.vo.request;

import cn.hdlmx.amap.client.annotion.NotAMapParam;
import cn.hdlmx.amap.client.domain.LatLnt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author hdlmx
 */
@Data
@ApiModel("周边搜索 request")
public class AroundSearchRequestVo {
    @ApiModelProperty(value = "中心点坐标", notes = "经纬度", required = true)
    @NotAMapParam
    private LatLnt latLnts;

    @ApiModelProperty(value = "中心点坐标", hidden = true)
    private String location;

    @ApiModelProperty(value = "查询关键字", notes = "多个关键字用“|”分割")
    private String keywords;

    @ApiModelProperty(value = "查询半径", notes = "取值范围:0-50000。规则：大于50000按默认值，单位：米")
    private Integer radius = 3000;

    @ApiModelProperty(value = "查询POI类型", notes = "可选值：分类代码 或 汉字（若用汉字，请严格按照附件之中的汉字填写）")
    private String types;

    @ApiModelProperty(value = "查询城市", notes = "可选值：城市中文、中文全拼、citycode、adcode\n" +
            "\n" +
            "如：北京/beijing/010/110000\n" +
            "\n" +
            "当用户指定的经纬度和city出现冲突，若范围内有用户指定city的数据，则返回相关数据，否则返回为空。\n" +
            "\n" +
            "如：经纬度指定石家庄，而city却指定天津，若搜索范围内有天津的数据则返回相关数据，否则返回为空。")
    private String city;

    @ApiModelProperty(value = "每页记录数据", notes = "强烈建议不超过25，若超过25可能造成访问报错")
    @Min(1)
    @Max(25)
    private Integer offset = 20;

    @ApiModelProperty(value = "当前页数", notes = "最大翻页数100")
    @Max(100)
    @Min(1)
    private Integer page = 1;


}
