package cn.hdlmx.amap.client.vo.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 高德地图web api返回结果基本类
 *
 * @author hdlmx
 * @date 2022年04月10 23:08:30
 */
@Data
public class BaseAMapWebApiResponseVo {
    @ApiModelProperty(value = "返回结果状态值", notes = "返回值为 0 或 1，0 表示请求失败；1 表示请求成功")
    private Integer status;

    @ApiModelProperty(value = "返回结果数目", notes = "返回结果的个数")
    private Integer count;

    @ApiModelProperty(value = "返回状态说明", notes = "当 status 为 0 时，info 会返回具体错误原因，否则返回“OK”")
    private String info;
}
