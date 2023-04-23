package com.techacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObjController {

    @GetMapping("/obj")
    public String getObj(Model model) {
        // Memberクラスのオブジェクトを作成
        Member member = new Member(1,"taro","男性",27);
        // オブジェクトをModelに登録
        model.addAttribute("member", member);
        // obj.htmlに画面遷移
        return "obj";
    }
}