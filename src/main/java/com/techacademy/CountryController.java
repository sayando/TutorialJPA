package com.techacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("country")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

 // ----- 一覧画面 -----
    @GetMapping("/list")
    public String getList(Model model) {
        // 全件検索結果をModelに登録
        model.addAttribute("countrylist", service.getCountryList());
        // 「詳細」と「削除」へのリンクを追加
        model.addAttribute("detailUrl", "/country/detail");
        model.addAttribute("deleteUrl", "/country/delete");
        // country/list.htmlに画面遷移
        return "country/list";
    }

    // ----- 詳細画面 -----
    @GetMapping(value = { "/detail", "/detail/{code}/" })
    public String getCountry(@PathVariable(name = "code", required = false) String code, Model model) {
        // codeが指定されていたら検索結果、無ければ空のクラスを設定
        Country country = code != null ? service.getCountry(code) : new Country();
        // Modelに登録
        model.addAttribute("country", country);
        // 詳細画面から一覧画面に戻るリンクを追加
        model.addAttribute("backToListUrl", "/country/list");
        // country/detail.htmlに画面遷移
        return "country/detail";
    }

    // ----- 更新（追加） -----
    @PostMapping("/detail")
    public String postCountry(@RequestParam("code") String code, @RequestParam("name") String name,
            @RequestParam("population") int population, Model model) {
        // 更新（追加）
        service.updateCountry(code, name, population);

        // 一覧画面にリダイレクト
        return "redirect:/country/list";
    }

    // ----- 削除画面 -----
    @GetMapping("/delete")
    public String deleteCountryForm(@RequestParam(name = "code", required = false) String code, Model model) {
        // 削除対象の国コードをModelに登録
        model.addAttribute("countryCode", code);
        // 削除画面から一覧画面に戻るリンクを追加
        model.addAttribute("backToListUrl", "/country/list");
        // country/delete.htmlに画面遷移
        return "country/delete";
    }

    // ----- 削除 -----
    @PostMapping("/delete")
    public String deleteCountry(@RequestParam("code") String code, Model model) {
        // 削除
        service.deleteCountry(code);
        return code;

        // 一覧画面にリダイレクト
    }
}
