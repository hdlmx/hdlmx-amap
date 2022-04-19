package cn.hdlmx.amap.client.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class POI {
    @ApiModelProperty("唯一ID")
    private String id;

    @ApiModelProperty("父POI的ID。当前POI如果有父POI，则返回父POI的ID。可能为空")
    private String parent;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "兴趣点类型", notes = "顺序为大类、中类、小类 例如：餐饮服务;中餐厅;特色/地方风味餐厅")
    private String type;

    @ApiModelProperty(value = "兴趣点类型编码", notes = "例如：050118")
    private String typecode;

    @ApiModelProperty(value = "行业类型")
    private String biz_type;

    @ApiModelProperty(value = "地址", notes = "东四环中路189号百盛北门")
    private String address;

    @ApiModelProperty(value = "经纬度", notes = "格式：X,Y")
    private String location;

    @ApiModelProperty(value = "离中心点距离", notes = "单位：米；仅在周边搜索的时候有值返回")
    private String distance;

    @ApiModelProperty(value = "POI的电话")
    private String tel;

    @ApiModelProperty(value = "邮编", notes = "extensions=all时返回")
    private String postcode;

    @ApiModelProperty(value = "POI的网址", notes = "extensions=all时返回")
    private String website;

    @ApiModelProperty(value = "POI的电子邮箱", notes = "POI的电子邮箱")
    private String email;

    @ApiModelProperty(value = "POI所在省份编码", notes = "POI的电子邮箱")
    private String pcode;

    @ApiModelProperty(value = "POI所在省份名称", notes = "若是直辖市的时候，此处直接显示市名，例如北京市")
    private String pname;

    @ApiModelProperty(value = "城市编码", notes = "extensions=all时返回")
    private String citycode;

    @ApiModelProperty(value = "城市名", notes = "若是直辖市的时候，此处直接显示市名，例如北京市")
    private String cityname;

    @ApiModelProperty(value = "区域编码", notes = "extensions=all时返回")
    private String adcode;

    @ApiModelProperty(value = "区域名称", notes = "区县级别的返回，例如朝阳区")
    private String adname;

    @ApiModelProperty(value = "POI的入口经纬度", notes = "extensions=all时返回，也可用作于POI的到达点")
    private String entr_location;

    @ApiModelProperty(value = "POI的出口经纬度", notes = "目前不会返回内容")
    private String exit_location;

    @ApiModelProperty(value = "所属商圈", notes = "extensions=all时返回")
    private String business_area;

    @ApiModelProperty(value = "该POI的特色内容", notes = "主要出现在美食类POI中，代表特色菜例如“烤鱼,麻辣香锅,老干妈回锅肉extensions=all时返回")
    private String tag;

    @ApiModelProperty(value = "停车场类型", notes = """
            仅在停车场类型POI的时候显示该字段
            展示停车场类型，包括：地下、地面、路边
             extensions=all的时候显示\s""")
    private String parking_type;


}
