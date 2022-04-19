package cn.hdlmx.amap.utils;

import cn.hdlmx.amap.config.AMapWebApiUrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化
 *
 * @author hdlmx
 * @date 2022年04月10 21:41:17
 */
@Component
public class MyRunner implements ApplicationRunner {
    @Autowired
    AMapWebApiUrlConfig aMapWebApiUrlConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(aMapWebApiUrlConfig);

    }
}
