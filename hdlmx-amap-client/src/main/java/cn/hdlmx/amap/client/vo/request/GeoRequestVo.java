package cn.hdlmx.amap.client.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 地理编码请求VO
 *
 * @author hdlmx
 * @date 2022年04月10 22:53:39
 */
@ApiModel("地理编码 request")
@Data
public class GeoRequestVo extends BaseAMapWebApiRequestVo {
    @ApiModelProperty(value = "结构化地址信息", required = true)
    private String address;

    @ApiModelProperty(value = "指定查询的城市", required = false)
    private String city;

}
