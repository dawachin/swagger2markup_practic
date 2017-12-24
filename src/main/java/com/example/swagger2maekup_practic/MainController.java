package com.example.swagger2maekup_practic;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {


    @ApiOperation(value = "最も近いスケジュールを一件返却します。",
                    notes = "実行された時間より、最も近いスケジュールを一件返却します。但し１年以上先の予定は返却しません。", position = 1)
    @GetMapping(value = "schedule")
    public String getSchedule() {
        return "明日は朝１０時から会議です。";
    }

    @ApiOperation(value = "指定された日付のスケジュールを返却します。",
    notes = "指定された日付のスケジュールを全件検索し返却します。日を跨いだスケジュールも返却します。" +
            "** 但し、開始・終了日時が設定されていない予定はTODOとして扱われ返却されます。", position = 2)
    @GetMapping(value = "schedule/{baseDate}")
    public String getScheduleByDate(@PathVariable String baseDate) {
        return baseDate + "のスケジュールはありません。";
    }

    @ApiOperation(value = "新しいメンバーを追加します。", position = 3)
    @PostMapping(value = "member/add")
    public String postMember(@RequestBody Member member) {
        return member.getName() + "さんの登録を受け付けました。";
    }


}
