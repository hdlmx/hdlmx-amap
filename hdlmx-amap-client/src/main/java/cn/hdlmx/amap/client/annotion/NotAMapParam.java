package cn.hdlmx.amap.client.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 用来标记字段不需要反射为请求参数
 *
 * @author hdlmx
 */
@Target(ElementType.FIELD)
public @interface NotAMapParam {
}
