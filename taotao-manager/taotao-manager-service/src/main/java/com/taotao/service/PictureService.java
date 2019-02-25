package com.taotao.service;

import com.taotao.common.pojo.Pictureresult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.service
 * @date 19-2-18 下午8:20
 */
public interface PictureService {
	/**
	 * 上传图片功能实现
	 *
	 * @param picFile 前天传来的图片数据
	 * @param path    配置文件的地址
	 * @return 图片上传成功后的数据 其中包括了它的地址
	 */
	Pictureresult uploadPic(MultipartFile picFile, String path);
}
