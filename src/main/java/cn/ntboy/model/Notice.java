package cn.ntboy.model;

public class Notice {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.name
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.content
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.times
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String times;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.id
     *
     * @return the value of notice.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.id
     *
     * @param id the value for notice.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.name
     *
     * @return the value of notice.name
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.name
     *
     * @param name the value for notice.name
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.content
     *
     * @return the value of notice.content
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.content
     *
     * @param content the value for notice.content
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.times
     *
     * @return the value of notice.times
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getTimes() {
        return times;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.times
     *
     * @param times the value for notice.times
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }
}