package com.lcw.exerciseback.api;

public enum ReturnCode {

    OPERATE_SUCCESS(0, "操作成功"),

    OPERATE_FAIL(9999, "操作失败"),

    PARAM_FAIL_CODE(1001, "参数异常"),

    DUPLICATE_KEY_CODE(1002, "数据重复"),

    VALIDATION_CODE(1003, "参数校验异常"),

    THIRD_INTERFACE_ERR(1004, "查询第三方接口报错"),

    ROLE_HAS_ADDED(1005, "该用户已经添加角色，请勿重复添加"),

    NOT_GET_DATA(1006, "没有获取到数据，请稍后重试"),

    HAS_NO_CODE(1007, "数据不存在code标识"),

    FILE_IS_TRANS(1008, "预览转码中，请稍后预览"),

    FAILED_TO_DECRYPT(1009, "解密消息体失败"),

    PARAM_TYPE_ERROR(1010, "传参类型或格式错误"),

    CHOOSE_TASK_TYPE(1011, "请选择/输入任务类型"),

    RESULT_IS_SUBMIT(1012, "成果已提交"),

    SAVE_DATA_REPEAT(1013, "保存的任务期数时间有交叉"),

    DATA_EXISTS_DATABASE(1014, "保存的任务期数时间与数据库中有交叉"),

    TIME_START_AFTER_END(1015, "开始时间大于结束时间"),

    NOT_SELECT_ALLOW_CHANGE(1016, "请选择是否允许修改"),

    RESULT_HAS_AUDIT(1017, "成果已审核"),

    USER_NO_LOGIN(1018, "用户未登录，请重新登录"),

    RESULT_BEEN_SUBMIT(1019, "成果已被修改提交"),

    ACTIVITY_TYPE_IS_NULL(1020, "请输入活动类型名称"),

    ACTIVITY_IS_REPEAT(1021, "当前学年学期该主题名称重复"),

    TASK_PERIOD_ERROR(1022, "请选择正确的日期(各期任务之前时间不允许重合、后面期数不能早于前面期数的时间、不能超出整体的开始和结束日期)"),

    OVER_START_AND_END(1023, "各期任务时间不能超出整体的开始和结束日期"),

    CANNOT_GET_XN_XQ(1024, "无法获取当前学年学期，请联系系统管理员"),

    TASK_PERIOD_NUM_ERROR(1025, "任务期数和新增期数不符"),

    RECORD_HAS_AUDIT(1026, "记录已被审核"),

    RECORD_HAS_SUBMIT(1027, "记录已被提交"),

    UPLOAD_SINGLE_FILE_ERROR(1028, "上传文件失败"),

    DATA_NOT_SELECT(1029, "请选择需要导出的数据"),

    DOWNLOAD_FILE_FAIL(1030, "下载文件失败"),

    FILE_HAS_UPLOADED(1031, "文件已上传过"),

    DOWNLOAD_ZIP_FAILED(1032, "打包zip下载失败"),

    FILE_SIZE_OVER_LIMIT(1033, "文件大小超过50M"),

    DATA_ERROR(1034, "数据异常"),

    TASK_PERIOD_NULL(1035, "选择自由添加时，任务期数只能为1到30"),

    PERIOD_NOT_EXIST(1036, "当前期数不存在"),

    ITEM_DETAIL_REPEAT(1037, "检查小项重复，请修改"),

    TEACHER_AT_LEAST_ONE(1038, "值岗教师请至少设置一天"),

    SYSTEM_INIT_DATA(1039, "系统还未初始化，请联系管理员"),

    ON_DUTY_TEACHER_PARAM_NULL(1040, "设置值岗教师传参为空或不存在"),

    ON_DUTY_RELEASED(1041, "值岗评比已发布"),

    DUTY_SQUADRON_HAS_SET(1042, "该期值周中队已设置"),

    REMARK_HAS_FILL(1043, "原因已标注，不允许修改"),

    NEED_FILL_REASON(1044, "打分结果为差时必须填写详细原因"),

    NOT_ALLOW_REPEAT_UPDATE(1045, "数据已修改，不允许重复修改"),

    AT_LEAST_ONE_ITEM(1046, "请至少设置一个检查项"),

    TEACHER_NOT_EXIST(1047, "教师不存在"),

    TEACHER_SET_TYPE_NOT_NULL(1048, "值岗教师设置方式不能为空"),

    ITEM_IS_REPEAT(1049, "评比项名称有重复"),

    PERIOD_START_TIME_NOT_EMPTY(1050, "期数开始时间不能为空"),

    PERIOD_END_TIME_NOT_EMPTY(1051, "期数结束时间不能为空"),

    TEACHER_SET_TYPE_NOT_EMPTY(1052, "值岗教师设置方式不能为空"),

    DUTY_TITLE_NOT_EMPTY(1053, "值岗评比标题不能为空"),

    PERIOD_OR_DAY_NOT_EXIST(1054, "周期(调)或打分日(调)不在范围内"),

    TASK_TYPE_OVER_LIMIT(1055, "任务类型重复或超过50字符"),

    PERIOD_TEACHER_NOT_SET(1056, "存在周期未设置值周教师"),

    YEAR_OR_TERM_NULL(1057, "请传学年学期"),

    ONDUTY_EDIT_TIMEOUT(4001, "该值岗评比已经结束，不能修改！"),

    ONDUTY_SCORE_DAY_NOT(4002, "该日期不是打分日"),

    ONDUTY_NOT_SCORE(4003, "存在未打分的数据"),

    ITEM_DETAIL_ID_IS_NULL(4004, "检查小项ID不能为空"),

    CLASS_NOT_NEED_SCORE(4005, "当天该班级没有需要参加的学生值岗评比。"),

    NOT_SET_SQUADRON(4006, "德育管理老师未设置本期值周中队，还无法进行值周打分哦~"),

    ON_DUTY_PASS_ERROR(4007, "密码错误，请重新输入");

    private int code;
    private String message;

    ReturnCode(int statusCode, String message) {
        this.code = statusCode;
        this.message = message;
    }

    public static String getMessage(int code) {
        for (ReturnCode c : ReturnCode.values()) {
            if (c.getCode() == code) {
                return c.message;
            }
        }
        return "";
    }

    public int getCode() {
        return code;
    }

    public String getCodeStr() {
        StringBuilder str = new StringBuilder();
        String codeStr = str.append(code).toString();
        return codeStr;
    }

    public String getMessage() {
        return message;
    }
}