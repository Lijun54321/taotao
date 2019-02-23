package com.taotao.search.mapper;

import com.taotao.search.pojo.SearchItem;

import java.util.List;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.search.mapper
 * @date 19-2-23 下午3:12
 */
public interface ItemMapper {

	List<SearchItem> getItemList();
}
