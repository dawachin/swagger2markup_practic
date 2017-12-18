package com.example.swagger2maekup_practic;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Member {

    @Getter
    @ApiModelProperty(value = "名前  " +
            "メンバーの名前。性と名の間に一文字文の空白を入力してください。")
    private String name;

    @Getter
    @ApiModelProperty(value = "年齢")
    private String age;

    @Getter
    @ApiModelProperty(value = "一意のID\n" +
            "いいいいいいいいいいいいいいい\n" +
            "いいいいいいいいいいいいいいい\n" +
            "・ test\n" +
            "・ test\n")
    private String id;

}
