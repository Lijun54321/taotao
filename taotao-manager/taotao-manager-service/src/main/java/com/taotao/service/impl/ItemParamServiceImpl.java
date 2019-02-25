package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.service.impl
 * @date 19-2-19 下午2:45
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    TbItemParamMapper tbItemParamMapper;

    @Override
    public EasyUIDataGridResult getItemParamList(int page, int rows) {
        // 分页处理
        PageHelper.startPage(page, rows);
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExampleWithBLOBs(null);
        //List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExample(null);

        tbItemParamMapper.selectByPrimaryKey((long) 1);

        PageInfo<TbItemParam> info = new PageInfo<>(tbItemParams);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(info.getTotal());
        result.setRows(tbItemParams);
        return result;
    }

    @Override
    public TaotaoResult getItemByCid(Long cid) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExampleWithBLOBs(example);
        if(tbItemParams != null && tbItemParams.size() > 0){
            TbItemParam itemParam = tbItemParams.get(0);
            return TaotaoResult.ok(itemParam);
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(Long cid, String paramData) {
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        Date date = new Date();
        itemParam.setCreated(date);
        itemParam.setParamData(paramData);
        itemParam.setUpdated(date);
        tbItemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult deleteItemParam(String ids) {
        String[] split = ids.split(",");
        for(String s : split){
            int i = Integer.parseInt(s);
            tbItemParamMapper.deleteByPrimaryKey((long) i);
        }
        return TaotaoResult.ok();
    }

    @Override
    public TbItemParam getItemById(Long id) {
        return tbItemParamMapper.selectByPrimaryKey(id);
    }
}
