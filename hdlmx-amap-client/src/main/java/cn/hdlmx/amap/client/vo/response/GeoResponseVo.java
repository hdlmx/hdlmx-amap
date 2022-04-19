package cn.hdlmx.amap.client.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 地理编码response vo
 *
 * @author hdlmx
 * @date 2022年04月11 21:43:37
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("地理编码response vo")
public class GeoResponseVo extends BaseAMapWebApiResponseVo {
    @ApiModelProperty("地理编码信息列表")
    private List<GeoCodeVo> geocodes;

}
