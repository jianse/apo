package cn.ntboy.model;

public class Orders {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.menuid
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String menuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.userid
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.menunum
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String menunum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.times
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String times;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.delivery
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String delivery;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.id
     *
     * @return the value of orders.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.id
     *
     * @param id the value for orders.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.menuid
     *
     * @return the value of orders.menuid
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getMenuid() {
        return menuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.menuid
     *
     * @param menuid the value for orders.menuid
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.userid
     *
     * @return the value of orders.userid
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.userid
     *
     * @param userid the value for orders.userid
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.menunum
     *
     * @return the value of orders.menunum
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getMenunum() {
        return menunum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.menunum
     *
     * @param menunum the value for orders.menunum
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setMenunum(String menunum) {
        this.menunum = menunum == null ? null : menunum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.times
     *
     * @return the value of orders.times
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getTimes() {
        return times;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.times
     *
     * @param times the value for orders.times
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.delivery
     *
     * @return the value of orders.delivery
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getDelivery() {
        return delivery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.delivery
     *
     * @param delivery the value for orders.delivery
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setDelivery(String delivery) {
        this.delivery = delivery == null ? null : delivery.trim();
    }
}