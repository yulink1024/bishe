package org.example.controller;

import org.example.mapper.gouwucheMapper;
import org.example.pojo.gouwuche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class gouwucheController {
    @Autowired
    private gouwucheMapper gouwuchemapper;

    @PostMapping("/GetGouwucheByUid")
    public List<gouwuche> GetGouwucheByUid(@RequestBody gouwuche gouwuchein){
        List<gouwuche> gouwuches=gouwuchemapper.GetByUid(gouwuchein.getUid());
        return gouwuches;
    }

    @PostMapping("/AddGouwuche")
    public Boolean AddGouwuche(@RequestBody gouwuche gouwuchein){
        int res=gouwuchemapper.Add(gouwuchein);
        if (res>0){
            return true;
        }
        else{
            return false;
        }
    }

    @PostMapping("/DeleteGouwu")
    public Boolean DeleteGouwu(@RequestBody gouwuche gouwuchein){
        int res=gouwuchemapper.DeleteByid(gouwuchein.getId());
        if (res>0){
            return true;
        }
        else{
            return false;
        }
    }
}
