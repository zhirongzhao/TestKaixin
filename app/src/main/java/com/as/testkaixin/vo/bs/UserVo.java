package com.as.testkaixin.vo.bs;

import java.io.Serializable;

/**
 * Created by samsung on 2015/12/7.
 */
public class UserVo implements Serializable{
    private String getsimi          =  "1"                                             ;
    private String oauth_signature=	"amKXSOzlFp98jVzCEj34C2brZF4="                   ;
    private String device_name     =	"unknown$!Android SDK built for x86"            ;
    private String x_auth_username=	"zhirong.zhao@samsung.com"                       ;
    private String x_auth_mode     =	"client_auth"                                   ;
    private String oauth_version   =	"1.0"                                           ;
    private String oauth_nonce              =	"d6b9990d99b3777aaea541ae36380ad1";
    private String oauth_signature_method=	"HMAC-SHA1";
    private String oauth_consumer_key     =	"87247717949570179fa41c43e20ed289";
    private String ctype                    =	"15803AndroidClient";
    private String x_auth_password        =	"qwer1324!";
    private String oauth_timestamp        =	"1450139034";

    public String getGetsimi() {
        return getsimi;
    }

    public String getOauth_signature() {
        return oauth_signature;
    }

    public String getDevice_name() {
        return device_name;
    }

    public String getX_auth_username() {
        return x_auth_username;
    }

    public String getX_auth_mode() {
        return x_auth_mode;
    }

    public String getOauth_version() {
        return oauth_version;
    }

    public String getOauth_nonce() {
        return oauth_nonce;
    }

    public String getOauth_signature_method() {
        return oauth_signature_method;
    }

    public String getOauth_consumer_key() {
        return oauth_consumer_key;
    }

    public String getCtype() {
        return ctype;
    }

    public String getX_auth_password() {
        return x_auth_password;
    }

    public String getOauth_timestamp() {
        return oauth_timestamp;
    }

    public void setGetsimi(String getsimi) {
        this.getsimi = getsimi;
    }
}
