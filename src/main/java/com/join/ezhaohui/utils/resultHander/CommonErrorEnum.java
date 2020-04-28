package com.join.ezhaohui.utils.resultHander;

public enum CommonErrorEnum {

    SYSTEM_ERROR("-001","系统异常"),
    BAD_REQUEST("-002","错误的请求参数"),
    NOT_FOUND("-003","找不到请求路径！"),
    CONNECTION_ERROR("-004","网络连接请求失败！"),
    METHOD_NOT_ALLOWED("-005","不合法的请求方式"),
    DATABASE_ERROR("-004","数据库异常"),
    BOUND_STATEMENT_NOT_FOUNT("-006","找不到方法！"),
    SUCCESS_OPTION("005","操作成功！"),
    FAIL_GETDATA("-008","获取信息失败"),
    BAD_REQUEST_TYPE("-009","错误的请求类型"),
    NO_RECORD("016","没有查到相关记录"),
    LOGIN_SUCCESS("017","登录成功"),
    LOGOUT_SUCCESS("018","已退出登录"),
    SENDEMAIL_SUCCESS("019","邮件已发送，请注意查收"),
    EDITPWD_SUCCESS("020","修改密码成功"),
    NO_FILESELECT("021","未选择文件"),
    FILEUPLOAD_SUCCESS("022_1","上传成功"),
    FILEUPLOAD_FAIL("022_0","上传失败"),
    FILEUPLOAD_FAIL_MUCH("022_3","上传过多"),
    FILEUPLOAD_FAIL_URL("022_4","无效URL"),
    FILEUPLOAD_FAIL_SAME("022_5","相同URL"),
    NOLOGIN("023","未登陆"),
    ILLEGAL_ARGUMENT("024","参数不合法"),
    ERROR_VERIFYCODE("025","验证码不正确"),
    NO_VERIFYCODE("026","缺少验证码"),
    REFRESH_VERIFYCODE("027","需要刷新验证码"),
    NO_VERIFY_EMAIL("028","未验证邮箱"),
    BAN_LOGIN("029","当前用户已被禁止登录"),
    WAIT_VERIFY_EMAIL("030","注册成功，请验证邮箱以激活账户"),
    NOT_EXIST_EMAIL("031","当前邮箱地址可用"),
    FAILED_CREATEUSER("032","创建用户失败,用户名已被使用"),
    VERIFYED_EMAIL("033","当前邮箱已验证，请勿重复验证"),
    FAILED_AUTH("041", "非法请求，请登录后操作"),
    FIRST_DOWNLOAD("042", "首次下载"),
    INVALID_USER("043","用户名或密码错误"),
    AUTHENTIC_FAIL("044","验证失败"),
    REGISTER_SUCCESS("045","注册成功"),
    REGISTER_FAILED("046","注册失败"),
    NULL_PARAMS("047","用户名或密码不能为空"),
    ALREADY_LOGINED("048","当前用户已登录"),
    POWER_REQUIRED("049","权限不足"),
    LOGIN_REQUIRED("050","用户未登录")
    ;



    private String code;

    private String msg;

    CommonErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
