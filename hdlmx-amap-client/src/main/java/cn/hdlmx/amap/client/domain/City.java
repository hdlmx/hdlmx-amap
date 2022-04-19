package cn.hdlmx.amap.client.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 城市
 */
public class City {
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("该城市的citycode")
    private String citycode;

    @ApiModelProperty("该城市的adcode")
    private String adcode;

}
