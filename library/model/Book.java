package org.example.library.model;

import lombok.Data;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class Book {
    //图书ID
    private Integer id;
    //书名
    private String bookName;
    //作者
    private String author;
    //数量
    private Integer count;
    //定价
    private BigDecimal price;
    //出版社
    private String publish;
    //状态 0-⽆效 1-允许借阅 2-不允许借阅
    private Integer status;
    private String statusCN;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
