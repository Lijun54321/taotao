package com.taotao.service.impl;

import com.taotao.common.pojo.Pictureresult;
import com.taotao.service.PictureService;
import com.taotao.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.service.impl
 * @date 19-2-18 下午8:22
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${IMAGE_SERVER_BASE_URL}")
    private String IMAGE_SERVER_BASE_URL;
    @Override
    public Pictureresult uploadPic(MultipartFile picFile, String path) {
        Pictureresult pictureresult = new Pictureresult();
        // 判断图片是否为空
        if(picFile.isEmpty()){
            pictureresult.setError(1);
            pictureresult.setMessage("图片为空");
            return pictureresult;
        }
        try {
            // 取图片拓展名
            String originalFilename = picFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient client = new FastDFSClient(path);

            String url = client.uploadFile(picFile.getBytes(), extName);
            // 拼接图片服务器的IP地址
            url = IMAGE_SERVER_BASE_URL + url;

            pictureresult.setError(0);
            pictureresult.setUrl(url);
        } catch (Exception e) {
            pictureresult.setError(1);
            pictureresult.setMessage("图片上传失败");
            e.printStackTrace();
        }
        return pictureresult;
    }
}
//
