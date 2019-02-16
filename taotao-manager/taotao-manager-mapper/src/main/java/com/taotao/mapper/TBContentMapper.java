package com.taotao.mapper;

import com.taotao.pojo.TBContent;
import com.taotao.pojo.TBContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBContentMapper {
    int countByExample(TBContentExample example);

    int deleteByExample(TBContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TBContent record);

    int insertSelective(TBContent record);

    List<TBContent> selectByExampleWithBLOBs(TBContentExample example);

    List<TBContent> selectByExample(TBContentExample example);

    TBContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TBContent record, @Param("example") TBContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TBContent record, @Param("example") TBContentExample example);

    int updateByExample(@Param("record") TBContent record, @Param("example") TBContentExample example);

    int updateByPrimaryKeySelective(TBContent record);

    int updateByPrimaryKeyWithBLOBs(TBContent record);

    int updateByPrimaryKey(TBContent record);
}