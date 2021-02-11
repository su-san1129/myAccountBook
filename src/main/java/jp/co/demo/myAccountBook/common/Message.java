package jp.co.demo.myAccountBook.common;

import lombok.Getter;

@Getter
public enum Message {
    LOGIN_ERROR("loginError", "メールアドレスまたはパスワードが違います。");

    private String key;
    private String msg;

    Message(String key, String msg) {
        this.key = key;
        this.msg = msg;
    }
}
