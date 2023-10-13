package com.lcw.exerciseback.domain.dto;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description: 成绩分布人数类
 * @Date 2022/4/23 19:33
 */
@Data
public class GradesSituation {
    /**
     * 低于50分的
     */
    private Integer lowFiftyNum;

    /**
     * 50-60分的
     */
    private Integer fiftyAndSixtyNum;

    /**
     * 60-70分的
     */
    private Integer sixtyAndSeventyNum;

    /**
     * 70-80分的
     */
    private Integer seventyAndEightyNum;

    /**
     * 80-90分的
     */
    private Integer EightyAndNinetyNum;

    /**
     * 90-100分的
     */
    private Integer ninetyAndHundredNum;
}
