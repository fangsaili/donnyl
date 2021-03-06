package com.example.wiki.entity;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table skill
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Skill implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skill.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skill.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skill.percentage
     *
     * @mbg.generated
     */
    private Integer percentage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column skill.color
     *
     * @mbg.generated
     */
    private String color;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table skill
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skill.id
     *
     * @return the value of skill.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skill.id
     *
     * @param id the value for skill.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skill.name
     *
     * @return the value of skill.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skill.name
     *
     * @param name the value for skill.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skill.percentage
     *
     * @return the value of skill.percentage
     *
     * @mbg.generated
     */
    public Integer getPercentage() {
        return percentage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skill.percentage
     *
     * @param percentage the value for skill.percentage
     *
     * @mbg.generated
     */
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column skill.color
     *
     * @return the value of skill.color
     *
     * @mbg.generated
     */
    public String getColor() {
        return color;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column skill.color
     *
     * @param color the value for skill.color
     *
     * @mbg.generated
     */
    public void setColor(String color) {
        this.color = color;
    }
}