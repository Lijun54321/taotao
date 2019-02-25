package com.taotao.portal.pojo;

import com.taotao.pojo.TbItem;

/**
 * 处理图片
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.portal.pojo
 * @date 19-2-23 下午9:10
 */
public class PortalItem extends TbItem {
	public String[] getImages() {
		String images = this.getImage();
		if (images != null && !images.equals("")) {
			String[] imgs = images.split(",");
			return imgs;
		}
		return null;
	}
}
