package com.citiBank.controller;

import com.citiBank.model.AjaxResponseBody;
import com.citiBank.model.SearchCriteria;
import com.citiBank.model.CharacterAndPhrases;
import com.citiBank.services.CharacterAndQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    CharacterAndQuotes userService;

    @Autowired
    public void setUserService(CharacterAndQuotes userService) {
        this.userService = userService;
    }

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }
System.out.println(search.getFirstName()+" "+search.getLastName()+" "+search.getAge()+" "+search.getPhrase());
        List<CharacterAndPhrases> users = userService.findByFirstNameOrLastNameOrAgeOrPhrase(search.getFirstName(),search.getLastName(),search.getAge(),search.getPhrase());
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);

    }

}
