package com.taotao.search.pojo;

import java.util.List;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.search.pojo
 * @date 19-2-23 下午4:16
 */
public class SearchResult {

	private List<SearchItem> itemList;
	private Long recordCount;
	private int pageCount;
	private int curPage;

	public List<SearchItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<SearchItem> itemList) {
		this.itemList = itemList;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

}
