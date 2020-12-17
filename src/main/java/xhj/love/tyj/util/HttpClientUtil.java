//package xhj.love.tyj.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.nebula.hz.entity.Response;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.util.Map;
//import java.util.Set;
//
///**
// * @author 徐浩军 xhj X6241
// * @date 2020/11/2 15:45
// * @description
// */
//@Component
//public class HttpClientUtil {
//    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);
//
//    /**
//     * 下载文件
//     *
//     * @param httpServletResponse 请求响应
//     * @param path 访问路径
//     * @param headers 头部信息
//     * @param params 参数
//     */
//    public void download(HttpServletResponse httpServletResponse, String path, Map<String, String> headers, Map<String, String> params){
//        //对path进行校验
//        if(StringUtils.isEmpty(path)) {
//            throw new NullPointerException("path不能为空");
//        }
//
//        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            //设置请求路径
//            URIBuilder uriBuilder = new URIBuilder(path);
//
//            //设置参数
//            if(params != null && !params.isEmpty()) {
//                Set<String> paramKeys = params.keySet();
//                for (String paramKey : paramKeys) {
//                    uriBuilder.setParameter(paramKey, params.get(paramKey));
//                }
//            }
//
//            //创建get请求
//            HttpGet get = new HttpGet(uriBuilder.build());
//
//            //设置头部信息
//            if(headers != null && !headers.isEmpty()) {
//                Set<String> headerKeys = headers.keySet();
//                for (String headerKey : headerKeys) {
//                    get.setHeader(headerKey, headers.get(headerKey));
//                }
//            }
//
//            //执行请求
//            HttpResponse response = httpClient.execute(get);
//
//            //解码后获取文件名称
//            String fileName = response.getFirstHeader("fileName").getValue();
//            fileName = URLDecoder.decode(fileName, "UTF-8");
//
//            //拿到文件的字节流
//            InputStream content = response.getEntity().getContent();
//
//            //写入请求响应里
//            file2response(httpServletResponse, fileName, content);
//        } catch (Exception e) {
//            LOGGER.error("请求发生异常：{}", e.getMessage());
//        }
//    }
//
//    /**
//     * 把文件流写入响应里
//     *
//     * @param response 响应
//     * @param fileName 文件名
//     * @param content 文件的字节流
//     */
//    private void file2response(HttpServletResponse response, String fileName, InputStream content){
//        //采用循环写入响应的方式，实现下载
//        byte[] buffer = new byte[1024];
//        BufferedInputStream bufferedInputStream = null;
//        try {
//            //强制下载
//            response.setContentType("application/force-download");
//
//            //这里一定要对文件名设置编码
//            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//            bufferedInputStream = new BufferedInputStream(content);
//
//            //获取响应的输出流
//            OutputStream outputStream = response.getOutputStream();
//            int i = bufferedInputStream.read(buffer);
//            while(i != -1) {
//                outputStream.write(buffer, 0, i);
//                i = bufferedInputStream.read(buffer);
//            }
//        } catch (FileNotFoundException e) {
//            LOGGER.error("没有找到该文件");
//        } catch (IOException e) {
//            LOGGER.error("发生读写错误");
//        } finally {
//            try {
//                if(bufferedInputStream != null) {
//                    bufferedInputStream.close();
//                }
//            } catch (IOException e) {
//                LOGGER.error("关闭文件流的时候发生异常");
//            }
//        }
//    }
//
//    /**
//     * 发送get请求
//     *  @param path 访问路径
//     * @param headers 头部信息
//     * @param params 参数
//     * @return
//     */
//    public Object get(String path, Map<String, String> headers, Map<String, String> params){
//        //对path进行校验
//        if(StringUtils.isEmpty(path)) {
//            throw new NullPointerException("path不能为空");
//        }
//
//        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            //设置请求路径
//            URIBuilder uriBuilder = new URIBuilder(path);
//
//            //设置参数
//            if(params != null && !params.isEmpty()) {
//                Set<String> paramKeys = params.keySet();
//                for (String paramKey : paramKeys) {
//                    uriBuilder.setParameter(paramKey, params.get(paramKey));
//                }
//            }
//
//            //创建get请求
//            HttpGet get = new HttpGet(uriBuilder.build());
//
//            //设置头部信息
//            if(headers != null && !headers.isEmpty()) {
//                Set<String> headerKeys = headers.keySet();
//                for (String headerKey : headerKeys) {
//                    get.setHeader(headerKey, headers.get(headerKey));
//                }
//            }
//
//            //执行请求
//            HttpResponse response = httpClient.execute(get);
//
//            //获取到请求的结果
//            String responseStr = EntityUtils.toString(response.getEntity(), "UTF-8");
//            return JSONObject.parse(responseStr);
//        } catch (Exception e) {
//            LOGGER.error("请求发生异常：{}", e.getMessage());
//            return null;
//        }
//    }
//
//    /**
//     * 发送post请求
//     *  @param path 访问路径
//     * @param headers 头部信息
//     * @param params 参数
//     * @return
//     */
//    public Object post(String path, Map<String, String> headers, Map<String, String> params){
//        //对path进行校验
//        if(StringUtils.isEmpty(path)) {
//            throw new NullPointerException("path不能为空");
//        }
//
//        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            //设置请求路径
//            URIBuilder uriBuilder = new URIBuilder(path);
//
//            //设置参数
//            if(params != null && !params.isEmpty()) {
//                Set<String> paramKeys = params.keySet();
//                for (String paramKey : paramKeys) {
//                    uriBuilder.setParameter(paramKey, params.get(paramKey));
//                }
//            }
//
//            //创建post请求
//            HttpPost post = new HttpPost(uriBuilder.build());
//
//            //设置头部信息
//            if(headers != null && !headers.isEmpty()) {
//                Set<String> headerKeys = headers.keySet();
//                for (String headerKey : headerKeys) {
//                    post.setHeader(headerKey, headers.get(headerKey));
//                }
//            }
//
//            //执行请求
//            HttpResponse response = httpClient.execute(post);
//
//            //获取到请求的结果
//            String responseStr = EntityUtils.toString(response.getEntity(), "UTF-8");
//            return JSONObject.parse(responseStr);
//        } catch (Exception e) {
//            LOGGER.error("请求发生异常：{}", e.getMessage());
//            return null;
//        }
//    }
//
//    /**
//     * 发送post请求(application/json)
//     *  @param path 访问路径
//     * @param headers 头部信息
//     * @param params 参数
//     * @return
//     */
//    public Object postJson(String path, Map<String, String> headers, Map<String, Object> params){
//        //对path进行校验
//        if(StringUtils.isEmpty(path)) {
//            throw new NullPointerException("path不能为空");
//        }
//
//        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            //创建post请求
//            HttpPost post = new HttpPost(path);
//
//            //设置参数
//            String parmasJson = JSON.toJSONString(params);
//            StringEntity stringEntity = new StringEntity(parmasJson, "utf-8");
//            post.setEntity(stringEntity);
//
//            //设置头部信息
//            post.setHeader("Content-Type", "application/json");
//            if(headers != null && !headers.isEmpty()) {
//                Set<String> headerKeys = headers.keySet();
//                for (String headerKey : headerKeys) {
//                    post.setHeader(headerKey, headers.get(headerKey));
//                }
//            }
//
//            //执行请求
//            HttpResponse response = httpClient.execute(post);
//
//            //获取到请求的结果
//            String responseStr = EntityUtils.toString(response.getEntity(), "UTF-8");
//            return JSONObject.parse(responseStr);
//        } catch (Exception e) {
//            LOGGER.error("请求发生异常：{}", e.getMessage());
//            Response error = new Response(1, e.getMessage(), "【hzds】请求时发生异常");
//            return JSONObject.toJSON(error);
//        }
//    }
//}
