package annotation.request;

import annotation.request.base.ClientRequestMapping;
import annotation.request.message.MessageLite;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by mwu on 2020/8/5
 */
public class RequestMappingFactory {

    public static Map<Class<? extends MessageLite>, Method> generateClientRequestMapping(
            String packageName, Class<? extends Annotation> annotation) {
        HashMap<Class<? extends MessageLite>, Method> methodAnnotation = new HashMap<>();

        // 将包名替换成文件路径
        String packageDirName = packageName.replace(".", File.separator);
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {
                // 获取下一个url
                URL url = dirs.nextElement();
                // 获取协议类型
                String protocol = url.getProtocol();
                switch (protocol.trim()) {
                    case "file":
                        String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                        File dir = new File(filePath);
                        ArrayList<File> fileList = new ArrayList<>();
                        fetchFileList(dir, fileList);

                        fileList.forEach(file -> {
                                    String fileAbsPath = file.getAbsolutePath();
                                    if (fileAbsPath.endsWith(".class")) {
                                        String noSuffixFileName = fileAbsPath.substring(8 + fileAbsPath.lastIndexOf("classes"), fileAbsPath.indexOf(".class"));
                                        String filePackage = noSuffixFileName.replace(File.separator, ".");
                                        try {
                                            Class<?> clazz = Class.forName(filePackage);
                                            Method[] methods = clazz.getDeclaredMethods();
                                            Arrays.stream(methods).forEach(method ->
                                                    Arrays.stream(method.getAnnotations()).forEach(anno -> {
                                                        if (annotation.isInstance(anno)) {
                                                            methodAnnotation.put(((ClientRequestMapping) anno).value(), method);
                                                        }
                                                    }));

                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                        );
                        break;
                    case "jar":
                        System.out.println("暂时不支持！");
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return methodAnnotation;
    }

    private static void fetchFileList(File dir, ArrayList<File> fileList) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file ->
                        fetchFileList(file, fileList)
                );
            }
        } else {
            fileList.add(dir);
        }
    }
}
