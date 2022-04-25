package com.zhbit.notice.web.controller;

import com.zhbit.notice.biz.TypeBiz;
import com.zhbit.notice.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    private TypeBiz typeBiz;
    @Autowired
    private Type type;

    //查询所有类型
    @RequestMapping("/getAllType")
    public String getAllType(Model model){
        List<Type> allType = typeBiz.getAllType();
        model.addAttribute("lists", allType);
        return "page/portal/index";
    }
    //查询所有类型
    @RequestMapping("/getAllTypeManagement")
    public String getAllTypeManagement(Model model){
        List<Type> allType = typeBiz.getAllType();
        model.addAttribute("lists", allType);
        return "page/system/typeManagement";
    }
    //添加类型
    @RequestMapping("/addType")
    public String addType(String type , Model model){
        typeBiz.addType(type);
        List<Type> allType = typeBiz.getAllType();
        model.addAttribute("lists", allType);
        return "page/system/typeManagement";
    }
    //修改类型
    @RequestMapping("/updateType")
    public String updateType(String Tno , String TtypeName , Model model){
        int tno = Integer.parseInt(Tno);
        type.setTno(tno);
        type.setTtypeName(TtypeName);
        typeBiz.updateType(type);
        List<Type> allType = typeBiz.getAllType();
        model.addAttribute("lists", allType);
        return "page/system/typeManagement";
    }
    //删除类型
    @RequestMapping("/deleteType")
    public String deleteType(String Tno , Model model){
        int tno = Integer.parseInt(Tno);
        typeBiz.deleteType(tno);
        List<Type> allType = typeBiz.getAllType();
        model.addAttribute("lists", allType);
        return "page/system/typeManagement";
    }
}
