package fileRelated;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhang on 1/2/2016.
 */
public class ImageUtil {


    public static boolean deleteImg(String ImgPath){
        File file = new File(ImgPath);
        return file.exists()&&file.delete();
    }

    /**
     * 通过图片的路径 获得图片内容
     * @param ImgPath
     * @return 图片的byte[]
     */
    public static byte[] readFromImg(String ImgPath){
        System.out.println(ImgPath);
        InputStream imgStream = null;
        byte[] picContent = null;
        try {
            File file = new File(ImgPath);
            if (!file.exists()) {
                System.out.println("!file.exists() send read null");
                return null;
            }
            imgStream = new FileInputStream(file);
            picContent = new byte[imgStream.available()];
            imgStream.read(picContent);
            System.out.println("开始处理文件");
            imgStream.close();
            deleteImg(ImgPath);
            return picContent;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<String> GetImgPic(String newsContent){
        ArrayList<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile("\\/upload/images/.*?\\\"");
        Matcher m = p.matcher(newsContent);
        while (m.find()) {// 遍历找到的所有大括号
            String param = m.group().replaceAll("\"", "");;
            list.add(param);
        }
        if (list.size() == 0) {
            return null;
        }else {
            return list;
        }
    }
}
