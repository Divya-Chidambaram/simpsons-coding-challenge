package com.citiBank.model;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    List<CharacterAndPhrases> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CharacterAndPhrases> getResult() {
        return result;
    }

    public void setResult(List<CharacterAndPhrases> result) {
        this.result = result;
    }

}
