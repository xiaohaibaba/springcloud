package com.lhy.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/02 0:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id;

    private Integer total;

    private Integer productId;

    private Integer used;

    private Integer  residue;
}



