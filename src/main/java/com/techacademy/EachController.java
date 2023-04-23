package com.techacademy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EachController {

    @GetMapping("/each")
    public String getEach(Model model) {
        // MemberオブジェクトをArrayListに格納
        List<Member> member = new ArrayList<>();
        member.add(new Member(1,"taro","男性",27));
        member.add(new Member(2,"jiro","男性",22));
        member.add(new Member(3,"hanako","女性",25));
        // memberをModelに登録
        model.addAttribute("obj", member);
        // each.htmlに画面遷移
        return "each";
    }
}
