package com.lcw.exerciseback.domain.dpo;

import lombok.Data;

/**
 * @Author Licanwei
 * @Description:
 * @Date 2022/5/1 18:47
 */
@Data
public class TestAdd {
    String testID;
    String testName;
    Integer testType;
    Integer testLevel;
    Integer maxTime;
    String teacherID;
}
