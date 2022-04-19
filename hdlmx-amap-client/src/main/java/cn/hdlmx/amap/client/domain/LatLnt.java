package cn.hdlmx.amap.client.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 经纬度
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("经纬度")
public class LatLnt {
    @ApiModelProperty("纬度")
    private Double lat;
    @ApiModelProperty("经度")
    private Double lnt;

}
