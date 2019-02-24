package com.taotao.search.dao;

import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.search
 * @date 19-2-23 下午4:20
 */
public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
