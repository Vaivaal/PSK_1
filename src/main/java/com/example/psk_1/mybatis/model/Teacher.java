package com.example.psk_1.mybatis.model;

public class Teacher {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TEACHER.ID
     *
     * @mbg.generated Mon Apr 08 20:37:25 EEST 2024
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TEACHER.NAME
     *
     * @mbg.generated Mon Apr 08 20:37:25 EEST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.TEACHER.SURNAME
     *
     * @mbg.generated Mon Apr 08 20:37:25 EEST 2024
     */
    private String surname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TEACHER.ID
     *
     * @return the value of PUBLIC.TEACHER.ID
     *
     * @mbg.generated Mon Apr 08 20:37:25 EEST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TEACHER.ID
     *
     * @param id the value for PUBLIC.TEACHER.ID
     *
     * @mbg.generated Mon Apr 08 20:37:25 EEST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TEACHER.NAME
     *
     * @return the value of PUBLIC.TEACHER.NAME
     *
     * @mbg.generated Mon Apr 08 20:37:25 EEST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TEACHER.NAME
     *
     * @param name the value for PUBLIC.TEACHER.NAME
     *
     * @mbg.generated Mon Apr 08 20:37:25 EEST 2024
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.TEACHER.SURNAME
     *
     * @return the value of PUBLIC.TEACHER.SURNAME
     *
     * @mbg.generated Mon Apr 08 20:37:25 EEST 2024
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.TEACHER.SURNAME
     *
     * @param surname the value for PUBLIC.TEACHER.SURNAME
     *
     * @mbg.generated Mon Apr 08 20:37:25 EEST 2024
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}