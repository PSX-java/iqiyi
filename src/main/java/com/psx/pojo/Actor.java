package com.psx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.plaf.synth.Region;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private int id;
    private String name;
    private Date birthday;
    private String sex;
    private String description;
    private String pic;
    // 定于区域的属性:
    private List regions;
}