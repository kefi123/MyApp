//package xhj.love.tyj.util;
//
//import com.alibaba.druid.util.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * @author 徐浩军 xhj X6241
// * @date 2020/12/7 9:34
// * @description 文件读写工具类
// */
//public class FileUtil {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
//
//    /**
//     * 读取文件中的信息
//     *
//     * @param absoluteFilePath 文件的绝对路径
//     * @return 文件内容
//     */
//    public static List<String> readFile(String absoluteFilePath) {
//        if (StringUtils.isEmpty(absoluteFilePath)) {
//            LOGGER.error("【文件读写】 absoluteFilePath（文件的绝对路径） 不能为空");
//            return Collections.emptyList();
//        } else {
//            File file = new File(absoluteFilePath);
//            //利用java 8 特性自动关闭文件流
//            try (
//                 //文件输入字符流
//                 FileReader fileReader = new FileReader(file);
//                 //自带缓冲区，可以按行读取
//                 BufferedReader bufferedReader = new BufferedReader(fileReader)
//            ) {
//                //逐行读取文件
//                List<String> listStr = new ArrayList<>();
//                String str;
//                while((str = bufferedReader.readLine()) != null) {
//                    listStr.add(str);
//                }
//                return listStr;
//            } catch (IOException e) {
//                LOGGER.error("【文件读写】 异常：{}", e.getMessage());
//                return Collections.emptyList();
//            }
//        }
//    }
//
//    /**
//     * 把信息写入文件
//     *
//     * @param absoluteFilePath 文件的绝对路径
//     * @param content 要写入的内容
//     * @param append true:追加，false:覆盖
//     */
//    public static void writeFile(String absoluteFilePath, String content, boolean append) {
//        if (StringUtils.isEmpty(absoluteFilePath) || StringUtils.isEmpty(content)) {
//            LOGGER.error("【文件读写】 absoluteFilePath（文件的绝对路径）、content（要写入的内容） 不能为空");
//        } else {
//            File file = new File(absoluteFilePath);
//            //利用java 8 特性自动关闭文件流
//            try (
//                    //文件输出字符流
//                    FileWriter fileWriter = new FileWriter(file, append);
//                    //自带缓冲区，可按行写入字符
//                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
//            ) {
//                //把内容写入文件
//                bufferedWriter.write(content);
//            } catch (IOException e) {
//                LOGGER.error("【文件读写】 异常：{}", e.getMessage());
//            }
//        }
//    }
//
//}
