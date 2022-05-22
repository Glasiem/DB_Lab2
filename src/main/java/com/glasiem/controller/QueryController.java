package com.glasiem.controller;

import com.glasiem.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class QueryController {

    @Autowired
    QueryService queryService;

    @RequestMapping("/query")
    String getQuery(Model model){
        return "/queries/query";
    }

    @PostMapping("/query1")
    String getQuery1(@Valid String contents, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("query1", queryService.solveQuery1(contents));
        return "redirect:" + referer;
    }

    @PostMapping("/query2")
    String getQuery2(@Valid String contents, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("query2", queryService.solveQuery2(contents));
        return "redirect:" + referer;
    }

    @PostMapping("/query3")
    String getQuery3(@Valid String contents, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("query3", queryService.solveQuery3(contents));
        return "redirect:" + referer;
    }

    @PostMapping("/query4")
    String getQuery4(@Valid Integer contents, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("query4", queryService.solveQuery4(contents));
        return "redirect:" + referer;
    }

    @PostMapping("/query5")
    String getQuery5(@Valid String contents, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("query5", queryService.solveQuery5(contents));
        return "redirect:" + referer;
    }

    @PostMapping("/query6")
    String getQuery6(@Valid String contents, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("query6", queryService.solveQuery6(contents));
        return "redirect:" + referer;
    }

    @PostMapping("/query7")
    String getQuery7(@Valid String contents, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("query7", queryService.solveQuery7(contents));
        return "redirect:" + referer;
    }

    @PostMapping("/query8")
    String getQuery8(@Valid String contents, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        String referer = request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("query8", queryService.solveQuery8(contents));
        return "redirect:" + referer;
    }
}
