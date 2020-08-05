package ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * Created by mwu on 2020/8/4
 */
public class Tess4jDemo {

    public static String ocrEnglish(String picPath) {
        if (!checkPicPath(picPath)) {
            throw new RuntimeException("Wrong picture path:" + picPath);
        }

        File picture = new File(picPath);
        ITesseract instance = new Tesseract();
        instance.setDatapath("D:\\IdeaCode\\JavaStarter\\tessdata");
        instance.setLanguage("eng");
        String result = "";
        try {
            result = instance.doOCR(picture);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean checkPicPath(String picPath) {
        File file = new File(picPath);
        if (!file.exists()) return false;
        return file.isFile();
    }
}
