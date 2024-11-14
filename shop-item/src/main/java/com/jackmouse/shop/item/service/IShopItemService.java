package com.jackmouse.shop.item.service;

import com.jackmouse.shop.item.dto.ShopItemMainDto;
import com.jackmouse.shop.item.entity.ShopItem;

import java.util.List;

/**
 * @ClassName IShopItemService
 * @Description ShopItem Service接口
 * @Author zhoujiaangyao
 * @Date 2024/11/12 18:07
 * @Version 1.0
 **/
public interface IShopItemService {
    List<ShopItem> selectMainShopItems();

    List<ShopItem> selectSearchShopItems(ShopItemMainDto search);
}
