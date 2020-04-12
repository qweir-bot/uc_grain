package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义基本常量
 *
 * @author chenzhinian
 * @date 20190919
 */
public class Constants {

    /**
     * 租户id
     */
//    public static final String TENANTID = "100000";

    public static final String TENANTID = "TJBBT";//天津帮帮堂
    public static final String TENANTID_JTGX = "JTGX";//集团管信

    //EXCEL文件格式
    public static final String EXCEL_FILE_03 = ".xls";
    public static final String EXCEL_FILE_07 = ".xlsx";

    //转换方向
    public static final String INVOK_TYPE_IN = "01";
    public static final String INVOK_TYPE_OUT = "02";

    public static final Integer DELAY_SECONDS = 2;
    public static final Integer THOUSAND = 1000;

    //解决代码检查，定义的
    public static final int ZERO_INT = 0;
    public static final int THREE_INT = 3;
    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final Integer TWO = 2;
    public static final Integer THREE = 3;
    public static final Integer FOUR = 4;
    public static final Integer FIVE = 5;
    public static final Integer SIX = 6;
    public static final Integer SEVEN = 7;
    public static final Integer EIGHT = 8;
    public static final Integer NINE = 9;
    public static final Integer TEN = 10;

    public static final String TIME_LIMIT_NEW_SHEET = "TIME_LIMIT_NEW_SHEET_";
    public static final String MAX_LIMIT_NEW_SHEET = "MAX_LIMIT_NEW_SHEET_";
    public static final String SHEET_HANDLE_GROUP = "HANDLE_GROUP_";
    public static final String POOL_MAX_LIMIT = "POOL_MAX_LIMIT_";
    public static final String SMS_FAIL_MAX_LIMIT = "SMS_FAIL_MAX_LIMIT_";

    /**
     * 响应状态码
     * 成功：0、失败：-9999
     */
    public static final String RESPONSE_SUCCESS = "0";
    public static final String RESPONSE_FAIL = "-99999";

    public static final String CLEAN_MAX_DEF_LIMIT = "500";
    public static final String CLEAN_MAX_LIMIT_TYPE = "CLEAN_MAX_LIMIT";

    //客服工单-客户投诉问题所属渠道
    public static final String QUE_BELONG_CHANNEL_01 = "1";//10086人工
    public static final String QUE_BELONG_CHANNEL_02 = "2";//10086自动
    public static final String QUE_BELONG_CHANNEL_03 = "3";//网站
    public static final String QUE_BELONG_CHANNEL_04 = "4";//在线投诉
    public static final String QUE_BELONG_CHANNEL_05 = "5";//为民服务专区
    public static final String QUE_BELONG_CHANNEL_06 = "6";//短信营业厅
    public static final String QUE_BELONG_CHANNEL_07 = "7";//掌上营业厅（WAP）
    public static final String QUE_BELONG_CHANNEL_08 = "8";//USSD
    public static final String QUE_BELONG_CHANNEL_09 = "9";//自助终端
    public static final String QUE_BELONG_CHANNEL_10 = "10";//营业厅
    public static final String QUE_BELONG_CHANNEL_11 = "11";//外呼
    public static final String QUE_BELONG_CHANNEL_12 = "12";//其他渠道
    public static final String QUE_BELONG_CHANNEL_13 = "13";//天猫商城-中国移动天猫旗舰店
    public static final String QUE_BELONG_CHANNEL_14 = "14";//天猫网厅
    public static final String QUE_BELONG_CHANNEL_15 = "15";//信产部转办
    public static final String QUE_BELONG_CHANNEL_16 = "16";//信产部立案
    public static final String QUE_BELONG_CHANNEL_17 = "17";//客户来电
    public static final String QUE_BELONG_CHANNEL_18 = "18";//内部客户来函
    public static final String QUE_BELONG_CHANNEL_19 = "19";//客户来访
    public static final String QUE_BELONG_CHANNEL_20 = "20";//集团热线
    public static final String QUE_BELONG_CHANNEL_21 = "21";//中消协转
    public static final String QUE_BELONG_CHANNEL_22 = "22";//工信部自查
    public static final String QUE_BELONG_CHANNEL_23 = "23";//信产部清算司
    public static final String QUE_BELONG_CHANNEL_24 = "24";//信产部服务处
    public static final String QUE_BELONG_CHANNEL_25 = "25";//京东商城
    public static final String QUE_BELONG_CHANNEL_26 = "26";//质量万里行
    public static final String QUE_BELONG_CHANNEL_27 = "27";//腾讯
    public static final String QUE_BELONG_CHANNEL_28 = "28";//Email
    public static final String QUE_BELONG_CHANNEL_29 = "29";//国漫热线
    public static final String QUE_BELONG_CHANNEL_30 = "30";//终端服务厂商
    public static final String QUE_BELONG_CHANNEL_31 = "31";//总部转办
    public static final String QUE_BELONG_CHANNEL_32 = "32";//外部电商（浙江）中心
    public static final String QUE_BELONG_CHANNEL_33 = "33";//工信部化解
    public static final String QUE_BELONG_CHANNEL_34 = "34";//总部督办
    public static final String QUE_BELONG_CHANNEL_35 = "35";//10088人工
    public static final String QUE_BELONG_CHANNEL_36 = "36";//中移互联网
    public static final String QUE_BELONG_CHANNEL_37 = "37";//10088自动
    public static final String QUE_BELONG_CHANNEL_38 = "38";//315平台
    public static final String QUE_BELONG_CHANNEL_39 = "39";//苏宁-苏宁易购
    public static final String QUE_BELONG_CHANNEL_40 = "40";//热线自查
    public static final String QUE_BELONG_CHANNEL_41 = "41";//互联网监控
    public static final String QUE_BELONG_CHANNEL_42 = "42";//10086官方微博
    public static final String QUE_BELONG_CHANNEL_43 = "43";//综合部敏感信息
    public static final String QUE_BELONG_CHANNEL_44 = "44";//CEO信箱
    public static final String QUE_BELONG_CHANNEL_45 = "45";//10086999短信平台
    public static final String QUE_BELONG_CHANNEL_46 = "46";//集团热线预处理
    public static final String QUE_BELONG_CHANNEL_47 = "47";//巡视整改
    public static final String QUE_BELONG_CHANNEL_48 = "48";//外部客户来函
    public static final String QUE_BELONG_CHANNEL_49 = "49";//10080短信自助
    public static final String QUE_BELONG_CHANNEL_50 = "50";//通信管理局自查
    public static final String QUE_BELONG_CHANNEL_51 = "51";//企业监督热线
    public static final String QUE_BELONG_CHANNEL_52 = "52";//市政府热线
    public static final String QUE_BELONG_CHANNEL_53 = "53";//互联网转办
    public static final String QUE_BELONG_CHANNEL_54 = "54";//集团电录
    public static final String QUE_BELONG_CHANNEL_55 = "55";//公仆热线
    public static final String QUE_BELONG_CHANNEL_56 = "56";//局值班室
    public static final String QUE_BELONG_CHANNEL_57 = "57";//电台
    public static final String QUE_BELONG_CHANNEL_58 = "58";//10080转接
    public static final String QUE_BELONG_CHANNEL_59 = "59";//市场部

    //客服工单-影响度
    public static final String EFFECT_LEVEL_WEIGHTY = "1";//重大
    public static final String EFFECT_LEVEL_GRAVE = "2";//严重
    public static final String EFFECT_LEVEL_NORMAL = "3";//一般
    public static final String EFFECT_LEVEL_NONE = "4";//无

    //客服工单-事件性质
    public static final String EVENT_PROP_COMPLAIN = "1";//客户投诉
    public static final String EVENT_PROP_SYSFAULT = "2";//系统故障
    public static final String EVENT_PROP_BUSINWARING = "3";//业务可用性告警
    public static final String EVENT_PROP_PALTWARING = "4";//平台告警
    public static final String EVENT_PROP_ASKING = "5";//服务咨询

    //客服工单-是否我部责任
    public static final String DUTY_YES = "0";//是
    public static final String DUTY_NO = "1";//否

    //客服工单/投诉转办单-紧急程度
    public static final String PRIORITY_LEV_EMER = "1";//紧急
    public static final String PRIORITY_LEV_HIGE = "2";//高
    public static final String PRIORITY_LEV_MIDDLE = "3";//中
    public static final String PRIORITY_LEV_LOW = "4";//低

    //客服工单-是否升级投诉
    public static final String IS_UPPER_YES = "0";//是
    public static final String IS_UPPER_NO = "1";//是

    //客服工单-是否已解决
    public static final String IS_SOLVED_YES = "0";//已解决
    public static final String IS_SOLVED_NO = "1";//位解决

    //客服工单-是否归档
    public static final String ARCHIVE_YES = "0";//是
    public static final String ARCHIVE_NO = "1";//否

    //客服工单-事件结束代码
    public static final String EVENT_END_CODE_FAIL = "0";//不成功
    public static final String EVENT_END_CODE_DISAPPEAR = "1";//消失
    public static final String EVENT_END_CODE_MISTAKE = "2";//误报
    public static final String EVENT_END_CODE_IGNORED = "3";//可忽略
    public static final String EVENT_END_CODE_SUCCESS = "4";//成功解决
    public static final String EVENT_END_CODE_SOLVED = "5";//变通方法解决

    //客服工单-原因分类
    public static final String ONLINE_REASON_TYPE_BUG = "1";//BUG
    public static final String ONLINE_REASON_TYPE_CONFIG = "2";//配置问题
    public static final String ONLINE_REASON_TYPE_DATA = "3";//数据问题
    public static final String ONLINE_REASON_TYPE_OUT = "4";//外围因素
    public static final String ONLINE_REASON_TYPE_OPTIMIZE = "5";//需求优化
    public static final String ONLINE_REASON_TYPE_FAKE = "6";//投诉不属实
    public static final String ONLINE_REASON_TYPE_OTHER = "7";//其他

    /**
     * 是否
     * 是：1、否：0
     */
    public static final String YES = "1";
    public static final String NO = "0";

    /**
     * 工单紧急程度
     * 非常紧急:01、紧急:02、一般:03
     */
    public static final String URGENT_ID_01 = "01";
    public static final String URGENT_ID_02 = "02";
    public static final String URGENT_ID_03 = "03";

    /**
     * 工单类型
     * 客服投诉工单:1、OA投诉单:2、未完工单:3、投诉转办单:4、服务热线工单:5、
     * 网络热线工单:6、系统异常单:7、疑难投诉单:8、知识案例:9、通用任务工单：10
     * 集团管信 11
     */
    public static final String WRKFM_TYPE_ONLINE = "1";
    public static final String WRKFM_TYPE_OA = "2";
    public static final String WRKFM_TYPE_CRM = "3";
    public static final String WRKFM_TYPE_COMPLAIN = "4";
    public static final String WRKFM_TYPE_HOTLINE = "5";
    public static final String WRKFM_TYPE_INTERNET = "6";
    public static final String WRKFM_TYPE_SYSTEM = "7";
    public static final String WRKFM_TYPE_DIFFICULT = "8";
    public static final String WRKFM_TYPE_KNOWLEDGE = "9";
    public static final String WRKFM_TYPE_COMMON = "10";
    public static final String WRKFM_TYPE_BLOC_MANAGE_INFO = "11";

    /**
     * 生效、失效
     * 生效：1、失效：0
     */
    public static final String VALID_FLAG_YES = "1";
    public static final String VALID_FLAG_NO = "0";

    /**
     * 工单状态
     * 保存：1、活动：2、归档：3、删除：4、完成：5、已回复：6
     */
//    public static final String PROCESS_STATE_DRAFT = "1";
//    public static final String PROCESS_STATE_ACTIVE = "2";
//    public static final String PROCESS_STATE_ARCHIVE = "3";
//    public static final String PROCESS_STATE_DELETE = "4";
//    public static final String PROCESS_STATE_COMPLETE = "5";
//    public static final String PROCESS_STATE_REPLIED = "6";

    //工单状态--新
    public static final String SHEET_STS_DRAFT = "1";//草稿
    public static final String SHEET_STS_NEW = "2";//新建
    public static final String SHEET_STS_RENEW = "3";//重派
    public static final String SHEET_STS_TODO = "4";//待处理
    public static final String SHEET_STS_DOING = "5";//处理中
    public static final String SHEET_STS_FINISH = "6";//完成
    public static final String SHEET_STS_ARCHIVE = "7";//归档
    public static final String SHEET_STS_AUDIT = "8";//待审核
    public static final String SHEET_STS_AUDIT_FAIl = "9";//审核不通过
    public static final String PROCESS_STATE_EXCEPT_ARCHIVE = "1,2,3,4,5,6,8,9";



    /**
     * 流程环节
     * 受理：1、处理中：2、归档：3
     */
    public static final String NODE_TYPE_ACPT = "1";
    public static final String NODE_TYPE_DEAL = "2";
    public static final String NODE_TYPE_DONE = "3";

    //元素类型
    public static final String FCT_TYPE_INPUT = "1";//输入框
    public static final String FCT_TYPE_SELECT = "2";//下拉选
    public static final String FCT_TYPE_DATE = "3";//日期选择

    /**
     * 任务状态
     * 未认领：1、处理中：2、处理完成：3
     */
    public static final String TASK_STATE_WAIT = "1";
    public static final String TASK_STATE_DOING = "2";
    public static final String TASK_STATE_DONE = "3";

    /**
     * 整体时限状态
     * 未超时：01、即将超时：02、已超时：03、严重超时：04
     */
    public static final String ALL_TIME_LIMIT_NORMAL = "01";
    public static final String ALL_TIME_LIMIT_SOON = "02";
    public static final String ALL_TIME_LIMIT_OVER = "03";
    public static final String ALL_TIME_LIMIT_GRAVE = "04";

    /**
     * 操作类型
     */
    public static final String OP_TYPE_CREATE = "01";//新建派发
    public static final String OP_TYPE_RECREATE = "02";//重新派发
    public static final String OP_TYPE_DRAFT = "03";//保存草稿
    public static final String OP_TYPE_AUTO_DISPATCH = "04";//自动分单
    public static final String OP_TYPE_HUMAN_DISPATCH = "05";//手动分单
    public static final String OP_TYPE_TRANSFER = "06";//工单转派
    public static final String OP_TYPE_ARCHIVE = "07";//工单归档
    public static final String OP_TYPE_SMS_ARCHIVE = "071";//工单发短信并归档
    public static final String OP_TYPE_REJECT = "08";//工单驳回
    public static final String OP_TYPE_CLAIM = "09";//工单认领
    public static final String OP_TYPE_EXPORT = "10";//工单导出
    public static final String OP_TYPE_EDIT = "11";//工单修改
    public static final String OP_TYPE_SEND = "12";//工单派发（工单分派）
    public static final String OP_TYPE_FINISHED = "13";//工单完成

    public static final String OP_TYPE_URGE = "14";//催单
    public static final String OP_TYPE_SUGGEST = "15";//中途意见（追加意见）
    public static final String OP_TYPE_REPLAY = "16";//回单
    public static final String OP_TYPE_SHEET_SYN = "17";//未完工单同步
    public static final String OP_TYPE_TEL_CONTACT = "18";//电话沟通

    public static final String OP_TYPE_FILE_UPLOAD = "19";//上传附件
    public static final String OP_TYPE_FILE_DOWNLOAD = "20";//下载附件
    public static final String OP_TYPE_FILE_DELETE = "21";//删除附件
    public static final String OP_TYPE_SYNCRM = "22";//未完同步
    public static final String OP_TYPE_DIRECT_ARCHIVE = "23";//直接归档
    public static final String OP_TYPE_REPLY_ONLINE = "24";//回复客服
    public static final String OP_TYPE_TRANSFER_OTHER_GRP = "25";//工单跨组转派
    public static final String OP_TYPE_REPLY_OA = "26";//回复OA
    public static final String OP_TYPE_BACK = "27";//回退
    public static final String OP_TYPE_INTERNET_CREATE = "28";//网络热线接口立单
    public static final String OP_TYPE_INFORM_OA = "29";//通知OA
    public static final String OP_TYPE_BOMC = "30";//BOMC
    public static final String OP_TYPE_EDIT_OA = "31";//修改OA详情
    public static final String OP_TYPE_EDIT_PROBLEM_BELONG = "32";//修改问题归属

    public static final String OP_TYPE_CHECK_IN = "1";//签入
    public static final String OP_TYPE_CHECK_OUT = "0";//签出
    public static final String OP_TYPE_URGE_KF = "141";//客服催单
    public static final String OP_TYPE_SUGGEST_KF = "151";//客服中途意见
    public static final String OP_TYPE_SUGGEST_TO_KF = "152";//向客服中途意见
    public static final String OP_TYPE_SEND_NOTE = "153";//发送消息


    //分单方式
    public static final String ASSIGN_MODE_CD_AUTO = "1";//自动
    public static final String ASSIGN_MODE_CD_ACTION = "1";//人工

    //短信发送状态
    public static final byte MESSAGE_SEND_STS_SENT = 1;//已发送
    public static final byte MESSAGE_SEND_STS_UNSENT = 2;//未发送
    public static final byte MESSAGE_SEND_STS_FAIL = 3;//发送失败

    //外系统
    public static final String OUT_SYSTEM_OA = "OA";//OA
    public static final String OUT_SYSTEM_ONLINE = "ONLINE";//客服
    public static final String OUT_SYSTEM_CRM = "CRM";//CRM
    public static final String OUT_SYSTEM_SMS = "SMS";//短信

    //整体时限计算每次扫描条数
    public static final int SR_PROC_TIME_THREAD_HANDLE_COUNT = 2000;
    public static final int AUTO_ASSIGN_THREAD_HANDLE_COUNT = 1000;

    //虚拟处理人
    public static final String VIRTUAL_STAFF_OA = "-1";//OA处理人
    public static final String VIRTUAL_STAFF_ONLINE = "-2";//客服处理人
    public static final String VIRTUAL_STAFF_CRM = "-3";//CRM处理人

    //虚拟组织
    public static final String VIRTUAL_GROUP_OA = "-1";//OA
    public static final String VIRTUAL_GROUP_ONLINE = "-2";//ONLINE
    public static final String VIRTUAL_GROUP_CRM = "-3";//CRM

    //外系统工单关联状态
    public static final String OUT_STATE_SEND = "01";//外系统派发状态
    public static final String OUT_STATE_REPLAY = "02";//已回复外系统
    public static final String OUT_STATE_RESEND = "03";//再处理(外系统重派)
    public static final String OUT_STATE_ARCHIVE = "04";//外系统归档工单
    public static final String OUT_STATE_SYN = "05";//未完工单已同步
    public static final String OUT_STATE_INFORM_OA = "06";//已通知OA状态

    //接口调用方向
    public static final String INTER_INVOKE_OUT = "1";//调用外系统
    public static final String INTER_INVOKE_IN = "2";//被外系统调用

    //待办区工单最大导出量
    public static final String TO_BE_DEAL_MAX_EXPORT = "1000";

    //审核组
    public static final String AUDIT_GROUP = "AUDIT_GROUP_";
    //三级经理组
    public static final String THIRD_BOSS_STAFF = "THIRD_BOSS_STAFF";


    //短信类型
    public static final String SMS_TYPE_OVERTIME = "1";//超时提醒
    public static final String SMS_TYPE_OUT_CALLER_FAIL = "2";//接口调用异常告警
    public static final String SMS_TYPE_REMIND = "3";//帮助台催办提醒
    public static final String SMS_TYPE_SYN_COMPLETE = "4";//同步处理通知
    public static final String SMS_TYPE_SOONOVERTIME = "5";//预超时提醒
    public static final String SMS_TYPE_HOTLINE = "6";//人工处理通知
    public static final String SMS_TYPE_TOBEDEAL_ARRIVE = "7";//待办区到达提醒
    public static final String SMS_TYPE_NEW_SHEET_MONITOR = "8";//工单量突增提醒
    public static final String SMS_TYPE_POOL_SHEET_MONITOR = "9";//工单池积压提醒
    public static final String SMS_TYPE_POOL_ARRIVE = "10";//工单池到达提醒
    public static final String SMS_TYPE_SMS_MONITOR = "11";//短信监控提醒
    public static final String SMS_TYPE_KF_REMIND = "12";//客服催办提醒
    public static final String SMS_TYPE_ONLINE_STATISTIC = "14";//客服工单量通知
    public static final String SMS_TYPE_UPPER_SOONOVERTIME = "15";//升级预超时
    public static final String SMS_TYPE_SYSTEM_SOONOVERTIME = "16";//系统异常单即将超时通知
    public static final String SMS_TYPE_SYSTEM_OVERTIME = "17";//系统异常单已超时通知
    public static final String SMS_TYPE_PUSH_CCSERVER_AFTER = "18";//挂机后推送日志完下发短信

    public static final String SMS_TEMPLATE_CODE_TYPE = "SMS_TEMPLATE_CODE_TYPE";

    public static final Map<String, String> SYS_WRKFM_REL = new HashMap<String, String>(){{
        put(Constants.OUT_SYSTEM_ONLINE, Constants.WRKFM_TYPE_ONLINE);
        put(Constants.OUT_SYSTEM_OA, Constants.WRKFM_TYPE_OA);
        put(Constants.OUT_SYSTEM_CRM, Constants.WRKFM_TYPE_CRM);
    }};

    public static final Map<String, String> WRKFM_SYS_REL = new HashMap<String, String>(){{
        put(Constants.WRKFM_TYPE_ONLINE, Constants.OUT_SYSTEM_ONLINE);
        put(Constants.WRKFM_TYPE_OA, Constants.OUT_SYSTEM_OA);
        put(Constants.WRKFM_TYPE_CRM, Constants.OUT_SYSTEM_CRM);
    }};

    //短信发送号码
    public static final String SMS_SEND_NUM = "10086";//提醒

    //能力开放平台编码
    public static final String TJ_UNHT_SMSSEND = "TJ_UNHT_SMSSEND";//短信发送接口
    public static final String TJ_UNHQ_GetUserCustAccInfo = "TJ_UNHQ_GetUserCustAccInfo";//据号码查询相关三户资料

    //工单查询接口入参
    public static final String ALL_TIME = "0";//全部时间
    public static final String TODAY = "1";//今天
    public static final String NEARLI_THREE_DAYS = "2";//近三天
    public static final String NEARLI_ONE_WEEK = "3";//近一周

    //投诉转办单-派单标识
    public static final String CPL_SEND_FLAG_HUMAN = "01";//手工建单
    public static final String CPL_SEND_FLAG_AUTO = "02";//自动转单

    //投诉转办单-紧急度
    public static final String CPL_PRI_LEV_EMER = "1";//紧急
    public static final String CPL_PRI_LEV_HIGE = "2";//高
    public static final String CPL_PRI_LEV_MIDDLE = "3";//中
    public static final String CPL_PRI_LEV_LOW = "4";//低

    //投诉转办单-投诉来源
    public static final String CPL_SOURCE_ONLINE = "01";//客服投诉工单
    public static final String CPL_SOURCE_OPER = "02";//运营分析
    public static final String CPL_SOURCE_HOTLINE = "03";//服务热线
    public static final String CPL_SOURCE_OA = "04";//OA投诉单
    public static final String CPL_SOURCE_OA_UPPER = "05";//OA升级投诉
    public static final String CPL_SOURCE_INTERNET = "06";//网络热线工单

    //投诉转办单-原因分类
    public static final String REASON_TYPE_BUG = "1";//程序BUG
    public static final String REASON_TYPE_CONFIG = "2";//参数配置
    public static final String REASON_TYPE_DATAREASON = "3";//资料问题
    public static final String REASON_TYPE_BETTER = "4";//投诉优化
    public static final String REASON_TYPE_EXPLAIN = "5";//解决说明
    public static final String REASON_TYPE_OTHER = "6";//其它

    //OA投诉单/服务热线-问题归属
    public static final String ISSUE_BELONG_SYSTEM = "01";//系统问题
    public static final String ISSUE_BELONG_CHECK = "02";//协助查询

    //系统异常单-系统类型
    public static final String SYSTEM_TYPE_CRM = "1";//CRM系统
    public static final String SYSTEM_TYPE_BOMC = "2";//BOMC系统
    public static final String SYSTEM_TYPE_4A = "3";//统一用户认证平台4A
    public static final String SYSTEM_TYPE_OA = "4";//统一信息平台OA
    public static final String SYSTEM_TYPE_OTHER = "99";//其他

    //系统异常单-反映部门
    public static final String FEEDBACK_DEPT_KF = "01";//客服
    public static final String FEEDBACK_DEPT_HALL = "02";//营业厅
    public static final String FEEDBACK_DEPT_OTHER = "99";//其他部门

    //服务热线、网络热线工单受理渠道
    public static final String ACCEPT_CHANNEL_HOTLINE = "1";//服务热线
    public static final String ACCEPT_CHANNEL_HUMAN = "2";//网络热线-人工受理
    public static final String ACCEPT_CHANNEL_APP = "3";//网络热线--APP受理
    //客服立单派单工作组
    public static final String ONLINE_NEW_SEND_GROUP = "ONLINE_NEW_SEND_GROUP";
    //CRM立单派单工作组
    public static final String CRM_NEW_SEND_GROUP_FIRST = "CRM_NEW_SEND_GROUP_FIRST";
    //网络热线派单工作组
    public static final String INTERNET_NEW_SEND_GROUP = "INTERNET_NEW_SEND_GROUP";
    //OA立单派单工作组
    public static final String OA_NEW_SEND_GROUP_QT = "OA_NEW_SEND_GROUP_QT";//其他业务
    public static final String OA_NEW_SEND_GROUP_JK = "OA_NEW_SEND_GROUP_JK";//集客业务
    public static final String OA_NEW_SEND_GROUP_QK = "OA_NEW_SEND_GROUP_QK";//家客业务

    //一线工作组
    public static final String FRONT_LINE_GROUPID = "FRONT_LINE_GROUPID";
    public static final String SECOND_LINE_GROUPID = "SECOND_LINE_GROUPID";

    //知识案例默认审核组
    public static final String KNOWLEDGE_DEF_SEND_GROUP = "KNOWLEDGE_DEF_SEND_GROUP";

    //redis key前缀
    public static final String TENANT_ID_CACHE = "TENANT_ID_";//租户ID前缀
    public static final String CFG_CODE_CACHE = "CFG_CODE_CACHE:";//静态数据redis key前缀
    public static final String GROUP_CACHE = "GROUP_CACHE:";//工作组redis key前缀
    public static final String STAFF_CACHE = "STAFF_CACHE:";
    public static final String ORG_CACHE = "ORG_CACHE:";
    public static final String VIRTUAL_STAFF_CODE = "COMMON_CODE@VIRTUAL_STAFF";//虚拟员工code_type_cd
    public static final String VIRTUAL_GROUP_CODE = "COMMON_CODE@VIRTUAL_GROUP";//虚拟工作组code_type_cd
    public static final String VIRTUAL_ORGA_CODE = "COMMON_CODE@VIRTUAL_ORGAN";//虚拟部门code_type_cd
    public static final String CFG_CODE_CACHE_LOCK = "CFG_CODE_CACHE_LOCK";
    public static final String SIGN_CACHE = "SIGN_CACHE:";

    public static final String COMMON_EXPORT = "COMMON_EXPORT_";//导出前缀
    public static final String SSO_CHECK_TOKEN = "SSO_CHECK_TOKEN";
    public static final String AUTO_ASSIGN_NEED_CHK_LASTPERSON = "AUTO_ASSIGN_NEED_CHK_LASTPERSON_";
    public static final String AUTO_ASSIGN_NOT_NEED_CHK_LASTPERSON = "AUTO_ASSIGN_NOT_NEED_CHK_LASTPERSON_";

    //redis过期时间
    public static final Long EXPIRE_TIME = 24L;
    public static final Long EXPIRE_TIME_SIXTY_SECONDS = 60L;

    public static final Long EXPIRE_TIME_SECONDS = 60 * 60 * 24L;

    //分单标记 2不允许认领
    public static final String AFORM_FLAG_ASSIGNING = "2";
    public static final String AFORM_FLAG_CLAIMABLE = "0";

    public static final int HOUR_TRANSFER_SEC = 3600;
    //FTP连接模式
    public static final String FTP_PASSIVE = "1";//被动模式
    public static final String FTP_ACTIVE = "0";//主动模式

    //短信发送次数上限
    public static final Integer SMS_SEND_MAX_TIMES = 3;
    public static final int THOUSEND = 1000;
    public static final int MAXIMUMPOOLSIZE = 30;
    public static final long KEEPALIVETIME = 240L;
    public static final int COREPOOLSIZE = 1;
    public static final int TITLE_FONT_HEIGHT = 200;
    public static final int SIXTY = 60;

    public static final Integer ASSIGN_NUM = 1;//手动分单数量
    public static final Integer HOUR_OF_DAY_0 = 0;
    public static final Integer HOUR_OF_DAY_23 = 23;
    public static final Integer MINUTE = 59;
    public static final Integer ADD_MINUS_DAY_3 = -3;
    public static final Integer ADD_MINUS_DAY_7 = -7;
    public static final Integer ADD_MINUS_MONTH_1 = -30;
    public static final Integer ADD_MINUS_MONTH_3 = -90;
    public static final Integer ADD_MINUS_MONTH_12 = -365;

    public static final int TWO_HURDAND = 200;

    public static final String SYN_CRM_CODE = "TJ_UNHT_replyWorkSheet";


    public static final String OP_TYPE_CD_DISPATCHS = "04,05";//手动、自动分单
    public static final String OP_TYPE_ADD_OPINIONS = "15,151,152";//bomc追加、客服追加
    public static final String OP_TYPE_URGES = "14,141";//催单
    //接口日志表OUTCALL_TYPE_CD字段对应的值
    public static final String OUTCALL_TYPE_CD_SYNCRM = "01";//同步CRM
    public static final String OUTCALL_TYPE_CD_REPLYOA = "02";//回复OA
    public static final String OUTCALL_TYPE_CD_REPLYONLINE = "03";//回复客服
    public static final String OUTCALL_TYPE_CD_INFORM_OA = "04";//通知OA
    //工单接口匹配查询
    public static final String PROCESS_STATE_DOING = "b";
    public static final String PROCESS_STATE_DONE = "c";
    public static final String PROCESS_STATE_DOING_NAME = "处理中";
    public static final String PROCESS_STATE_DONE_NAME = "处理完成";

    //知识库审核结果
    public static final String AUDIT_RESULT_YES = "1";//通过
    public static final String AUDIT_RESULT_NO = "2";//不通过

    //新建派发派单深度
    public static final Integer SEND_LEVEL_CREAT = 0;
    public static final Integer SEND_LEVEL_FIRST = 1;

    //OA业务属性要素
    public static final String BUSI_ATTR_JK = "JK";//集客业务
    public static final String BUSI_ATTR_QK = "QK";//家客业务
    public static final String BUSI_ATTR_QT = "QT";//其他业务

    //判断展示发短信归档按钮的条件
    public static final String SEND_SMS_ARCHIVE_GROUP = "ONE_LINE_GROUP";//一线组
    public static final String BACK_ONE_SECOND_ONLINE_GROUP = "ONE_SECOND_LINE_GROUP";//一线、二线组
    public static final String SERVICE_OPERATION_MANAGMENT_GRP = "SERVICE_OPERATION_MANAGMENT_GROUP";//服务运营管理部
    public static final String SECOND_LINE_GROUP = "SECOND_LINE_GROUP";//二线组
    public static final String THIRD_LINE_GROUP = "THIRD_LINE_GROUP";//三线组
    //判断OA工单的当前处理组是否在一线组
    public static final String OA_ONE_LINE_GROUP = "ONE_LINE_GROUP";//一线组
    public static final String HELP_DESK = "HELP_DESK";
    public static final String OA_DETAIL_STATE_NEW = "1";//接单
    public static final String OA_DETAIL_STATE_RECEIVED = "2";//通知OA后
    public static final String OA_DETAIL_STATE_REPLYED = "3";//回复
    public static final String OA_DETAIL_STATE_RENEW = "4";//重派
    public static final String OA_DETAIL_STATE_ARCHIVE = "5";//归档
    
    //推送日志类型
    public static final String PUSH_TYPE_CHANNEL_LOG = "ChannelLog";//外线通话日志
    public static final String PUSH_TYPE_CALL_LOG = "CallLog";//呼叫日志
    public static final String PUSH_TYPE_DND_LOG = "DNDLog";//坐席置忙日志
    public static final String PUSH_TYPE_QUEUE_LOG = "QueueLog";//队列签入日志
    public static final String PUSH_TYPE_EXT_CHEXK_LOG = "ExtCheckLog";//分机签入日志
    public static final String PUSH_TYPE_AGENT_SCORE_LOG = "AgentScore";//满意度调查日志

    //推送日志后入短信表的模板
    public static final  String EVALUATE_SMS_CNTT_URL = "EVALUATE_SMS_CNTT_URL";
    public static final  String EVALUATE_SMS_CNTT_PARAMS = "EVALUATE_SMS_CNTT_PARAMS";//满意度评价参数

    //流程图判断处理组归属
    public static final String FLOW_CHART_GROUP_HELP_DESK = "1";//帮助台
    public static final String FLOW_CHART_GROUP_ONE_LINE = "2";//一线
    public static final String FLOW_CHART_GROUP_TWO_LINE = "3";//二线
    public static final String FLOW_CHART_GROUP_THREE_LINE = "4";//三线
    public static final String FLOW_CHART_GROUP_ONLINE = "5";//客服
    public static final String FLOW_CHART_GROUP_OA = "6";//OA
    public static final String FLOW_CHART_GROUP_CRM = "7";//CRM
    public static final String FLOW_CHART_GROUP_UPPER = "8";//升级审核
    public static final String FLOW_CHART_GROUP_RESEND = "9";//多派审核

//    //查询客服工单问题归属为空的工单状态
//    public static final String SHEET_STS_FINISH_ARCHIVE = "6,7";//完成和归档

    public static final  String CURRENT_STAFF_ID ="shinan";//投诉转办单的驳回条件

    public static final  String SOURCE_ROLE_CALLING ="外线";//源角色外线
    public static final  String SOURCE_ROLE_CALLED ="分机";//源角色分机
}