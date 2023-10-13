package com.lcw.exerciseback.domain.dto;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description: 测试完成情况
 * @Date 2022/4/23 18:42
 */
@Data
public class TestSituation {
    /**
     * 完成人数
     */
    private Integer finishNum;

    /**
     * 未完成人数
     */
    private Integer unfinishNum;
}
