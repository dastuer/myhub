package com.diao.myhub.model;

import lombok.Data;

@Data
public class Great {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column great.id
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column great.user_id
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column great.like_id
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    private Long likeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column great.type
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    private Short type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column great.status
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    private Short status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column great.id
     *
     * @return the value of great.id
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column great.id
     *
     * @param id the value for great.id
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column great.user_id
     *
     * @return the value of great.user_id
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column great.user_id
     *
     * @param userId the value for great.user_id
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column great.like_id
     *
     * @return the value of great.like_id
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public Long getLikeId() {
        return likeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column great.like_id
     *
     * @param likeId the value for great.like_id
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column great.type
     *
     * @return the value of great.type
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public Short getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column great.type
     *
     * @param type the value for great.type
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column great.status
     *
     * @return the value of great.status
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column great.status
     *
     * @param status the value for great.status
     *
     * @mbg.generated Sun Aug 29 00:53:16 CST 2021
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}
