
package com.citiBank.model;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Characters implements Serializable
{

    private List<Datum> data = null;
    private final static long serialVersionUID = 1201457172424922790L;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).toString();
    }

}
