package com.tobias.util;


/**
 * 用于临时编译类文件，查看jvm字节码
 */
public class TempClass {

  public static void main(String[] args) {
    int a = 10;
    Integer b = a;
    int c = b;

  }
}
