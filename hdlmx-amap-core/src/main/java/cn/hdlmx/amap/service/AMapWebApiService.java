package cn.hdlmx.amap.service;

import cn.hdlmx.amap.client.vo.request.ReGeoRequest;
import cn.hdlmx.amap.client.vo.response.GeoResponseVo;
import cn.hdlmx.amap.client.vo.request.GeoRequestVo;

/**
 * 高德地图接口service
 *
 * @author hdlmx
 * @date 2022年04月10 22:47:51
 */
public interface AMapWebApiService {
    GeoResponseVo geo(GeoRequestVo request);

    GeoResponseVo reGeo(ReGeoRequest request);


}
