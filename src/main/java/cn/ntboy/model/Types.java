package cn.ntboy.model;

public class Types {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column types.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column types.name
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column types.id
     *
     * @return the value of types.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column types.id
     *
     * @param id the value for types.id
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column types.name
     *
     * @return the value of types.name
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column types.name
     *
     * @param name the value for types.name
     *
     * @mbg.generated Thu Oct 24 11:24:48 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}