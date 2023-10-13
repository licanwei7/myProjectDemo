package com.lcw.exerciseback;

import com.lcw.exerciseback.domain.query.ShowPartChoiceQuestionQuery;
import com.lcw.exerciseback.mapper.students.BrushQuestionMapper;
import com.lcw.exerciseback.mapper.students.SHomeMapper;
import com.lcw.exerciseback.service.students.SHomeService;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class ExerciseBackApplicationTests {

    @Autowired
    private SHomeService SHomeService;
    @Autowired
    private SHomeMapper SHomeMapper;
    @Autowired
    private BrushQuestionMapper brushQuestionMapper;

    @Test
    void contextLoads1() throws FileNotFoundException {//图片上传Test

        if (SHomeService.upPhoto(new File("C:/Users/Lenovo/Desktop/fa8421a964f633e117002ca0188cf98.jpg"))){
            System.out.println("插入成功！");
            return;
        }
        System.out.println("插入失败！");
    }
    @Test
    void contextLoads2() {
        String str = "0=A&1=B&2=B&3=B&4=C&5=D&6=C&7=B&8=A&9=D&10=A&11=B";
        List list = new ArrayList();
        for (int i =0;i<str.length();i++){
            char item = str.charAt(i);
            if (item=='A'||item=='B'||item=='C'||item=='D'||item=='a'||item=='b'||item=='c'||item=='d'){
                list.add(item);
            }
        }



        System.out.println(list);

        System.out.println(list instanceof List);
        System.out.println("-------------------------------------");
        String str2 = list.toString();
        System.out.println(str2 instanceof String);
        System.out.println("又转成了字符串的格式是："+str2);
    }

    @Test
    void contextLoads3(){
        char chr = 'A';
        String str = "A";

        System.out.println(str.equals(Character.toString(chr)));
    }

    @Test
    void contextLoads4(){
        System.out.println(Math.round(100*(20/100)));
    }
}
