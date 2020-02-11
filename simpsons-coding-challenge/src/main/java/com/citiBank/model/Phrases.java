
package com.citiBank.model;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Phrases implements Serializable
{

    private List<DatumPhrases> data = null;
    private final static long serialVersionUID = -1307357011007538115L;

    public List<DatumPhrases> getData() {
        return data;
    }

    public void setData(List<DatumPhrases> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).toString();
    }

}
