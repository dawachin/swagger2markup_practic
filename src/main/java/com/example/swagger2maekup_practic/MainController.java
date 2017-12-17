package com.example.swagger2maekup_practic;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {


    @GetMapping(value = "schedule")
    public String getSchedule() {
        return "明日は朝１０時から会議です。";
    }

    @GetMapping(value = "schedule/{baseDate}")
    public String getScheduleByDate(@PathVariable String baseDate) {
        return baseDate + "のスケジュールはありません。";
    }

    @PostMapping(value = "member/add")
    public String postMember(@RequestBody Member member) {
        return member.getName() + "さんの登録を受け付けました。";
    }


}
