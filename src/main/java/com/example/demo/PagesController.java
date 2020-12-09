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
    public String calculate(MathService math){
        return math.doMath();
    }

    @PostMapping("/math/sum")
        public String sum(MathService math){
            return math.doSum();
        }

    @RequestMapping("math/volume/{num1}/{num2}/{num3}")
    public String getVolume(@PathVariable int num1, @PathVariable int num2, @PathVariable int num3){
        int vol = num1 * num2 * num3;
        return String.format("The volume of a %dx%dx%d rectangle is %d", num1, num2, num3, vol);
    }

    @PostMapping("/math/area")
    public String getArea(@RequestParam String type,
                          @RequestParam(defaultValue = "-1") int radius,
                          @RequestParam(defaultValue = "-1") int width,
                          @RequestParam(defaultValue = "-1") int height) {

        if(type.equalsIgnoreCase("circle")){
            if(radius == -1) return "Invalid";
            double areaCirc = Math.PI * Math.pow(radius, 2);
            return String.format("Area of a circle with a radius of %s is %.5f", radius, areaCirc);
        } else if (type.equalsIgnoreCase("rectangle")){
            if(height == -1 || width == -1) return "Invalid";
           int areaRec = width * height;
            return String.format("Area of a %dx%d rectangle is %d", width, height, areaRec);
        }

        return "I guess you don't want to find the area. Come back when you get your act together 🤡!!!";
    }

}