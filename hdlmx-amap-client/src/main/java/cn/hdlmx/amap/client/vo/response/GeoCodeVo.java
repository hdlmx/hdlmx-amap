package cn.hdlmx.amap.client.vo.response;

import cn.hdlmx.amap.client.domain.LatLnt;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 地理编码信息列表
 *
 * @author hdlmx
 * @date 2022年04月11 21:45:55
 */
@ApiModel("地理编码信息列表")
@Data
public class GeoCodeVo {
    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("地址所在的省份名")
    private String province;

    @ApiModelProperty("地址所在的城市名")
    private String city;

    @ApiModelProperty("城市编码")
    private String citycode;

    @ApiModelProperty("地址所在的区")
    private String district;

    @ApiModelProperty("街道")
    private String street;

    @ApiModelProperty("门牌")
    private String number;

    @ApiModelProperty("区域编码")
    private String adcode;

    @ApiModelProperty("坐标点")
    private String location;

    @ApiModelProperty("经纬度")
    LatLnt latLnt;
}
