package com.jackmouse.shop.item.service.impl;


import com.jackmouse.shop.item.dto.ShopItemMainDto;
import com.jackmouse.shop.item.entity.ShopItem;
import com.jackmouse.shop.item.entity.table.ShopItemTableDef;
import com.jackmouse.shop.item.mapper.ShopItemMapper;
import com.jackmouse.shop.item.service.IShopItemService;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.jackmouse.shop.item.entity.table.ShopItemTableDef.SHOP_ITEM;

/**
 * @ClassName ShopItemImpl
 * @Description ShopItem Service实现
 * @Author zhoujiaangyao
 * @Date 2024/11/12 18:09
 * @Version 1.0
 **/
@Service
public class ShopItemImpl implements IShopItemService {
    @Autowired
    private  ShopItemMapper ShopItemMapper;

    @Override
    public List<ShopItem> selectMainShopItems() {
        return ShopItemMapper.selectAll();
    }

    @Override
    public List<ShopItem> selectSearchShopItems(ShopItemMainDto search) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(SHOP_ITEM.SHOP_NAME.like(search.getShopName())
                        .when(search.getShopName() != null && !search.getShopName().isEmpty())
                )
                .and(SHOP_ITEM.SHOP_TYPE.like(search.getShopType())
                        .when(search.getShopType() != null && !search.getShopType().isEmpty())
                )
                .and(Optional.ofNullable(search.getPriceMin())
                        .filter(StringUtils::hasText)
                        .map(Double::parseDouble)
                        .flatMap(min -> Optional.ofNullable(search.getPriceMax())
                                .filter(StringUtils::hasText)
                                .map(Double::parseDouble)
                                .map(max -> SHOP_ITEM.PRICE.between(min, max)))
                        .orElse(null));

        return ShopItemMapper.selectListByQuery(queryWrapper);
    }
}
