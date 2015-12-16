package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.BmpReader;
import com.javarush.test.level16.lesson13.bonus01.common.JpgReader;
import com.javarush.test.level16.lesson13.bonus01.common.ImageReader;
import com.javarush.test.level16.lesson13.bonus01.common.ImageTypes;
import com.javarush.test.level16.lesson13.bonus01.common.PngReader;

/**
 * Created by Sergei.Sasinovich on 16.12.2015.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes imageTypes) {
        if (imageTypes == ImageTypes.BMP) return new BmpReader();
        else
        if (imageTypes == ImageTypes.JPG) return new JpgReader();
        else
        if (imageTypes == ImageTypes.PNG) return new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");

    }
}