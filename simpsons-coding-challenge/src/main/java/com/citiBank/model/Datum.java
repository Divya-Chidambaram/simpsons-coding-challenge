
package com.citiBank.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Datum implements Serializable
{

    private String id;
    private String firstName;
    private String lastName;
    private String picture;
    private int age;
    private final static long serialVersionUID = 1622056181916960697L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("firstName", firstName).append("lastName", lastName).append("picture", picture).append("age", age).toString();
    }

}
