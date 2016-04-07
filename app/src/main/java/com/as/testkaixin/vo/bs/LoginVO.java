package com.as.testkaixin.vo.bs;

/**
 * Created by samsung on 2015/12/22.
 */
public class LoginVO {

    /**
     * captcha : 8000
     * rcode : 145074952583342412
     * captcha_url : http://www.kaixin001.com/interface/getcaptcha.php?key=145074952583342412&keytype=client_login
     */

    private String captcha;
    private String rcode;
    private String captcha_url;

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public void setCaptcha_url(String captcha_url) {
        this.captcha_url = captcha_url;
    }

    public String getCaptcha() {
        return captcha;
    }

    public String getRcode() {
        return rcode;
    }

    public String getCaptcha_url() {
        return captcha_url;
    }
}
