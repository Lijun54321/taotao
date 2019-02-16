package com.taotao.mapper;

import com.taotao.pojo.TbItemParamDesc;
import com.taotao.pojo.TbItemParamDescExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemParamDescMapper {
    int countByExample(TbItemParamDescExample example);

    int deleteByExample(TbItemParamDescExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItemParamDesc record);

    int insertSelective(TbItemParamDesc record);

    List<TbItemParamDesc> selectByExampleWithBLOBs(TbItemParamDescExample example);

    List<TbItemParamDesc> selectByExample(TbItemParamDescExample example);

    TbItemParamDesc selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItemParamDesc record, @Param("example") TbItemParamDescExample example);

    int updateByExampleWithBLOBs(@Param("record") TbItemParamDesc record, @Param("example") TbItemParamDescExample example);

    int updateByExample(@Param("record") TbItemParamDesc record, @Param("example") TbItemParamDescExample example);

    int updateByPrimaryKeySelective(TbItemParamDesc record);

    int updateByPrimaryKeyWithBLOBs(TbItemParamDesc record);

    int updateByPrimaryKey(TbItemParamDesc record);
}