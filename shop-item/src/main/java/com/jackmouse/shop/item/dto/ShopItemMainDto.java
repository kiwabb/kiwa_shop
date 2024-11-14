package com.jackmouse.shop.item.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName ShopItemMainDto
 * @Description 主页商品信息
 * @Author zhoujiaangyao
 * @Date 2024/11/12 17:29
 * @Version 1.0
 **/
@Schema(
        name = "主页商品信息",
        description = "主页商品信息,用于主页的商品显示"
)
@Data
@Getter
@Setter
public class ShopItemMainDto {
    @Schema(description = "商品图片", example = "https://jackmouse/shop/item/1.jpg")
    private String imgUrl;

    @Schema(description = "商品名称", example = "商品1")
    private String shopName;

    @Schema(description = "商品类型", example = "类型1")
    private String shopType;

    @Schema(description = "商品价格", example = "99.99")
    private String priceMin;

    @Schema(description = "商品价格", example = "199.99")
    private String priceMax;
}
