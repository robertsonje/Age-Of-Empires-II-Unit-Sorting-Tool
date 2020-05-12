/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CrudRepository.Model;
import java.util.List;

/**
 *
 * @author robertsonje
 */
public class AjaxResponseBody {
    String msg;
    List<Unit> result;

    public String getMsg() {
        return this.msg;
    }

    public List<Unit> getResult() {
        return this.result;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(List<Unit> units) {
        this.result = units;
    }
}
