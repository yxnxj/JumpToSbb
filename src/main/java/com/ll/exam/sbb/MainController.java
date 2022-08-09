package com.ll.exam.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {
    private int i = 0;

    @RequestMapping("/sbb")
    // 아래 함수의 리턴값을 그대로 브라우저에 표시
    // 아래 함수의 리턴값을 문자열화 해서 브라우저 응답의 바디에 담는다.
    @ResponseBody
    public String index() {
        // 서버에서 출력
        System.out.println("Hello");
        // 먼 미래에 브라우저에서 보여짐
        return "안녕하세요!";
    }

    @GetMapping("/page1")
    @ResponseBody
    public String showPage1() {
        return """
                <form method="POST" action="/page2">
                    <input type="number" name="age" placeholder="나이" />
                    <input type="submit" value="page2로 POST 방식으로 이동" />
                </form>
                """;
    }

    @PostMapping("/page2")
    @ResponseBody
    public String showPage2Post(@RequestParam(defaultValue = "0") int age) {
        return """
                <h1>입력된 나이 : %d</h1>
                <h1>안녕하세요, POST 방식으로 오셨군요.</h1>
                """.formatted(age);
    }

    @GetMapping("/page2")
    @ResponseBody
    public String showPage2Get(@RequestParam(defaultValue = "0") int age) {
        return """
                <h1>입력된 나이 : %d</h1>
                <h1>안녕하세요, Get 방식으로 오셨군요.</h1>
                """.formatted(age);
    }

    @GetMapping("/plus")
    @ResponseBody
    public String doPlus(@RequestParam(defaultValue = "0") int a, @RequestParam int b) {
        return """
                <h1>%d + %d = %d</h1>
                """.formatted(a, b, a+b);
    }

    @GetMapping("/minus")
    @ResponseBody
    public String doMinus(@RequestParam(defaultValue = "0") int a, @RequestParam int b) {
        return """
                <h1>%d - %d = %d</h1>
                """.formatted(a, b, a-b);
    }


    @GetMapping("/increase")
    @ResponseBody
    public String doIncrease() {
        i++;

        return """
                <h1>increase : %d</h1>
                """.formatted(i);
    }

    @GetMapping("/gugudan")
    @ResponseBody
    public String gugudan(@RequestParam(defaultValue = "1") int num, @RequestParam(defaultValue = "9") int limit) {

        return IntStream.rangeClosed(1, limit)
                .mapToObj(i -> "%d x %d = %d".formatted(num, i, num * i))
                .collect(Collectors.joining("<br>\n"));

    }

    @GetMapping("/mbti")
    @ResponseBody
    public String getMbti(@RequestParam(defaultValue = "") String name) {
        switch(name){
            case "홍길동" : return "INFP";
            case "홍길순" : return "ENFP";
            case "임꺽정" : return "INFJ";
            case "본인" : return "INTJ";
            default : return "이름 입력";
        }
    }

    @GetMapping("/saveSession/{name}/{value}")
    @ResponseBody
    public String saveSession(@PathVariable String name, @PathVariable String value, HttpServletRequest req) {
        HttpSessgiion session = req.getSession();

        session.setAttribute(name, value);

        return "세션변수 %s의 값이 %s(으)로 설정되었습니다.".formatted(name, value);
    }

    @GetMapping("/getSession/{name}")
    @ResponseBody
    public String getSession(@PathVariable String name, HttpSession session) {
        String value = (String) session.getAttribute(name);

        return "세션변수 %s의 값이 %s 입니다.".formatted(name, value);
    }
}
