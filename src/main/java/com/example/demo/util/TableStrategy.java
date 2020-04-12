package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

public class TableStrategy {

    public static final String ACTIVE_TABLE = "{TABLE_NAME}{TENANT_ID}";

    public static final String YYYY = "{TABLE_NAME}{TENANT_ID}_{yyyy}";

    public static final String YYYYMM = "{TABLE_NAME}{TENANT_ID}_{yyyyMM}";

    public static final Map<String, String> TABLE_SPLITRULE = new HashMap(){{
        //业务表-年表
        put(TableConstants.t_wf_affix_info, YYYY);
        put(TableConstants.t_wf_complain_detail, YYYY);
        put(TableConstants.t_wf_crm_detail, YYYY);
        put(TableConstants.t_wf_difficult_detail, YYYY);
        put(TableConstants.t_wf_hotline_detail, YYYY);
        put(TableConstants.t_wf_internet_detail, YYYY);
        put(TableConstants.t_wf_knowledge_detail, YYYY);
        put(TableConstants.t_wf_oa_detail, YYYY);
        put(TableConstants.t_wf_online_detail, YYYY);
        put(TableConstants.t_wf_system_detail, YYYY);
        put(TableConstants.t_wf_workitem, YYYY);
        put(TableConstants.t_wf_problem_process, YYYY);
        put(TableConstants.t_wf_sms, YYYY);
        put(TableConstants.t_wf_rel_sys, YYYY);
        //业务表-月表
        put(TableConstants.t_wf_operate_lg, YYYYMM);
        put(TableConstants.t_wf_operate_detail, YYYYMM);
        //业务表-暂时不分表
        put(TableConstants.t_wf_out_call_log, ACTIVE_TABLE);
        put(TableConstants.t_wf_outter_attach, ACTIVE_TABLE);

        //配置表
        put(TableConstants.t_wf_assign_detail, ACTIVE_TABLE);
        put(TableConstants.t_wf_cfg_assign, ACTIVE_TABLE);
        put(TableConstants.t_wf_cfg_check_in, ACTIVE_TABLE);
        put(TableConstants.t_wf_cfg_check_in_log, ACTIVE_TABLE);
        put(TableConstants.t_wf_cfg_code, ACTIVE_TABLE);
        put(TableConstants.t_wf_cfg_max_amount, ACTIVE_TABLE);
        put(TableConstants.t_wf_transfer_group, ACTIVE_TABLE);
        put(TableConstants.t_wf_work_group_send, ACTIVE_TABLE);
        put(TableConstants.t_wf_time_limit_admin, ACTIVE_TABLE);
    }};

    private TableStrategy() {

    }

}
