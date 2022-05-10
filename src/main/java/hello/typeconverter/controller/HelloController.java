package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello-v2")
    public Integer convert(@RequestParam Integer data) {
        return data;
    }

    @GetMapping("/hello-v3")
    public IpPort convertIpPort(@RequestParam IpPort data) {
        return data;
    }
}
