package org.example.controller;

import org.example.mapper.interestListMapper;
import org.example.pojo.interestList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class interestListController {

    @Autowired
    private interestListMapper interestlistMapper;

    @GetMapping("/getInsterstList")
    public List<interestList> GetIntere(){
        List<interestList> interestLists=interestlistMapper.SelectRanSix();
        return interestLists;
    }
}
