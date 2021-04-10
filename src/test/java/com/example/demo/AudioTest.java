package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.DesUtil;
import com.example.demo.util.ImageCompressUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: mingyanliao
 * Date: 2019-04-23
 * Time: 下午4:24
 */
//@Slf4j
public class AudioTest {


    private final static Logger log = getLogger(AudioTest.class);
    @Test
    public void Test() throws Exception {
//        log.info(DesUtil.encode("13512256550"));
        //String params = "13512256550";
        String cemm = "Xy87kRBoav%2FVyOp4KaEr1tjD8KkaK782iNdvfZOhewZSb37w9ZPMx6ihJtzt5MB%2BkN4VJiIvbwXw%0AOVrxZ6irPw%3D%3D";
        log.info("解密cemm：" + DesUtil.decode(URLDecoder.decode(cemm, "utf-8")));
        //        log.info(DigestUtils.md5DigestAsHex(params.getBytes()).toUpperCase());
//        log.info(URLEncoder.encode(DesUtil.encode("13512920224")));
//        log.info(DesUtil.decode("H0yE01r0vWK8hj54JZoTwg=="));
//        log.info(DesUtil.decode("13512920224"));
//        log.info(URLEncoder.encode(DesUtil.encode("li_shunda")));
//        log.info(URLDecoder.decode("3UOeWJPPbEwewVNO3FG%2FgxLR39BYaJQO47R%2Fl9bGXetgJ5XQQYFcmzD6vuFHsnI2Qmfto2CY4%2F6s%0A%2FJ1OWQN%2FJw%3D%3D","utf-8"));
//        log.info(DesUtil.decode(URLDecoder.decode("3UOeWJPPbEwewVNO3FG%2FgxLR39BYaJQO47R%2Fl9bGXetgJ5XQQYFcmzD6vuFHsnI2Qmfto2CY4%2F6s%0A%2FJ1OWQN%2FJw%3D%3D","utf-8")));
//       String shiLi = "phoneNum=13512920224&staffName=李顺达&accessSource=CRM";
        String shiLi = "phoneNum=13298332107&staffName=天津&staffId=xxxxx&accessSource=xxxxxx&bossId=AVYA0019&staffGroup=集团政企&groupId=31064&area=12312";
        log.info("加密后shiLi：" + URLEncoder.encode(DesUtil.encode(shiLi), "utf-8"));
        String sh = "phoneNum=13672095558&staffId=AYVA0123&accessSource=weixin";
        log.info("加密后weixin：" + URLEncoder.encode(DesUtil.encode(sh), "utf-8"));
        String ss = "phoneNum=13702088850&staffName=冀静&accessSource=CRM";
        log.info("加密后000：" + DesUtil.encode(ss));
        log.info("加密后：" + URLEncoder.encode(DesUtil.encode(ss), "utf-8"));


//        String s2 = "staffId=AVYA0042&accessSource=mesop&imgPath=";
        String s2 = "staffId=chuweiwei&accessSource=oa&imgPath=";
        log.info("加密后s2：" + URLEncoder.encode(DesUtil.encode(s2), "utf-8"));
//        String s3 ="staffId=29008254&accessSource=mesop&imgPath=channelAccess/mesop/2020-01/e1c03dbf-6dc4-4c1a-b55c-ab8b2f8c2d44.png";
//        String s3 ="staffId=29008254&accessSource=mesop&imgPath=channelAccess/mesop/2020-01/e1c03dbf-6dc4-4c1a-b55c-ab8b2f8c2d44.png";
//        log.info("加码："+URLEncoder.encode(s3,"utf-8"));
//        log.info("加密后s3："+DesUtil.encode(s3));
//        log.info("加密后s3："+URLEncoder.encode(DesUtil.encode(s3),"utf-8"));
        String s3 = "staffId=123456&accessSource=mesop&imgPath=channelAccess/2020-01/600e0638-b032-4874-9817-65438647d860.jpg";
        String s3n = URLEncoder.encode(DesUtil.encode(s3), "utf-8");
        log.info("加密后s3：" + s3n);
        log.info("解密s3：" + DesUtil.decode(URLDecoder.decode(s3n, "utf-8")));
        String sn = "dmVa%2B%2FETCn9RSfGE%2Br8RnTQjP8%2BoEX4rE3cujDIT0VK2xsoxyFuuPQvO44%2F4BX6WcAYxJFy2e0oy%0AG5noqvCAkg%3D%3D";
//        log.info("解密mesop: gbk："+DesUtil.decode(URLDecoder.decode(sn,"gbk")));
        log.info("解密mesop: utf-8：" + DesUtil.decode(URLDecoder.decode(sn, "utf-8")));
//        String params = "HLWBZTGZT" + "1577708799310" + "1000";
//        log.info("加密后s3："+DigestUtils.md5DigestAsHex(params.getBytes()).toLowerCase());
//       String aa = URLEncoder.encode(DesUtil.encode(ss),"utf-8");
//       String a2 = DesUtil.decode(URLDecoder.decode(aa,"utf-8"));
//        String aa = "c3RhZmZJZD1URVNUVEoxNiZhY2Nlc3NTb3VyY2U9bWVzb3AmaW1nUGF0aD1jaGFubmVsQWNjZXNzL21lc29wLzIwMjAtMDEvNTI0ZDNkMjItOTM5Mi00YzY0LWJjY2ItZTVkNTBkNGY3ZjYzLnBuZw%3D%3D";
//       log.info("解密1："+DesUtil.decode(URLDecoder.decode(aa,"utf-8")));
//       String aa1 = "Eb639qpTjmzbtTeD7GzqgBC4lEU4p2QbcS62jS8sFCiHZvUUgO%2BlX2FaFPbsq88%2FZXuPpXKEMOOL%0A4xBmRGhiZifhiD6EMHb4jDgahQQo938KkGh8B6tZNpqUAbGC1FR5zNxr9z9HM60lZydWyAzIGMl8%0AdKXtuNM6";
//        log.info("解密aa1："+DesUtil.decode(URLDecoder.decode(aa1,"utf-8")));
//        log.info("解密简单aa1："+Base64Utils.decodeFromString(URLDecoder.decode(aa1,"utf-8")));
        //        log.info("是否为空:"+StringUtils.isEmpty(null));
//        log.info("是否为空:"+StringUtils.isEmpty(""));
//        String s2 = URLDecoder.decode(ss,"utf-8");
//       log.info("解码："+URLDecoder.decode(ss,"utf-8"));
//       log.info("解码2："+URLDecoder.decode(s2,"utf-8"));
////       log.info("解码3："+URLDecoder.decode(null,"utf-8"));
//       log.info("解码4："+URLDecoder.decode("","utf-8"));


//        log.info(ss.substring(ss.indexOf("phoneNum=")+1,ss.indexOf("&",ss.indexOf("phoneNum="))));
//        String[] paramsArray = ss.split("&");
//        for (String params:paramsArray) {
//            if(params.indexOf("phoneNum=")>-1){
//                log.info(params.substring(params.indexOf("=")+1,params.length()));
//            }
//        }
//        log.info(URLDecoder.decode("%3Cp%3E%E7%9A%84%E4%BA%8B%E5%AE%9E%3Cbr%2F%3E%3C%2Fp%3E","utf-8"));

        String oa = "JcO0VrMzOfvWLDzcQBN8Il4aQfY7F68DNnpn2HFlFkHyGIaELhnPHNsVvk9mKPcBHEjd7xl7j62V%0AMhqTT52iSBGt2a7%2BIUirikbZjxbyd%2BfkmcgIb7x5HRcpOghyA8ae5OL5bkbapUTiJfTExgp85l9Q%0Ao3oyeVdqBeg3oOl99%2Bg%3D";
        log.info("解密oa：" + DesUtil.decode(URLDecoder.decode(oa, "utf-8")));


        String ddddd = "tokenInfo=%7B%22access_token%22%3A%22afe1f852-399e-484f-b749-d69378c8a75a%22%2C%22refresh_token%22%3A%224b3d116d-49a3-49fe-b7e8-fc5e1d23b7b5%22%2C%22scope%22%3A%22all%22%2C%22staff_id%22%3A%22wuna%22%2C%22tenantId%22%3A%22TJBBT%22%2C%22token_type%22%3A%22bearer%22%2C%22expires_in%22%3A43199%2C%22targetUrl%22%3A%22http%3A//10.143.112.166/hlwbztgzt/ucfront/index.html%22%2C%22client_id%22%3A%22oneframe-app%22%7D";
        log.info("ssssssss：" + URLDecoder.decode(ddddd, "utf-8"));

        String nnnn = "kBjFpb3DZflw3ExM7ytoxh0Ds7TgoUNpFiTG8pxmhG7XPuF2UwBsdPVmWP0vkOrdfirW9oruBdLQ%0ALjrc9M5VDw%3D%3D";
        log.info("guanxin：" + DesUtil.decode(URLDecoder.decode(nnnn, "utf-8")));


        String sss = "{\"loginIp\":\"127.0.0.1\",\"resultVal\":\"1\",\"resultMsg\":[{\"idCardNo\":\"121212121212121212\",\"orgaTypeId\":\"4\",\"postId\":\"02\",\"platformId\":\"9996017\",\"staffIdStatus\":\"01\",\"orgaName\":\"服务运营管理部\",\"insertTime\":1572071874000,\"defaultServiceType\":\"融合\",\"staffState\":\"1\",\"emailAddress\":\"123123123@qq.com\",\"joinDate\":1569911714000,\"mobilePhone\":\"13300010012\",\"prsnChnlTypeCd\":\"0\",\"roleCode\":\"1,1911131802460000002\",\"staffName\":\"吴娜\",\"orgaId\":\"1910311424200000002\",\"tenantId\":\"TJBBT\",\"updaTetime\":1572071874000,\"staffId\":\"wuna\",\"channelId\":\"01\"}]}";

//        log.info("guanxin3333："+URLDecoder.decode(sss,"utf-8"));
//        String sy = URLDecoder.decode(sss,"utf-8");
        JSONObject params = JSONObject.parseObject(sss);
//        HashMap params = JSON.parseObject(sy, HashMap.class);
        log.info("guanxin3333：" + params.get("loginIp"));
        List<Map<String, Object>> list = (List<Map<String, Object>>) params.get("resultMsg");
        Map<String, Object> map = list.get(0);
        log.info("guanxin3333：" + map.get("staffName"));
//        String ss3n =URLEncoder.encode(DesUtil.encode(sss),"utf-8");
//        log.info("guanxin3333："+ss3n);
//        HashMap<String, String> userInfoResult = new HashMap<>();
//        userInfoResult.put("kk","kk");
////        JSON.toJSONString(userInfoResult);
//        log.info("guanxin3333："+JSON.toJSONString(userInfoResult));
    }


    @Test
    @Transactional
    public void TestX() throws Exception {
        String str = "AVYA0123asC./dDDS";
        String regex = "^[a-z0-9A-Z]+$";
        log.info("check:" + str.matches(regex));

//        log.info("check2:" + CollectionUtils.isEmpty(null));
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf2.format(cal.getTime());
        log.info("timestamp:" + timestamp);


        String T1 = "phoneNum=&staffId=AAY00160&accessSource=TJSST";
        log.info("加密后TJSST张磊：" + URLEncoder.encode(DesUtil.encode(T1), "utf-8"));
        String T2 = "phoneNum=&staffId=AAY00159&accessSource=TJSST";
        log.info("加密后TJSST 冯斌：" + URLEncoder.encode(DesUtil.encode(T2), "utf-8"));
        String T3 = "phoneNum=&staffId=AAY00097&accessSource=TJSST";
        log.info("加密后TJSST万海鹏：" + URLEncoder.encode(DesUtil.encode(T3), "utf-8"));
        String T4 = "phoneNum=&staffId=AFY00118&accessSource=TJSST";
        log.info("加密后TJSST潘炳辉 ：" + URLEncoder.encode(DesUtil.encode(T4), "utf-8"));

        String T1s = "phoneNum=13920748646&staffId=AVYA1069&accessSource=TJSST";
        log.info("加密后TJSST石理：" + URLEncoder.encode(DesUtil.encode(T1s), "utf-8"));


        String QYWX = "phoneNum=13516184011&staffId=AVYA1060&accessSource=QYWX";
        log.info("加密后企业微信付为：" + URLEncoder.encode(DesUtil.encode(QYWX), "utf-8"));

        String TJSST00 = "phoneNum=&staffId=AVYA1060&accessSource=TJSST";
        log.info("加密后TJSST付为：" + URLEncoder.encode(DesUtil.encode(TJSST00), "utf-8"));

        String AVYA0088 = "phoneNum=&staffId=AVYA0088&accessSource=TJSST";
        log.info("加密后AVYA0088：" + URLEncoder.encode(DesUtil.encode(AVYA0088), "utf-8"));



        String TJSST01 = "phoneNum=13516184010&staffId=AVYA1060&accessSource=TJSST";
        log.info("加密后TJSST付为合伙人：" + URLEncoder.encode(DesUtil.encode(TJSST01), "utf-8"));


        String crm2 = "phoneNum=18322702153&staffName=吴娜&accessSource=CRM";
        log.info("加密后CRM吴娜：" + URLEncoder.encode(DesUtil.encode(crm2), "utf-8"));

        String crmsss = "phoneNum=13662006898&staffName=李倩茹&accessSource=CRM";
        log.info("加密后crmsss李倩茹：" + URLEncoder.encode(DesUtil.encode(crmsss), "utf-8"));


        String TJSSTZZZ = "phoneNum=18322702102&staffId=zhangrongwei&accessSource=TJSST";
        log.info("加密后张荣伟：" + URLEncoder.encode(DesUtil.encode(TJSSTZZZ), "utf-8"));

        String TJSST0 = "phoneNum=18322702076&staffId=AVYA0094&accessSource=TJSST";
        log.info("加密后TJSST0：" + URLEncoder.encode(DesUtil.encode(TJSST0), "utf-8"));
        String TJSST = "phoneNum=13602127453&staffId=BEYA0126&accessSource=TJSST";
        log.info("加密后TJSST：" + URLEncoder.encode(DesUtil.encode(TJSST), "utf-8"));
        String TJSST2 = "phoneNum=13821218898&staffId=AGYB0060&accessSource=TJSST";
        log.info("加密后TJSST2：" + URLEncoder.encode(DesUtil.encode(TJSST2), "utf-8"));
        String TJSST3 = "phoneNum=13622192228&staffId=%ASYB0078%&accessSource=TJSST";
        log.info("加密后TJSST3：" + URLEncoder.encode(DesUtil.encode(TJSST3), "utf-8"));


        String AHYA0095 = "phoneNum=&staffId=AHYA0095&accessSource=TJSST";
        log.info("加密后AHYA0095：" + URLEncoder.encode(DesUtil.encode(AHYA0095), "utf-8"));




        String sh1 = "phoneNum=13902009399&staffId=&accessSource=weixin";
        log.info("加密后weixin：" + URLEncoder.encode(DesUtil.encode(sh1), "utf-8"));
        String sh2 = "phoneNum=13821921540&staffId=&accessSource=weixin";
        log.info("加密后weixin：" + URLEncoder.encode(DesUtil.encode(sh2), "utf-8"));
        String sh3 = "phoneNum=13602169163&staffId=&accessSource=weixin";
        log.info("加密后weixin：" + URLEncoder.encode(DesUtil.encode(sh3), "utf-8"));
        String sh4 = "phoneNum=13602145101&staffId=&accessSource=weixin";
        log.info("加密后weixin：" + URLEncoder.encode(DesUtil.encode(sh4), "utf-8"));
        String sh5 = "phoneNum=13512060068&staffId=&accessSource=weixin";
        log.info("加密后weixin：" + URLEncoder.encode(DesUtil.encode(sh5), "utf-8"));
        String sh6 = "phoneNum=13702000680&staffId=&accessSource=weixin";
        log.info("加密后weixin：" + URLEncoder.encode(DesUtil.encode(sh6), "utf-8"));

        String sh7 = "phoneNum=13602009274&staffId=&accessSource=weixin";
        log.info("加密后weixin：" + URLEncoder.encode(DesUtil.encode(sh7), "utf-8"));

        String sh8 = "phoneNum=13516184007&staffId=&accessSource=weixin";
        log.info("加密后weixin付为：" + URLEncoder.encode(DesUtil.encode(sh8), "utf-8"));

        String shh8 = "phoneNum=13672095558&staffId=AVYA0123&accessSource=weixin";
        log.info("加密后weixin吴士杰：" + URLEncoder.encode(DesUtil.encode(shh8), "utf-8"));


        String sh10 = "phoneNum=1351618407&staffId=&accessSource=weixin";
        log.info("加密后weixin错误付为：" + URLEncoder.encode(DesUtil.encode(sh10), "utf-8"));


        String sh9 = "phoneNum=15822633840&staffId=&accessSource=weixin";
        log.info("加密后weixin许惠晴：" + URLEncoder.encode(DesUtil.encode(sh9), "utf-8"));


        String crm0 = "phoneNum=15822633840&staffName=许惠晴&accessSource=CRM";
        log.info("加密后CRM许惠晴：" + URLEncoder.encode(DesUtil.encode(crm0), "utf-8"));

        String crm = "phoneNum=13821887842&staffName=刘凯&accessSource=CRM";
        log.info("加密后CRM刘凯：" + URLEncoder.encode(DesUtil.encode(crm), "utf-8"));

        String crm1 = "phoneNum=13622002012&staffName=沈晓玲&accessSource=CS";
        log.info("加密后CRM沈晓玲：" + URLEncoder.encode(DesUtil.encode(crm1), "utf-8"));

        String crmmmm = "phoneNum=18322702153&staffName=吴娜&accessSource=CRM";
        log.info("加密后CRM吴娜：" + URLEncoder.encode(DesUtil.encode(crmmmm), "utf-8"));

        String crmN = "phoneNum=18322702153&staffId=wuna&staffName=吴娜&accessSource=CRM_NEW";
        log.info("加密后CRM吴娜NEW：" + URLEncoder.encode(DesUtil.encode(crmN), "utf-8"));

        String crmN1 = "phoneNum=&staffId=SUPERUSR&staffName=系统工号&accessSource=CRM_NEW&transferFlag=1&content=OCB000002865";
        log.info("加密后CRM吴娜NEW2：" + URLEncoder.encode(DesUtil.encode(crmN1), "utf-8"));

        String crmN2 = "phoneNum=&staffId=SUPERUSR&staffName=吴娜&accessSource=CRM_NEW&transferFlag=1&content=OCB000002865";
        log.info("加密后CRM吴娜NEW3：" + URLEncoder.encode(DesUtil.encode(crmN2), "utf-8"));


        String crmN3 = "phoneNum=10000000&staffId=wuna&staffName=吴娜&accessSource=CRM_NEW&transferFlag=1&content=测试CRM_NEW";
        log.info("加密后CRM吴娜NEWNEWNEW：" + URLEncoder.encode(DesUtil.encode(crmN3), "utf-8"));


        String crm3 = "phoneNum=18322702153&staffName=测试01&accessSource=CRM";
        log.info("加密后CRM3：" + URLEncoder.encode(DesUtil.encode(crm3), "utf-8"));

        String cs0 = "phoneNum=15822633840&staffName=许惠晴&accessSource=CS";
        log.info("加密后CS许惠晴：" + URLEncoder.encode(DesUtil.encode(cs0), "utf-8"));

        String cs = "phoneNum=13902002002&staffName=郭红民&accessSource=CS";
        log.info("加密后CS：" + URLEncoder.encode(DesUtil.encode(cs), "utf-8"));

        String cs1 = "phoneNum=18322702153&staffName=吴娜&accessSource=CS";
        log.info("加密后CS吴娜：" + URLEncoder.encode(DesUtil.encode(cs1), "utf-8"));

        String OA = "phoneNum=13702097446&staffId=sunjingchao&accessSource=oa";
        log.info("加密后oa：" + URLEncoder.encode(DesUtil.encode(OA), "utf-8"));

        String OA1 = "phoneNum=18322702153&staffId=wuna&accessSource=oa";
        log.info("加密后oa吴娜：" + URLEncoder.encode(DesUtil.encode(OA1), "utf-8"));

        String JTGX = "phoneNum=13711111111&staffId=&accessSource=JTGX";
        log.info("加密后GX：" + URLEncoder.encode(DesUtil.encode(JTGX), "utf-8"));


        String ZQ = "phoneNum=13662057010&bossId=BFYA9321&accessSource=BBOSS";
        log.info("加密后ZQ：" + URLEncoder.encode(DesUtil.encode(ZQ), "utf-8"));
//        String a = "AQZ00960,AKZ01750";
//        String b = "AKZ01751";
//        log.info("包含：" + a.contains(b));
        String sss = "CT%2BE%2FCrpVfsKGlr92WojP9nbHeCNlSBra3IsfX3S%2FG0VhzbewJ6gnujDiVM2MqmMX0whU52tjHn6%0D%0A3AFNmwEgXw%3D%3D";
        log.info("解密sss：" + DesUtil.decode(URLDecoder.decode(sss, "utf-8")));

        String NNN = "phoneNum=13439564979&accessSource=JTGX&imgPath=channelAccess/2020-03/c458d919-eb05-485f-8fc2-9be45361b6d2.jpg";
        log.info("加密后JTGX：" + URLEncoder.encode(DesUtil.encode(NNN), "utf-8"));

        String TEst = "phoneNum=13752377500&accessSource=JTGX&imgPath=channelAccess/2020-03/f127969b-ec83-4ecb-a79f-c994f3ccba51.png";
        log.info("加密后JTGXTEst：" + URLEncoder.encode(DesUtil.encode(TEst), "utf-8"));

        String TEst3 = "phoneNum=13920120914&accessSource=JTGX";
        log.info("加密后JTGXTEst3：" + URLEncoder.encode(DesUtil.encode(TEst3), "utf-8"));

        String TJJF = "phoneNum=&staffId=wuna&accessSource=TJJF";
        log.info("加密后TJJF吴娜：" + URLEncoder.encode(DesUtil.encode(TJJF), "utf-8"));

        String TJJFFlag = "phoneNum=&staffId=wuna&accessSource=TJJF&transferFlag=1";
        log.info("加密后TJJF吴娜自动转接人工：" + URLEncoder.encode(DesUtil.encode(TJJFFlag), "utf-8"));

        String TJJFOrder = "phoneNum=&staffId=wuna&accessSource=TJJF&toPage=createOrder";
        log.info("加密后TJJF吴娜立单：" + URLEncoder.encode(DesUtil.encode(TJJFOrder), "utf-8"));


        String TJJF0 = "phoneNum=&staffId=xu_huiqing&accessSource=TJJF";
        log.info("加密后TJJF许惠晴：" + URLEncoder.encode(DesUtil.encode(TJJF0), "utf-8"));

        String TJJF11 = "phoneNum=&staffId=xu_huiqing&accessSource=TJJF&transferFlag=1";
        log.info("加密后TJJF许惠晴自动转人工：" + URLEncoder.encode(DesUtil.encode(TJJF11), "utf-8"));

        String TJJF111 = "phoneNum=&staffId=xu_huiqing&accessSource=TJJF&toPage=createOrder";
        log.info("加密后TJJF许惠晴立单：" + URLEncoder.encode(DesUtil.encode(TJJF111), "utf-8"));

        String TJJF1 = "phoneNum=&staffId=xujing1&accessSource=TJJF";
        log.info("加密后TJJF1：" + URLEncoder.encode(DesUtil.encode(TJJF1), "utf-8"));

        String kkk = "kJVabaSZaX1GQ5c0afHdqtVMXuisCb5/C3GfgHQWKxaM9glifkRODXhFvOpTQ2sz";

        log.info("解密后kkk：" + DesUtil.decode(URLDecoder.decode(kkk, "utf-8")));

        String TJQDWG = "phoneNum=13821887842&staffId=liu_kai4&accessSource=TJQDWG";
        log.info("TJQDWG：" + URLEncoder.encode(DesUtil.encode(TJQDWG), "utf-8"));
        String TJQDWG1 = "phoneNum=13516184007&staffId=fuwei1&accessSource=TJQDWG";
        log.info("TJQDWG1：" + URLEncoder.encode(DesUtil.encode(TJQDWG1), "utf-8"));

        String TJQDWG2 = "phoneNum=18322702153&staffId=wuna&accessSource=TJQDWG";
        log.info("TJQDWG2吴娜：" + URLEncoder.encode(DesUtil.encode(TJQDWG2), "utf-8"));

        String TJQDWG3 = "phoneNum=13821051382&staffId=AVY00013&accessSource=TJQDWG";
        log.info("TJQDWG3马超：" + URLEncoder.encode(DesUtil.encode(TJQDWG3), "utf-8"));

        String TJQDWG4 = "phoneNum=&staffId=AVYA0116&accessSource=TJHJM";
        log.info("AVYA0116 张岩：" + URLEncoder.encode(DesUtil.encode(TJQDWG4), "utf-8"));

        String TJQDWG5 = "phoneNum=&staffId=TSYS8983&accessSource=TJHJM";
        log.info("TSYS8983 陈伟：" + URLEncoder.encode(DesUtil.encode(TJQDWG5), "utf-8"));

        String sks = (String) null;
        log.info("解密后sks：" + sks);


        String TJHJM = "phoneNum=13752377500&staffId=zheng_tengda&accessSource=TJHJM&transferFla=1&content=办理报错";

        log.info("天津和加盟token：" + URLEncoder.encode(DesUtil.encode(TJHJM), "utf-8"));

        String mesop = "staffId=wuna&accessSource=mesop&imgPath=";
        log.info("mesop吴娜：" + URLEncoder.encode(DesUtil.encode(mesop), "utf-8"));

        String mesop2 = "staffId=AVYA0006&accessSource=mesop&imgPath=";
        log.info("mesop槐秋媛：" + URLEncoder.encode(DesUtil.encode(mesop2), "utf-8"));


    }

    @Test
    public void MyTest() throws Exception {

        String[] strings = {"20200421|B2|B2WWG0110|薄娜娜微网格|d5464cf8fa6e5856fca77880|飞云东里|", "20200421|B2|B2WWG0110|薄娜娜微网格|49a02a7a63cd79412a201a83|万维花园|"};
        List<Map> listMap = new ArrayList<>();
        for (String str : strings) {
//            String ids= "20200421|B2|B2WWG0110|薄娜娜微网格|d5464cf8fa6e5856fca77880|飞云东里|";
            List<String> listIds = Arrays.asList(str.split("\\|")).stream().map(s -> String.valueOf(s.trim())).collect(Collectors.toList());
            System.out.println(Arrays.toString(listIds.toArray()));
            Map<String, Object> map = new HashMap<>();

            map.put("DIRECTOR_ID", "");
            map.put("UPDATE_TIME", new Date());//数据更新日期
            map.put("GRID_NUMBER", listIds.get(0));//网格编码
            map.put("GRID_NAME", listIds.get(1));//网格名称
            map.put("DIRECTOR_STAFF_ID", listIds.get(2));//支局长工号(4a工号)
            map.put("DIRECTOR_STAFF_NAME", listIds.get(3));//支局长姓名
            map.put("CREATE_TIME", listIds.get(4));//业务数据发生日期
            map.put("EFFECT_TIME", listIds.get(5));//支局长和网格绑定生效时间
            map.put("INVALID_TIME", new Date());//支局长和网格绑定失效时间
            listMap.add(map);
        }
        System.out.println(listMap.toString());
//        String ids= "11|2|3|4|5|6";
//        List<Long> listIds = Arrays.asList(ids.split("\\|")).stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
//        System.out.println(Arrays.toString(listIds .toArray()));//[1,2,3,3,4,5,6]

    }


    @Test
    public void MyTest2() throws Exception {

        File srcfile = new File("E:\\voiceaudio\\4c1d1e607bcd888828f6444682e3982.jpg");
        File distfile = new File("E:\\voiceaudio\\afterdes.png");
        System.out.println("压缩前图片大小：" + srcfile.length());
        log.info("start:" + System.currentTimeMillis());
        byte[] bytes = ImageCompressUtil.File2byte(srcfile);
        log.info("middl:" + System.currentTimeMillis());
        long start = System.nanoTime();
        byte[] bytes1 = ImageCompressUtil.compressImage(bytes);
        log.info("end00:" + System.currentTimeMillis());
        long end = System.nanoTime();
        ImageCompressUtil.getFileByBytes(bytes1, "E:\\voiceaudio", "des.jpg");
        System.out.println("压缩后图片大小：" + bytes1.length);
        System.out.println("压缩时间：" + (end - start) * 0.000000001 + "s");
//        log.info("start1:"+System.currentTimeMillis());
//        ImageCompressUtil.reduceImg("E:\\voiceaudio\\4c1d1e607bcd888828f6444682e3982.jpg","E:\\voiceaudio\\afterdes.jpeg");
//        log.info("end111:"+System.currentTimeMillis());

    }

    @Test
    public void MyTest5() throws Exception {



        String content = "认知图谱知识抽取模型\n" +
                "认知图谱知识挖掘模型\n" +
                "认知图谱知识融合模型\n" +
                "认知图谱知识推理模型\n" +
                "认知图谱语义搜索模型\n" +
                "认知图谱知识问答模型\n" +
                "认知图谱存储机制模型\n" +
                "认知图谱语法解析模型\n" +
                "认知图谱依存分析模型\n" +
                "认知图谱词性标注模型\n" +
                "认知图谱实体识别模型\n" +
                "认知图谱实体链接模型\n" +
                "认知图谱关系抽取模型\n" +
                "认知图谱事件抽取模型\n" +
                "认知图谱属性抽取模型\n" +
                "认知图谱实体消歧模型\n" +
                "认知图谱实体构建模型\n" +
                "认知图谱质量评估模型\n" +
                "认知图谱多元关系模型\n" +
                "认知图谱模态知识模型\n" +
                "认知图谱语义网络模型\n" +
                "认知图谱强化学习模型\n" +
                "认知图谱预测控制模型\n" +
                "认知图谱策略梯度模型\n" +
                "认知图谱多层感知模型\n" +
                "认知图谱神经关联模型\n" +
                "认知图谱语义匹配模型\n";
        String[] split = content.split("\n");
        List<String> lines = new ArrayList<>();
        for (String line : split) {
            lines.add(line);
//            String tempLine = line.replace("配置","");
//            lines.add(line+"，提供"+tempLine+"的新增、修改、删除以及查询功能，实现租户大屏监控指标的可配置化。");
//            lines.add(line+"，提供"+tempLine+"的新增、修改、删除以及查询功能。");
//            if (line.contains("新增")) {
//                String tempLine = line.replace("配置", "");
                lines.add("通过" + line + "页面，点击新增按钮，执行" + line + "新增操作。");
//            } else if (line.contains("修改")) {
//                String tempLine = line.replace("配置", "");
                lines.add("通过" + line + "页面，勾选要修改的规则，执行" + line + "修改操作。");
//            } else if (line.contains("删除")) {
//                String tempLine = line.replace("配置", "");
                lines.add("通过" + line + "页面，勾选要删除的规则，执行" + line + "删除操作。");
//            } else if (line.contains("查询")) {
//                String tempLine = line.replace("配置", "");
                lines.add("通过" + line + "页面，选择查询条件，执行" + line + "查询操作。");
//            }
        }
        Files.write(Paths.get("D:/crud.txt"), lines);
    }


    @Test
    public void MyTest6() throws Exception {


        String content = "认知图谱知识抽取模型\n" +
                "认知图谱知识挖掘模型\n" +
                "认知图谱知识融合模型\n" +
                "认知图谱知识推理模型\n" +
                "认知图谱语义搜索模型\n" +
                "认知图谱知识问答模型\n" +
                "认知图谱存储机制模型\n" +
                "认知图谱语法解析模型\n" +
                "认知图谱依存分析模型\n" +
                "认知图谱词性标注模型\n" +
                "认知图谱实体识别模型\n" +
                "认知图谱实体链接模型\n" +
                "认知图谱关系抽取模型\n" +
                "认知图谱事件抽取模型\n" +
                "认知图谱属性抽取模型\n" +
                "认知图谱实体消歧模型\n" +
                "认知图谱实体构建模型\n" +
                "认知图谱质量评估模型\n" +
                "认知图谱多元关系模型\n" +
                "认知图谱模态知识模型\n" +
                "认知图谱语义网络模型\n" +
                "认知图谱强化学习模型\n" +
                "认知图谱预测控制模型\n" +
                "认知图谱策略梯度模型\n" +
                "认知图谱多层感知模型\n" +
                "认知图谱神经关联模型\n" +
                "认知图谱语义匹配模型\n" +
                "认知图谱平移距离模型\n" +
                "认知图谱词向量生成\n" +
                "认知图谱数据集构建\n" +
                "认知图谱文本预处理";
        String[] split = content.split("\n");
        List<String> lines = new ArrayList<>();
        for (String line : split) {
//            lines.add(line);
            lines.add(line + "新增");
            lines.add(line + "修改");
            lines.add(line + "删除");
            lines.add(line + "查询");
        }
        Files.write(Paths.get("D:/crud.txt"), lines);
    }


    @Test
    public void testTemp() throws Exception {
//        Collection
//        LockSupport
        String a = "a";
        String b = "a";
        String c = new String("sss");
        String d = new String("sss");
        log.info("istrue:" + a.equals(b));
        log.info("istrue:" + c.equals(d));
        List list = new ArrayList();
        List list2 = new ArrayList();
        list.removeAll(list2);

        log.info("size:" + Math.max((int) (20 / .75f) + 1, 16));
        log.info("size:" + Math.max((int) (10 / .75f) + 1, 16));

        SimpleDateFormat simpleDateFormatMM = new SimpleDateFormat("yyyyMMdd");//注意月份是MM
        String fileName = "cmossend_d1033_" + simpleDateFormatMM.format(new Date()) + ".gz";
        log.info("fileName:" + fileName);


    }



    @Test
    public void MyTest7() throws Exception {

        String content = "认知图谱知识抽取模型\n" +
                "认知图谱知识挖掘模型\n" +
                "认知图谱知识融合模型\n" +
                "认知图谱知识推理模型\n" +
                "认知图谱语义搜索模型\n" +
                "认知图谱知识问答模型\n" +
                "认知图谱存储机制模型\n" +
                "认知图谱语法解析模型\n" +
                "认知图谱依存分析模型\n" +
                "认知图谱词性标注模型\n" +
                "认知图谱实体识别模型\n" +
                "认知图谱实体链接模型\n" +
                "认知图谱关系抽取模型\n" +
                "认知图谱事件抽取模型\n" +
                "认知图谱属性抽取模型\n" +
                "认知图谱实体消歧模型\n" +
                "认知图谱实体构建模型\n" +
                "认知图谱质量评估模型\n" +
                "认知图谱多元关系模型\n" +
                "认知图谱模态知识模型\n" +
                "认知图谱语义网络模型\n" +
                "认知图谱强化学习模型\n" +
                "认知图谱预测控制模型\n" +
                "认知图谱策略梯度模型\n" +
                "认知图谱多层感知模型\n" +
                "认知图谱神经关联模型\n" +
                "认知图谱语义匹配模型\n" +
                "认知图谱平移距离模型";
        String[] split = content.split("\n");
        List<String> lines = new ArrayList<>();
        for (String line : split) {
//            lines.add(line);

                line = line.replace("新增", "");
                lines.add("输入" + line + "规则内容");
                lines.add("读取" + line + "的重复性校验规则");
//                lines.add(line + "的操作权限提醒展示");
                lines.add("调用"+line + "新增接口");
                lines.add(line + "接口调用结果反馈");
                lines.add(line + "操作日志记录接口调用");
                lines.add("新增"+ line + "内容展示");

                line = line.replace("修改", "");
                lines.add("输入修改" + line + "内容");
                lines.add("对"+ line + "原始数据进行读取");
//                lines.add(line + "的操作权限提醒展示");
                lines.add("调用"+line + "的信息修改接口");
                lines.add(line + "修改接口调用结果反馈");
                lines.add(line + "的修改操作日志记录接口调用");
                lines.add("修改" + line + "的内容展示");

                line = line.replace("删除", "");
                lines.add("选择要删除的" + line + "");
                lines.add("对删除数据状态进行校验");
                lines.add("删除" + line + "操作权限提醒展示");
                lines.add("调用"+line + "的信息删除接口");
                lines.add(line + "信息删除接口调用结果反馈");
                lines.add(line + "的删除操作日志记录");

                line = line.replace("查询", "");
                lines.add("输入" + line + "的筛选条件内容");
                lines.add(line + "查询操作权限验证");
                lines.add("查询"+line + "的操作权限提醒展示");
                lines.add("调用" + line + "的信息查询接口");
                lines.add(line + "查询接口调用结果反馈");
                lines.add(line + "查询操作的日志记录接口调用");
                lines.add(line + "内容展示");

        }
        Files.write(Paths.get("D:/crud.txt"), lines);
    }

    /**
     * 生成数据组信息
     * @throws Exception
     */
    @Test
    public void MyTest8() throws Exception {

        String content = "认知图谱知识抽取模型\n" +
                "认知图谱知识挖掘模型\n" +
                "认知图谱知识融合模型\n" +
                "认知图谱知识推理模型\n" +
                "认知图谱语义搜索模型\n" +
                "认知图谱知识问答模型\n" +
                "认知图谱存储机制模型\n" +
                "认知图谱语法解析模型\n" +
                "认知图谱依存分析模型\n" +
                "认知图谱词性标注模型\n" +
                "认知图谱实体识别模型\n" +
                "认知图谱实体链接模型\n" +
                "认知图谱关系抽取模型\n" +
                "认知图谱事件抽取模型\n" +
                "认知图谱属性抽取模型\n" +
                "认知图谱实体消歧模型\n" +
                "认知图谱实体构建模型\n" +
                "认知图谱质量评估模型\n" +
                "认知图谱多元关系模型\n" +
                "认知图谱模态知识模型\n" +
                "认知图谱语义网络模型\n" +
                "认知图谱强化学习模型\n" +
                "认知图谱预测控制模型\n" +
                "认知图谱策略梯度模型\n" +
                "认知图谱多层感知模型\n" +
                "认知图谱神经关联模型\n" +
                "认知图谱语义匹配模型\n" +
                "认知图谱平移距离模型";
        String[] split = content.split("\n");
        List<String> lines = new ArrayList<>();
        for (String line : split) {
            line = line.replace("新增", "");
            lines.add("新增" + line + "内容");
            lines.add("读取重复性校验规则信息");
            lines.add("新增"+line + "信息");
            lines.add(line + "新增接口调用结果反馈信息");
            lines.add(line + "操作日志信息");
            lines.add("新增"+ line + "内容展示信息");

            line = line.replace("修改", "");
            lines.add("修改" + line + "内容");
            lines.add("对原始数据进行读取信息");
            lines.add("修改"+line + "信息");
            lines.add(line + "修改接口调用结果反馈信息");
            lines.add("修改"+line + "操作日志信息");
            lines.add("修改" + line + "内容信息");

            line = line.replace("删除", "");
            lines.add("删除" + line + "内容");
            lines.add("对删除数据状态进行校验");
            lines.add("删除" + line + "操作权限提醒信息");
            lines.add("删除"+line + "信息");
            lines.add(line + "删除接口调用结果反馈信息");
            lines.add(line + "删除操作日志信息");

            line = line.replace("查询", "");
            lines.add("查询" + line + "筛选条件内容");
            lines.add(line + "查询操作权限信息");
            lines.add("查询"+line + "操作权限提醒信息");
            lines.add(line + "信息");
            lines.add(line + "查询接口调用结果反馈信息");
            lines.add(line + "操作日志信息");
            lines.add(line + "内容展示");

        }
        Files.write(Paths.get("D:/数据组.txt"), lines);
    }

    /**
     * 生成数据属性
     * @throws Exception
     */
    @Test
    public void MyTest9() throws Exception {

        String content = "认知图谱知识抽取模型\n" +
                "认知图谱知识挖掘模型\n" +
                "认知图谱知识融合模型\n" +
                "认知图谱知识推理模型\n" +
                "认知图谱语义搜索模型\n" +
                "认知图谱知识问答模型\n" +
                "认知图谱存储机制模型\n" +
                "认知图谱语法解析模型\n" +
                "认知图谱依存分析模型\n" +
                "认知图谱词性标注模型\n" +
                "认知图谱实体识别模型\n" +
                "认知图谱实体链接模型\n" +
                "认知图谱关系抽取模型\n" +
                "认知图谱事件抽取模型\n" +
                "认知图谱属性抽取模型\n" +
                "认知图谱实体消歧模型\n" +
                "认知图谱实体构建模型\n" +
                "认知图谱质量评估模型\n" +
                "认知图谱多元关系模型\n" +
                "认知图谱模态知识模型\n" +
                "认知图谱语义网络模型\n" +
                "认知图谱强化学习模型\n" +
                "认知图谱预测控制模型\n" +
                "认知图谱策略梯度模型\n" +
                "认知图谱多层感知模型\n" +
                "认知图谱神经关联模型\n" +
                "认知图谱语义匹配模型\n" +
                "认知图谱平移距离模型";
        String[] split = content.split("\n");
        List<String> lines = new ArrayList<>();
        for (String line : split) {

            line = line.replace("认知图谱", "");
            line = line.replace("新增", "");

            lines.add(line+"名称，"+line+"类型，新增时间，是否生效，租户ID");
            lines.add("编号，用户ID，"+line+"操作，权限状态，租户ID");
            lines.add(line+"名称，"+line+"类型，是否生效，操作人，创建时间，租户ID");
            lines.add(line+"新增成功提示内容，操作人，创建时间，租户ID");
            lines.add(line+"新增操作日志编码，操作日志内容描述，操作日志状态，操作人，操作时间，租户ID");
            lines.add(line+"编号，"+line+"类型，是否生效，创建时间，创建人，租户ID");

            line = line.replace("修改", "");
            lines.add("修改"+line+"名称，修改"+line+"类型，修改时间，是否生效，租户ID");
            lines.add("编号，用户ID，修改"+line+"操作，权限状态，租户ID");
            lines.add("修改"+line+"名称，修改"+line+"类型，是否生效，操作人，创建时间，租户ID");
            lines.add(line+"修改成功提示内容，操作人，创建时间，租户ID");
            lines.add(line+"修改操作日志编码，操作日志内容描述，操作日志状态，操作人，操作时间，租户ID");
            lines.add(line+"编号，修改"+line+"类型，是否生效，创建时间，创建人，租户ID");

            line = line.replace("删除", "");
            lines.add("编号，用户ID，删除"+line+"操作，权限状态");
            lines.add("删除"+line+"操作权限提醒内容，操作人，操作时间");
            lines.add(line+"编号，状态，操作人，操作时间");
            lines.add(line+"删除成功提示内容，操作人，操作时间");
            lines.add(line+"删除操作日志编码，操作日志内容描述，操作日志状态，操作人，操作时间");
            lines.add(line+"类型，删除属性标签内容，是否生效，租户ID");


            line = line.replace("查询", "");
            lines.add(line+"编号，查询"+line+"内容，是否生效，租户ID");
            lines.add("编号，用户ID，"+line+"查询操作，权限状态，租户ID");
            lines.add(line+"查询操作权限提醒内容，操作人，操作时间，租户ID");
            lines.add(line+"编号，"+line+"类型，是否生效，操作人，操作时间，租户ID");
            lines.add(line+"查询成功提示内容，操作人，操作时间，租户ID");
            lines.add(line+"查询操作日志编码，操作日志内容描述，操作日志状态，操作人，操作时间，租户ID");
            lines.add(line+"编号，"+line+"类型，租户ID");

        }
        Files.write(Paths.get("D:/数据属性.txt"), lines);
    }


    /**
     * 生成数据属性
     * @throws Exception
     */
    @Test
    public void MyTest12() throws Exception {

        String content = "通用情感词\n" +
                "程度副词\n" +
                "否定词\n" +
                "领域词\n" +
                "文本倾向性阈值\n" +
                "情感词典";
        String[] split = content.split("\n");
        List<String> lines = new ArrayList<>();
        for (String line : split) {

            line = line.replace("认知图谱", "");
            line = line.replace("新增", "");

            lines.add(line+"名称，"+line+"类型，新增时间，是否生效，租户ID");
            lines.add("编号，用户ID，"+line+"操作，权限状态，租户ID");
            lines.add(line+"名称，"+line+"类型，是否生效，操作人，创建时间，租户ID");
//            lines.add(line+"新增成功提示内容，操作人，创建时间，租户ID");
            lines.add(line+"新增操作日志编码，操作日志内容描述，操作日志状态，操作人，操作时间，租户ID");
//            lines.add(line+"编号，"+line+"类型，是否生效，创建时间，创建人，租户ID");

            line = line.replace("修改", "");
            lines.add("修改"+line+"名称，修改"+line+"类型，修改时间，是否生效，租户ID");
            lines.add("编号，用户ID，修改"+line+"操作，权限状态，租户ID");
//            lines.add("修改"+line+"名称，修改"+line+"类型，是否生效，操作人，创建时间，租户ID");
            lines.add(line+"修改成功提示内容，操作人，创建时间，租户ID");
            lines.add(line+"修改操作日志编码，操作日志内容描述，操作日志状态，操作人，操作时间，租户ID");
//            lines.add(line+"编号，修改"+line+"类型，是否生效，创建时间，创建人，租户ID");

            line = line.replace("删除", "");
            lines.add("编号，用户ID，删除"+line+"操作，权限状态");
            lines.add("删除"+line+"操作权限提醒内容，操作人，操作时间");
//            lines.add(line+"编号，状态，操作人，操作时间");
            lines.add(line+"删除成功提示内容，操作人，操作时间");
            lines.add(line+"删除操作日志编码，操作日志内容描述，操作日志状态，操作人，操作时间");
//            lines.add(line+"类型，删除属性标签内容，是否生效，租户ID");


            line = line.replace("查询", "");
            lines.add(line+"编号，查询"+line+"内容，是否生效，租户ID");
            lines.add("编号，用户ID，"+line+"查询操作，权限状态，租户ID");
//            lines.add(line+"查询操作权限提醒内容，操作人，操作时间，租户ID");
//            lines.add(line+"编号，"+line+"类型，是否生效，操作人，操作时间，租户ID");
            lines.add(line+"查询成功提示内容，操作人，操作时间，租户ID");
            lines.add(line+"查询操作日志编码，操作日志内容描述，操作日志状态，操作人，操作时间，租户ID");
//            lines.add(line+"编号，"+line+"类型，租户ID");

        }
        Files.write(Paths.get("D:/王新数据属性.txt"), lines);
    }

    /**
     * INSERT INTO `t_voice_text_key_words` (`KEY_WORD`,`KEY_TYPE`,`KEY_TYPE_SUBSET`,`KEY_STATE`,`PRIORITY_LEVEL`,`TENANT_ID`,`RESERVE_1`,`RESERVE_2`) VALUES
     * ('慢','001','001001',2,null,'','',''),
     * @throws Exception
     */
    @Test
    public void MyTest10() throws Exception {
        String keywords = "慢、断网、掉线、卡顿、马赛克、花屏、测速慢、带宽不足、无法上网、光猫红灯、光猫闪灯、无法打开、无法播放、黑屏、错误代码、密码错误、账号不存在、无法访问、无法连接、不流畅、缓冲、不同步、转圈、发送失败、不刷新、重启无效、信号弱、没信号、覆盖差、干扰、连不上";
        String[] split = keywords.split("、");
        for (String str:split) {
            String key = "('"+str+"','001','001001',2,null,'','',''),";
            System.out.println(key);
        }

    }


    @Test
    public void MyTest11() throws Exception {
        String keywords = "不满意、投诉、工信部、315、曝光、热线、市长信箱、退网、电信、联通、市长热线、通信管理局、通管局、垃圾、烂、差劲、差、不满、生气、愤怒、焦虑、紧张、愤怒、沮丧、悲伤、痛苦、愤怒、抱怨、自责、悔恨、担忧、不安、郁闷、伤心、难过、失望、堕落、烦躁、生气、烦人";
        String[] split = keywords.split("、");
        for (String str:split) {
            String key = "('"+str+"','001','001002',2,null,'','',''),";
            System.out.println(key);
        }

    }

    @Test
    public void MyTest13() throws Exception {
        String path = "E:\\天津项目组\\青鸾项目\\4月8日-4月15日\\原始文件\\录音文件\\EOMS装机订单"; // 路径
        File f = new File(path);//获取路径  F:\测试目录
        if (!f.exists()) {
            System.out.println(path + " not exists");//不存在就输出
            return;
        }
        File fa[] = f.listFiles();//用数组接收
        String[] strings = new String[fa.length];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < fa.length; i++) {//循环遍历
            File fs = fa[i];//获取数组中的第i个
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");//如果是目录就输出
            } else {
                String str = "http://10.143.114.190:8081/gbs/vedio/audio_temp_0408/EOMS_zhuanji/"+fs.getName();
                list.add(str);
            }
        }
        String[] strings1 = list.toArray(new String[list.size()]);
//        System.out.println(Arrays.toString(strings1));
        System.out.println(JSONObject.toJSONString(strings1));

    }
}
