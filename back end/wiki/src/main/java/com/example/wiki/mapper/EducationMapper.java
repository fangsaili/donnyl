package com.example.wiki.mapper;

import com.example.wiki.entity.Education;
import com.example.wiki.entity.EducationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EducationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    long countByExample(EducationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int deleteByExample(EducationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int insert(Education record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int insertSelective(Education record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    List<Education> selectByExampleWithBLOBs(EducationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    List<Education> selectByExample(EducationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    Education selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Education record, @Param("example") EducationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") Education record, @Param("example") EducationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Education record, @Param("example") EducationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Education record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(Education record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table education
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Education record);
}