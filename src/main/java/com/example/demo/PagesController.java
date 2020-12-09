package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PagesController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/math/pi")
    public double mathPI() {
        return 3.141592653589793;
    }

    @GetMapping("/math/calculate")
    public String calculate(@RequestParam int x, @RequestParam int y,
                            @RequestParam(defaultValue = "add") String ops) {
        String answer = "";

        if (ops.equalsIgnoreCase("add")) {
            return answer = String.format("%s + %s = %s", x, y, (x + y));
        } else if (ops.equalsIgnoreCase("multiply")) {
            return answer = String.format("%s * %s = %s", x, y, (x * y));
        } else if (ops.equalsIgnoreCase("subtract")) {
            return answer = String.format("%s - %s = %s", x, y, (x - y));
        } else if (ops.equalsIgnoreCase("divide")) {
            return answer = String.format("%s / %s = %s", x, y, (x / y));
        }
        return "INVALID Input";
    }

    @PostMapping("/math/sum")
    public String sumParams(@RequestParam Integer[] n){
        int sum = 0;
        List<String> listNums = new ArrayList<>();

        for(int i = 0; i < n.length; i++){
            sum += n[i];
            listNums.add(String.valueOf(n[i]));
        }
        return String.join(" + ", listNums) + " = " + sum;
    }

    @RequestMapping("math/volume/{num1}/{num2}/{num3}")
    public String getVolume(@PathVariable int num1, @PathVariable int num2, @PathVariable int num3){
        int vol = num1 * num2 * num3;
        return String.format("The volume of a %dx%dx%d rectangle is %d", num1, num2, num3, vol);
    }

}