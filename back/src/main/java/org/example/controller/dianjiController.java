package org.example.controller;

import org.example.mapper.dianjiMapper;
import org.example.pojo.dianji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*","null"})
public class dianjiController {
    @Autowired
    dianjiMapper dianjimapper;

    @PostMapping("/setDainji")
    public Boolean setDianji(@RequestBody dianji dianjiin){
        if(dianjimapper.Issaved(dianjiin)>0){
            dianji savedDianji=dianjimapper.getDianji(dianjiin);
            dianjiin.setClicknum(savedDianji.getClicknum()+1);
            int res=dianjimapper.updateNum(dianjiin);
            if(res>0){
                return true;
            }else {
                return false;
            }
        }else {
            int res=dianjimapper.Add(dianjiin);
            if(res>0){
                return true;
            }else {
                return false;
            }
        }
    }
}
