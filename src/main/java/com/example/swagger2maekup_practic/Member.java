package com.example.swagger2maekup_practic;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Member {

    @Getter
    @ApiModelProperty(value = "名前")
    private String name;

    @Getter
    @ApiModelProperty(value = "年齢")
    private String age;

    @Getter
    @ApiModelProperty(value = "一意のID")
    private String id;

}
