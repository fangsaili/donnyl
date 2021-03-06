package com.example.wiki.mapper;

import com.example.wiki.entity.Award;
import com.example.wiki.entity.AwardExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AwardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    long countByExample(AwardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    int deleteByExample(AwardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    int insert(Award record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    int insertSelective(Award record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    List<Award> selectByExample(AwardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    Award selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Award record, @Param("example") AwardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Award record, @Param("example") AwardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Award record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table award
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Award record);
}