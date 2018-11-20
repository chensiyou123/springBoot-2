package com.csy.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/session")
public class SessionController {
    private static final String STR_SESSION_KEY = "name";
    @RequestMapping(value = "/setSession",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> setSession(String value, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute(STR_SESSION_KEY, value);
        map.put("msg", "ok");
        return map;
    }

    @RequestMapping(value = "/getSession",method = RequestMethod.POST)
    @ResponseBody
    public  Map<String, Object> getSession(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        HttpSession session = request.getSession();
        Object value = session.getAttribute(STR_SESSION_KEY);
        map.put("value", value);
        map.put("id", session.getId());
        map.put("port", request.getLocalPort());
        map.put("msg", "ok");
        return map;
    }
}
