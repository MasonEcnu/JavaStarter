package ocr;

/**
 * Created by mwu on 2020/8/4
 */
public class TestTess4jDemo {

    public static void main(String[] args) {
        String result = Tess4jDemo.ocrEnglish("D:\\bzzs.png");
        System.out.println(result);
    }
}
