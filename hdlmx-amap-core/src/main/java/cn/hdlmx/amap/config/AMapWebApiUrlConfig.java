package cn.hdlmx.amap.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 高德地图Web api 服务url
 *
 * @author hdlmx
 * @date 2022年04月10 21:25:53
 */
@Configuration
@ConfigurationProperties(prefix = "hdlmx.amap.webapi")
@Data
public class AMapWebApiUrlConfig {
    private String geo;
    private String regeo;
    private String search;
    private String coordinateConvert;
    private String directionDriving;
    private String directionIntegrated;
}
