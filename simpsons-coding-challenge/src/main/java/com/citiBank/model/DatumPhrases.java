
package com.citiBank.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class DatumPhrases implements Serializable
{

    private String id;
    private String character;
    private String phrase;
    private final static long serialVersionUID = -2550258514888394275L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("character", character).append("phrase", phrase).toString();
    }

}
