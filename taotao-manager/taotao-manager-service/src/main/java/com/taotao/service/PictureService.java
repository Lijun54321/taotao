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
    Pictureresult uploadPic(MultipartFile picFile, String path);
}
