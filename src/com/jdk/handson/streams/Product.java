package com.jdk.handson.streams;


import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Product{

    private String name;

    private String category;

    private int price;

    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }
}
