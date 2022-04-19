package cn.hdlmx.amap.client.vo.request;

import cn.hdlmx.amap.client.annotion.NotAMapParam;
import cn.hdlmx.amap.client.domain.LatLnt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("逆地理编码 request")
public class ReGeoRequest extends BaseAMapWebApiRequestVo {
    @ApiModelProperty("经纬度")
    @NotBlank
    @NotAMapParam
    private LatLnt latLnt;

    @ApiModelProperty("返回附近POI类型")
    private String poitype;

    @ApiModelProperty("搜索半径")
    private Double radius;

    @ApiModelProperty(value = "经纬度", hidden = true)
    private String location;


}
