package com.example.Consumer;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
public class WidgetController {

@RequestMapping(path = "/widgets", method = RequestMethod.GET)
    public String showWidget(Model model){

    RestTemplate restTemplate = new RestTemplate();
    ArrayList<Widget> widgets = restTemplate.getForObject("http://localhost:9090/api/v1/widgets", ArrayList.class);
    System.out.println(widgets);
    model.addAttribute("widgets", widgets);
    return "widget";

}

}
