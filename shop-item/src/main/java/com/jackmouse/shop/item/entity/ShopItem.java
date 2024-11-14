package com.jackmouse.shop.item.entity;

import com.jackmouse.common.entity.BaseEntity;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName ShopItem
 * @Description 商品详情实体类
 * @Author zhoujiaangyao
 * @Date 2024/11/12 16:43
 * @Version 1.0
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("shop_item")
public class ShopItem extends BaseEntity {

    @Id(keyType = KeyType.Auto)
    private Long Id;

    private String shopName;

    private String price;

    private String shopType;

    private String imgUrl;

    private String storeName;
}
