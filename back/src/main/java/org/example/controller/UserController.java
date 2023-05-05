package org.example.controller;

import com.google.gson.Gson;
import org.example.mapper.GoodsMapper;
import org.example.mapper.UserMapper;
import org.example.pojo.RegisterUser;
import org.example.pojo.userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class UserController {
    @Autowired
    private UserMapper userMapper;
    private Gson gson=new Gson();

    @GetMapping("/user")
    public String getUser(){
        List<userinfo> userinfos =userMapper.GetAll();
        return gson.toJson(userinfos);
    }

    @PostMapping("/Register")//注册
    public boolean UserRegister(@RequestBody RegisterUser registerUser){
        int res=userMapper.add(registerUser);
        if(res>0){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/Login")//登陆
    public boolean Login(@RequestBody RegisterUser registerUser){
        userinfo res=userMapper.SelectByNum(registerUser.getUserNumber());
        if(res != null) {
            if (res.getUserPassword().equals(registerUser.getUserPassword())) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    @PostMapping("/set")//初始化用户信息
    public userinfo Setuserinfo(@RequestBody RegisterUser registerUser){
        userinfo res=userMapper.SelectByNum(registerUser.getUserNumber());
        System.out.println(res);
        return res;
    }

    @PostMapping("/updateus")//用户信息更新
    public String UpdateUser(@RequestBody userinfo userinfoo) {
        if (userinfoo.getAge() > 0 && userinfoo.getAge() < 100) {
            int res = userMapper.upDate(userinfoo);
            if (res > 0) {
                return "success";
            } else {
                return "error";
            }
        } else {
            System.out.println(userinfoo.getAge());
            return "ageError";
        }
    }

    @PostMapping("/delete")//用户注销
    public String DelUserByID(long id){
        int res=userMapper.deleteByID(id);
        if(res>0){
            return "信息删除成功";
        }else{
            return "信息删除失败";
        }
    }

    @PostMapping("/updateIsNew")//修改新用户
    public boolean UpdateIsNew(@RequestBody userinfo userinfoo){
        int res=userMapper.updateIsNew(userinfoo);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }
}
