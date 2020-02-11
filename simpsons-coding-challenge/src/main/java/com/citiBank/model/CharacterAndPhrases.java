package com.citiBank.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class CharacterAndPhrases {

	  //  @NotBlank(message = "id can't empty!")
	    private String id;
	    private String firstName;
	    private String lastName;
	    private String picture;
	    private int age;
	    private String character;
	    private String phrase;
	 

	    public CharacterAndPhrases(String id, String firstName, String lastName, String picture, int age, String character,
				String phrase) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.picture = picture;
			this.age = age;
			this.character = character;
			this.phrase = phrase;
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
	        return new ToStringBuilder(this).append("id", id).append("firstName", firstName).append("lastName", lastName).append("picture", picture).append("age", age).append("character", character).append("phrase", phrase).toString();
	    }
}
