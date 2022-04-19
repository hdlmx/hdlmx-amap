package cn.hdlmx.amap.client.vo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 高德地图web api基础请求VO
 *
 * @author hdlmx
 * @date 2022年04月10 22:57:37
 */
@Data
public class BaseAMapWebApiRequestVo {
    @ApiModelProperty(value = "开发者的key", hidden = true)
    private String key;

    @ApiModelProperty(value = "批量查询控制", notes = "batch 参数设置为 true 时进行批量查询操作，最多支持 10 个地址进行批量查询")
    private boolean batch = false;

    @NotBlank
    @Pattern(regexp = "base|all")
    @ApiModelProperty(value = "返回结果控制", notes = "此项默认返回基本地址信息；取值为all返回地址信息、附近POI、道路以及道路交叉口信息。")
    private String extensions = "base";


}
