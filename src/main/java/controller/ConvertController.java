package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ConvertService;

@Controller
@RequestMapping("/convert")
public class ConvertController {
    ConvertService convertService = new ConvertService();
    @GetMapping("")
    public ModelAndView showConvert(){
        ModelAndView modelAndView = new ModelAndView("display");
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView convert(@RequestParam Double input, Double rate){
        ModelAndView modelAndView = new ModelAndView("display");
        Double result = convertService.convertMoney(input,rate);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
