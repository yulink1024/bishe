package org.example.controller;

import org.example.mapper.beMapper;
import org.example.pojo.groupby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class beController {
    @Autowired
    beMapper bemapper;

    @GetMapping("/GetNum")
    public List<groupby> GetNum(){
        List<groupby> res1=bemapper.GetNum("pv");
        List<groupby> res2=bemapper.GetNum("buy");
        List<groupby> res3=bemapper.GetNum("cart");
        List<groupby> res4=bemapper.GetNum("fav");
        List<groupby> total=bemapper.GetNumbe("fav");
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(res3);
//        System.out.println(res4);

        double num1=bemapper.GetNumber("pv");
        double num2=bemapper.GetNumber("buy");
        double num3=bemapper.GetNumber("cart");

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num1/num2);
        System.out.println(num1/num3);

        return total;
    }
}
