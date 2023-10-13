package com.lcw.exerciseback.domain.dpo;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/5/8 18:30
 */
@Data
public class UpdateStuGrade {
    Integer residueHeavyBatchNumber;
    String studentID;
    Integer testsID;
    Integer totalScore;
}
