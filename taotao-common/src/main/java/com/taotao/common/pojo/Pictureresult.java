package com.taotao.common.pojo;

/**
 * @author lijun
 * @version V1.0
 * @package_name: com.taotao.common.pojo
 * @date 19-2-18 下午7:40
 */
public class Pictureresult {

    private int error;
    private String url;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
