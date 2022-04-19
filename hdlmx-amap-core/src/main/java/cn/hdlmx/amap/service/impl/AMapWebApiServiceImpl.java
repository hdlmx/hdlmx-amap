package cn.hdlmx.amap.service.impl;

import cn.hdlmx.amap.client.vo.request.ReGeoRequest;
import cn.hdlmx.amap.client.vo.response.GeoResponseVo;
import cn.hdlmx.amap.client.domain.LatLnt;
import cn.hdlmx.amap.client.vo.request.BaseAMapWebApiRequestVo;
import cn.hdlmx.amap.client.vo.request.GeoRequestVo;
import cn.hdlmx.amap.config.AMapWebApiUrlConfig;
import cn.hdlmx.amap.service.AMapWebApiService;
import cn.hdlmx.common.utils.time.TimeUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author hdlmx
 * @date 2022年04月11 22:32:04
 */
@Service
@Slf4j
public class AMapWebApiServiceImpl implements AMapWebApiService {
    @Autowired
    AMapWebApiUrlConfig aMapWebApiUrlConfig;
    @Value("${hdlmx.amap.web-api-key}")
    private String key;

    public String webApi(BaseAMapWebApiRequestVo request, String url) {
        StringBuilder urlAll = new StringBuilder(url).append("?");
        try {
            urlAll.append(paramsBuild(request));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        OkHttpClient client = new OkHttpClient();
        Request webRequest = new Request.Builder().url(urlAll.toString()).build();
        LocalDateTime start = LocalDateTime.now();
        try (Response response = client.newCall(webRequest).execute()) {
            if (Objects.nonNull(response.body())) {
                System.out.println(TimeUtils.timeDurationStr(start));
                return Objects.requireNonNull(response.body()).string();
            }
        } catch (IOException e) {
            log.info("网络异常");
        }

        return null;
    }

    /**
     * 使用反射拼接接口参数字符串
     *
     * @param request 高德地图web api请求参数
     * @return 参数字符串
     * @throws IllegalAccessException
     */
    public String paramsBuild(BaseAMapWebApiRequestVo request) throws IllegalAccessException {
        Class<? extends BaseAMapWebApiRequestVo> requestClass = request.getClass();
        Field[] requestFields = requestClass.getDeclaredFields();
        Field[] declaredFields = requestClass.getSuperclass().getDeclaredFields();
        List<Field> fields = new ArrayList<>(Arrays.asList(requestFields));
        fields.addAll(Arrays.asList(declaredFields));
        if (!CollectionUtils.isEmpty(fields)) {
            StringBuilder paramsStringBuilder = new StringBuilder();
            for (Field field : fields) {
                field.setAccessible(true);
                if (Objects.nonNull(field.get(request))) {
                    if (StringUtils.isNotBlank(paramsStringBuilder.toString())) {
                        paramsStringBuilder.append("&");
                    }
                    paramsStringBuilder.append(field.getName()).append("=").append(field.get(request).toString());
                }
            }
            return paramsStringBuilder.toString();
        }
        return null;
    }

    /**
     * 地理编码
     *
     * @param request 地理编码请求
     * @return 地理编码返回结果
     */
    @Override
    public GeoResponseVo geo(GeoRequestVo request) {
        request.setKey(key);
        String aMapiWebApiResponseBodyStr = webApi(request, aMapWebApiUrlConfig.getGeo());
        GeoResponseVo geoResponseVo = JSON.parseObject(aMapiWebApiResponseBodyStr, GeoResponseVo.class);
        if (Objects.nonNull(geoResponseVo) && !CollectionUtils.isEmpty(geoResponseVo.getGeocodes())) {
            geoResponseVo.getGeocodes().forEach(item -> {
                LatLnt latLnt = latLntFormat(item.getLocation());
                item.setLatLnt(latLnt);
            });
        }
        return geoResponseVo;
    }

    @Override
    public GeoResponseVo reGeo(ReGeoRequest request) {
        return null;
    }

    /**
     * 将经纬度字符串转为经纬度数组
     *
     * @param location 经纬度字符串
     * @return 经纬度对象
     */
    public LatLnt latLntFormat(String location) {
        String[] latLntStr = location.split(",");
        return new LatLnt(Double.parseDouble(latLntStr[0]), Double.parseDouble(latLntStr[1]));
    }

    /**
     * 将经纬度对象转为经纬度字符串
     *
     * @param latLnt 经纬度对象
     * @return 经纬度字符串
     */
    public String latLntToStr(LatLnt latLnt) {
        return latLnt.getLat() + "," + latLnt.getLnt();
    }
}

