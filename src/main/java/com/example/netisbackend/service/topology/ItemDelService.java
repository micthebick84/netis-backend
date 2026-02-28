package com.example.netisbackend.service.topology;

import com.example.netisbackend.mapper.topology.ItemDelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemDelService {

    private final ItemDelMapper itemDelMapper;

    /**
     * 회선(Link) 삭제
     */
    @Transactional
    public void deleteLink(Map<String, Object> params) {
        String keyUserId = itemDelMapper.selectKeyUserId(params);
        params.put("keyUserId", keyUserId);
        itemDelMapper.deleteLink(params);
    }

    /**
     * 회선(Link) 다중 삭제
     */
    @Transactional
    public void deleteLinkMulti(Map<String, Object> params) {
        String keyUserId = itemDelMapper.selectKeyUserId(params);
        params.put("keyUserId", keyUserId);
        itemDelMapper.deleteLinkMulti(params);
    }

    /**
     * 포인트(Point) 삭제
     */
    @Transactional
    public void deletePoint(Map<String, Object> params) {
        String keyUserId = itemDelMapper.selectKeyUserId(params);
        params.put("keyUserId", keyUserId);
        itemDelMapper.deletePoint(params);
    }

    /**
     * 아이템 단건 삭제 (devKind1에 따라 그룹/ETC/일반 분기)
     */
    @Transactional
    public void deleteItem(Map<String, Object> params) {
        String devKind1 = String.valueOf(params.get("devKind1"));
        String keyUserId = itemDelMapper.selectKeyUserId(params);
        params.put("keyUserId", keyUserId);
        boolean isProcCall = false;

        if ("GRP".equals(devKind1)) {
            itemDelMapper.deleteGroup(params);
            isProcCall = true;
        } else if ("ETC".equals(devKind1)) {
            itemDelMapper.deleteEtc(params);
            itemDelMapper.deleteItem(params);
        } else {
            itemDelMapper.deleteItem(params);
        }

        // 그룹이 삭제된 경우 SP_MAKE_TOPO_LEAF 호출
        if (isProcCall) {
            String userId = String.valueOf(params.get("userId"));
            String mapUserId = itemDelMapper.selectMapId(userId);
            itemDelMapper.procSpMakeTopoLeaf(mapUserId);
        }
    }

    /**
     * 아이템 다건 삭제
     */
    @Transactional
    @SuppressWarnings("unchecked")
    public void deleteItemMulti(Map<String, Object> params) {
        List<Map<String, Object>> delItemList = (List<Map<String, Object>>) params.get("delItemList");
        if (CollectionUtils.isEmpty(delItemList)) {
            return;
        }

        String userId = String.valueOf(params.get("userId"));
        boolean isProcCall = false;

        for (Map<String, Object> delItem : delItemList) {
            delItem.put("userId", userId);
            String devKind1 = String.valueOf(delItem.get("devKind1"));
            String keyUserId = itemDelMapper.selectKeyUserId(delItem);
            delItem.put("keyUserId", keyUserId);

            if ("GRP".equals(devKind1)) {
                itemDelMapper.deleteGroup(delItem);
                isProcCall = true;
            } else if ("POINT".equals(devKind1)) {
                itemDelMapper.deletePoint(delItem);
            } else {
                itemDelMapper.deleteItem(delItem);
            }
        }

        // 그룹이 삭제된 경우 SP_MAKE_TOPO_LEAF 호출
        if (isProcCall) {
            String mapUserId = itemDelMapper.selectMapId(userId);
            itemDelMapper.procSpMakeTopoLeaf(mapUserId);
        }
    }

    /**
     * 임의장비(Etc) 삭제
     */
    @Transactional
    public void deleteEtc(Map<String, Object> params) {
        String keyUserId = itemDelMapper.selectKeyUserId(params);
        params.put("keyUserId", keyUserId);
        itemDelMapper.deleteEtc(params);
    }

    /**
     * 그룹 삭제 (cascade)
     */
    @Transactional
    public void deleteGroup(Map<String, Object> params) {
        String keyUserId = itemDelMapper.selectKeyUserId(params);
        params.put("keyUserId", keyUserId);
        itemDelMapper.deleteGroup(params);
    }

    /**
     * 맵 사용자ID 조회
     */
    public String getMapId(Map<String, Object> params) {
        return itemDelMapper.selectMapId(String.valueOf(params.get("userId")));
    }
}
