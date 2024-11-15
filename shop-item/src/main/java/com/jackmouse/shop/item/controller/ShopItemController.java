package com.jackmouse.shop.item.controller;

import com.jackmouse.common.model.Result;
import com.jackmouse.shop.item.dto.ShopItemMainDto;
import com.jackmouse.shop.item.entity.ShopItem;
import com.jackmouse.shop.item.service.IShopItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ShopItemController
 * @Description 商品信息接口
 * @Author zhoujiaangyao
 * @Date 2024/11/12 17:17
 * @Version 1.0
 **/
@Tag(
        name = "商品的CRUD REST APIs",
        description = "kiwa_shop 中的 CRUD REST API 用于创建、更新、获取和删除卡详细信息"
)
@RestController
@RequestMapping(path = "/shop/item")
@Validated
@AllArgsConstructor
@CrossOrigin("*")
public class ShopItemController {

    IShopItemService iShopItemService;

    @Operation(
            summary = "获取主页商品信息",
            description = "获取主页商品信息，用于展示在主页"
    )
    @GetMapping("/get")
    public Result<List<ShopItem>> getMainShopItems() {
        return Result.succeed(iShopItemService.selectMainShopItems());
    }

    @Operation(
            summary = "获取搜索商品信息",
            description = "获取搜索商品信息，用于展示在搜索页"
    )
    @PostMapping("/search")
    public Result<List<ShopItem>> getSearchShopItems(@RequestBody ShopItemMainDto search) {
        return Result.succeed(iShopItemService.selectSearchShopItems(search));
    }
}
