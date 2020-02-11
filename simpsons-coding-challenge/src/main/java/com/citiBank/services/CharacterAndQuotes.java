package com.citiBank.services;

import com.citiBank.model.CharacterAndPhrases;
import com.citiBank.model.Characters;
import com.citiBank.model.Datum;
import com.citiBank.model.DatumPhrases;
import com.citiBank.model.Phrases;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterAndQuotes {

	private List<CharacterAndPhrases> users;
	String phrases1;

	//
	public List<CharacterAndPhrases> findByFirstNameOrLastNameOrAgeOrPhrase(String firstName, String lastName, int age,
			String phrase) {
		System.out.println("findByFirstNameOrLastNameOrAgeOrPhrase "+users.size()+firstName+" "+lastName+" "+age+" "+phrase );
/*
 * List<CharacterAndPhrases> result = users.stream()
				.filter(x -> (x.getFirstName()!= null || x.getFirstName().equalsIgnoreCase(firstName)) && (x.getFirstName()!= null || x.getLastName().equalsIgnoreCase(lastName)) &&
						( x.getAge() != 0 || x.getAge() == age) && (x.getPhrase()!= null  || x.getPhrase().equalsIgnoreCase(phrase)))
				.collect(Collectors.toList());
 */
		List<CharacterAndPhrases> result = users.stream()
				.filter(x -> x.getFirstName().equalsIgnoreCase(firstName) || x.getLastName().equalsIgnoreCase(lastName)
						|| x.getAge() == age || x.getPhrase().equalsIgnoreCase(phrase))
				.collect(Collectors.toList());
		System.out.println("findByFirstNameOrLastNameOrAgeOrPhrase "+result.size());
		return result;

	}

	// Init some users for testing
	@PostConstruct
    private void iniDataForTesting() {
    	users = new ArrayList<CharacterAndPhrases>();
    	CharacterAndPhrases characterAndPhrases;
    	JSONParser jsonParser = new JSONParser();
    	 //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //JSON parser object to parse read file
    	try {
			File characterReaderFile = new ClassPathResource("data/characters.json").getFile();
			File phrasesReaderFile = new ClassPathResource("data/phrases.json").getFile();
			       
	        //read json file and convert to customer object
	        Characters characters = objectMapper.readValue(characterReaderFile, Characters.class);
	        Phrases phrases = objectMapper.readValue(phrasesReaderFile, Phrases.class);
          
	  
      	if(!characters.getData().isEmpty()) {
      		for (Datum datumTemp : characters.getData()) {
      			for (DatumPhrases datumPhrasesTemp : phrases.getData()) {
      				if (datumTemp.getId().equalsIgnoreCase(datumPhrasesTemp.getCharacter())) {
      					characterAndPhrases = new CharacterAndPhrases(datumTemp.getId(),datumTemp.getFirstName(),datumTemp.getLastName(),datumTemp.getPicture(), datumTemp.getAge(),datumPhrasesTemp.getCharacter(),datumPhrasesTemp.getPhrase());
               	        users.add(characterAndPhrases);
               	        System.out.println(users.size());
      				}
      			}
			}
       
      	}
    	} catch (IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
         

	
}
