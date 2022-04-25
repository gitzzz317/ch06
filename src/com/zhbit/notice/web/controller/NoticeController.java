package com.zhbit.notice.web.controller;

import com.zhbit.notice.biz.NoticeBiz;
import com.zhbit.notice.biz.TypeBiz;
import com.zhbit.notice.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    private NoticeBiz noticeBiz;
    @Autowired
    private TypeBiz typeBiz;
    @Autowired
    private Notice notice;
    @Autowired
    private Type type;

    //查询（通过类型id查询notice）
    @RequestMapping(value = "/getNoticeByTypeId" , method = RequestMethod.GET)
    public String getNoticeByTypeId( String  tno , Model model){
        int intTno = Integer.parseInt(tno);
        List<Notice> lists = noticeBiz.getNoticeByTypeId(intTno);
        model.addAttribute("lists",lists);
        return "page/portal/showNoticeByType";
    }
    //查询（通过id查询notice）
    @RequestMapping(value = "/getNoticeById" , method = RequestMethod.GET)
    public String showNoticeDetail(String  nno , Model model){
        int intNno = Integer.parseInt(nno);
        Notice notice = noticeBiz.getNoticeById(intNno);
        model.addAttribute("notice", notice);
        return "page/portal/showNoticeDetailByID";
    }
    //查询 所有通知公告列表
    @RequestMapping("/getAllNotice")
    public String getAllNotice(Model model){
        List<Notice> list = noticeBiz.getAllNotice();
        model.addAttribute("list", list);
        return "page/system/showAllNoticeList";
    }
    //查询  搜索功能(通过标题)
    @RequestMapping("/getNoticeByTitle")
    public String getNoticeByTitle(String search , Model model){
        List<Notice> list = noticeBiz.getNoticeByTitle(search);
        model.addAttribute("lists" , list);
        return "page/portal/showNoticeByType";
    }
    //查询 搜索功能(通过时间)
    @RequestMapping("/getNoticeByTime")
    public String getNoticeByTime(String startTime , String endTime , Model model){
        //设置默认类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String类型转Date类型
        Date sDate = null;
        try {
            sDate = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //利用Calendar 实现 Date日期+1天
        Calendar c = Calendar.getInstance();
        c.setTime(sDate);
        c.add(Calendar.DAY_OF_MONTH, 1);
        sDate = c.getTime();
        //将日期转成String类型 方便进入数据库比较
        endTime = sdf.format(sDate);
        List<Notice> list = noticeBiz.getNoticeByTime(startTime,endTime);
        model.addAttribute("lists", list);
        return "page/portal/showNoticeByType";
    }

    //查询 显示修改通知详情
    @RequestMapping("/getNoticeDetailForModify")
    public String getNoticeDetailForModify(String  noticeId , Model model){
        int intNoticeId = Integer.parseInt(noticeId);
        List<Type> typeList = typeBiz.getAllType();
        model.addAttribute("list", typeList);
        Notice notice = noticeBiz.getNoticeById(intNoticeId);
        model.addAttribute("notice", notice);
        return "page/system/noticeEdit";
    }

    //查询（通过id查询notice）
    @RequestMapping(value = "/getNoticeByTypeIdUpdate")
    public String getNoticeByTypeIdUpdate( String  nno , Model model){
        int intNno = Integer.parseInt(nno);
        Notice notice = noticeBiz.getNoticeById(intNno);
        List<Type> allType = typeBiz.getAllType();
        model.addAttribute("notice", notice);
        model.addAttribute("allType" , allType);
        return "page/system/noticeEdit";
    }
    //更改日志
    @RequestMapping("updateNotice")
    public String updateNotice(Notice notice , Model model , HttpSession session){
        notice.setNcreateTime(new java.sql.Date(new Date().getTime()));
        User user = (User) session.getAttribute("LOGINED_USER");
        notice.setUser(user);
        if (noticeBiz.updateNotice(notice)){
            List<Notice> list = noticeBiz.getAllNotice();
            model.addAttribute("list", list);
            return "page/system/showAllNoticeList";
        }else{
            return "page/system/error";
        }
    }
    //删除日志
    @RequestMapping("/deleteNotice")
    public String deleteNotice(String nno , Model model){
        int intNoticeId = Integer.parseInt(nno);
        if (noticeBiz.deleteNotice(intNoticeId)){
            List<Notice> list = noticeBiz.getAllNotice();
            model.addAttribute("list", list);
            return "page/system/showAllNoticeList";
        }else{
            return "page/system/error";
        }
    }
    //添加通知公告
    @RequestMapping("/getAddNotice")
    public String getAddNotice(Model model){
        List<Type> typeList = typeBiz.getAllType();
        model.addAttribute("list", typeList);
        return "page/system/noticeAdd";
    }

    //添加日志
    @RequestMapping("/addNotice")
    public String addNotice(Notice notice , Model model , HttpSession session){
        notice.setUser((User) session.getAttribute("LOGINED_USER"));
        notice.setNcreateTime(new java.sql.Date(new Date().getTime()));
        if (noticeBiz.addNotice(notice)){
            List<Notice> list = noticeBiz.getAllNotice();
            model.addAttribute("list", list);
            return "page/system/showAllNoticeList";
        }else{
             return "page/system/error";
        }
    }
}
