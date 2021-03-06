package cn.ntboy.model;

import lombok.Data;

@Data
public class Admin {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.name
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.pwd
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String pwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.authority
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String authority;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.id
     *
     * @return the value of admin.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.id
     *
     * @param id the value for admin.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.name
     *
     * @return the value of admin.name
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.name
     *
     * @param name the value for admin.name
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.pwd
     *
     * @return the value of admin.pwd
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.pwd
     *
     * @param pwd the value for admin.pwd
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.authority
     *
     * @return the value of admin.authority
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.authority
     *
     * @param authority the value for admin.authority
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }
}