package com.suda.zph.passwordmanager.entity;

public class PassWord {
    private int id;
    private String source;
    private String user_name;
    private String user_password;
    private String create_time;
    private String mod_time;
    private int delete_flag;
    private String remarks;

    public PassWord(int id, String source, String user_name, String user_password, String create_time, String mod_time, int delete_flag, String remarks) {
        this.id = id;
        this.source = source;
        this.user_name = user_name;
        this.user_password = user_password;
        this.create_time = create_time;
        this.mod_time = mod_time;
        this.delete_flag = delete_flag;
        this.remarks = remarks;
    }

    public PassWord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getMod_time() {
        return mod_time;
    }

    public void setMod_time(String mod_time) {
        this.mod_time = mod_time;
    }

    public int getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(int delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "PassWord{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", create_time='" + create_time + '\'' +
                ", mod_time='" + mod_time + '\'' +
                ", delete_flag=" + delete_flag +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
