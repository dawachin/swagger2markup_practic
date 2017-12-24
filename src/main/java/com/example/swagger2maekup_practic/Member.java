package com.example.swagger2maekup_practic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@ApiModel(value = "メンバー", description = "メンバーを管理するBeanです。")
public class Member {

    @Getter
    @ApiModelProperty(value = "名前  " +
            "メンバーの名前。性と名の間に一文字文の空白を入力してください。", position = 2)
    private String name;

    @Getter
    @ApiModelProperty(value = "年齢", position = 3)
    private String age;

    @Getter
    @ApiModelProperty(value = "一意のID", position = 1)
    private String id;

}
