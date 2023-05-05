package org.example.controller;

import org.example.mapper.dingdanMapper;
import org.example.pojo.dingdan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class dingdanController {
    @Autowired
    dingdanMapper dingdanmapper;

    @PostMapping("/AddDingdan")
    public boolean AddDingdan(@RequestBody dingdan dingdanin){
        int res=dingdanmapper.Add(dingdanin);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/GetDingdan")
    public List<dingdan> GetDingdan(@RequestBody dingdan dingdanin){
        List<dingdan> dingdans=dingdanmapper.SelectByuid(dingdanin.getUid());
        return dingdans;
    }
}
