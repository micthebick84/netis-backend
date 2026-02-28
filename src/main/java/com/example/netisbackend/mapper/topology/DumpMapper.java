package com.example.netisbackend.mapper.topology;

import com.example.netisbackend.dto.topology.TopoDumpDto;
import com.example.netisbackend.dto.topology.TopoRestHistDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DumpMapper {

    // --- Export (bulk SELECT all topology data) ---
    List<Map<String, Object>> selectGroupAll(@Param("userId") String userId);

    List<Map<String, Object>> selectItemAll(@Param("userId") String userId);

    List<Map<String, Object>> selectEtcAll(@Param("userId") String userId);

    List<Map<String, Object>> selectLinkAll(@Param("userId") String userId);

    List<Map<String, Object>> selectLinkMultiAll(@Param("userId") String userId);

    List<Map<String, Object>> selectUserAll(@Param("userId") String userId);

    List<Map<String, Object>> selectDrawToolAll(@Param("userId") String userId);

    // --- Import (bulk INSERT + delete) ---
    void deleteTopology(@Param("userId") String userId);

    void insertGroup(Map<String, Object> params);

    void insertItem(Map<String, Object> params);

    void insertEtc(Map<String, Object> params);

    void insertLink(Map<String, Object> params);

    void insertLinkMulti(Map<String, Object> params);

    void insertUser(Map<String, Object> params);

    void insertDrawTool(Map<String, Object> params);

    void procSpMakeTopoLeaf(@Param("userId") String userId);

    // --- Dump history ---
    void insertDumpXML(Map<String, Object> params);

    List<TopoDumpDto> selectDumpList(@Param("userId") String userId);

    Map<String, Object> selectDumpXML(@Param("dumpSeq") long dumpSeq);

    // --- Restore history ---
    void insertRestoreHist(Map<String, Object> params);

    List<TopoRestHistDto> selectRestoreHist(Map<String, Object> params);
}
