package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream obj1;
    AdapterFileOutputStream (FileOutputStream obj1){this.obj1 = obj1;}

    @Override
    public void flush() throws IOException {   this.obj1.flush(); }

    @Override
    public void writeString(String s) throws IOException {  this.obj1.write(s.getBytes());  }

    @Override
    public void close() throws IOException { this.obj1.close(); }

}

