package cn.hdlmx.amap.controller;

import cn.hdlmx.amap.client.vo.request.AroundSearchRequestVo;
import cn.hdlmx.amap.client.vo.request.GeoRequestVo;
import cn.hdlmx.amap.client.vo.request.ReGeoRequest;
import cn.hdlmx.amap.client.vo.request.TextSearchRequestVo;
import cn.hdlmx.amap.client.vo.response.GeoResponseVo;
import cn.hdlmx.amap.service.AMapWebApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 高德web api
 *
 * @author hdlmx
 * @date 2022年04月10 22:10:44
 */
@Api(tags = "amap-web-api", value = "高德地图平台web api", description = "高德地图平台web api")
@RestController
@RequestMapping("/web-api")
public class AMapWebApiController {
    @Autowired
    private AMapWebApiService apiService;

    @PostMapping("/geo")
    @ApiOperation(value = "地理编码", notes = "将详细的结构化地址转换为高德经纬度坐标")
    public GeoResponseVo geo(@Validated @RequestBody GeoRequestVo requestBody) {
        return apiService.geo(requestBody);
    }

    @PostMapping("/regeo")
    @ApiOperation(value = "逆地理编码", notes = "将经纬度转换为详细结构化的地址，且返回附近周边的POI、AOI信息")
    public GeoResponseVo reGeo(@Validated @RequestBody ReGeoRequest requestBody) {
        return apiService.reGeo(requestBody);
    }

    @PostMapping("/text")
    @ApiOperation(value = "关键字搜索", notes = "通过用POI的关键字进行条件搜索，例如：肯德基、朝阳公园等；同时支持设置POI类型搜索，例如：银行")
    public void text(@Validated @RequestBody TextSearchRequestVo requestBody) {

    }

    @PostMapping("/around")
    @ApiOperation(value = "周边搜索", notes = "在用户传入经纬度坐标点附近，在设定的范围内，按照关键字或POI类型搜索")
    public void around(@Validated @RequestBody AroundSearchRequestVo requestBody) {

    }


}
