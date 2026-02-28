package com.example.netisbackend.controller.topology;

import com.example.netisbackend.dto.ApiResponse;
import com.example.netisbackend.service.topology.ItemDelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/topology/item-del")
@RequiredArgsConstructor
public class ItemDelController {

    private final ItemDelService itemDelService;

    /**
     * 회선(Link) 삭제
     */
    @PostMapping("/link")
    public ApiResponse<String> deleteLink(@RequestBody Map<String, Object> params) {
        itemDelService.deleteLink(params);
        return ApiResponse.success("삭제되었습니다.");
    }

    /**
     * 회선(Link) 다중 삭제
     */
    @PostMapping("/link-multi")
    public ApiResponse<String> deleteLinkMulti(@RequestBody Map<String, Object> params) {
        itemDelService.deleteLinkMulti(params);
        return ApiResponse.success("삭제되었습니다.");
    }

    /**
     * 포인트(Point) 삭제
     */
    @PostMapping("/point")
    public ApiResponse<String> deletePoint(@RequestBody Map<String, Object> params) {
        itemDelService.deletePoint(params);
        return ApiResponse.success("삭제되었습니다.");
    }

    /**
     * 아이템 삭제 (단건/다건)
     * isMulti=true 인 경우 다건 삭제
     */
    @PostMapping("/item")
    public ApiResponse<String> deleteItem(@RequestBody Map<String, Object> params) {
        boolean isMulti = "true".equals(String.valueOf(params.get("isMulti")));
        if (isMulti) {
            itemDelService.deleteItemMulti(params);
        } else {
            itemDelService.deleteItem(params);
        }
        return ApiResponse.success("삭제되었습니다.");
    }
}
