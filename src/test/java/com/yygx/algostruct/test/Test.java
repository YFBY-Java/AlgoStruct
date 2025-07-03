package com.yygx.algostruct.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        try(
                FileWriter fileWriter = new FileWriter("D:\\JavaProject\\AlgoStruct\\src\\test\\java\\com\\yygx\\algostruct\\test\\test.txt",true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ){
            bufferedWriter.write('a');
            bufferedWriter.write(97);
            bufferedWriter.write('磊');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}