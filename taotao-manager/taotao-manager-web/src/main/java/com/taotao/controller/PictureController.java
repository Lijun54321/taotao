package com.taotao.controller;

import com.taotao.common.pojo.Pictureresult;
import com.taotao.service.PictureService;
import com.taotao.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传Controller
 *
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.controller
 * @date 19-2-18 下午8:31
 */
@Controller
public class PictureController {
    @Autowired
    PictureService pictureService;


    @RequestMapping("/pic/upload")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile) {
        /*
        // 取图片拓展名
        String originalFilename = uploadFile.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String path = this.getClass().getClassLoader().getResource("properties/client.conf").getPath();
        try {
            FastDFSClient fastDFSClient = new FastDFSClient(path);
            System.out.println(fastDFSClient.uploadFile(uploadFile.getBytes(), extName));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        String path = this.getClass().getClassLoader().getResource("properties/client.conf").getPath();
        // 需要讲java包转成json对象
        Pictureresult pictureresult = pictureService.uploadPic(uploadFile, path);
        return JsonUtils.objectToJson(pictureresult);
    }
}
