package com.example.AOE2SortingTool.Model;
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
