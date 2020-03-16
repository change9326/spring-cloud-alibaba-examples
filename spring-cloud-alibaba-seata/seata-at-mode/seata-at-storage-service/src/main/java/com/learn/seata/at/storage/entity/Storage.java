package com.learn.seata.at.storage.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * t_storage
 * @author 
 */
@Data
public class Storage extends Model<Storage> implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String commodityCode;

    private Integer count;

    private static final long serialVersionUID = 1L;
}