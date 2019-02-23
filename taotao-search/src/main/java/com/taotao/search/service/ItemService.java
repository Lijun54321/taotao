package com.taotao.search.service;

import com.taotao.common.pojo.TaotaoResult;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.search.service
 * @date 19-2-23 下午3:24
 */
public interface ItemService {

	TaotaoResult importItems() throws IOException, SolrServerException;

}
