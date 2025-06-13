package com.jdk.handson.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    @JsonProperty("empid_i")
    private Integer empId;
    @JsonProperty("empName_s")
    private String empName;
    @JsonProperty("salary_d")
    private Double salary;
    @JsonProperty("phones_oa")
    private List<String> phones;
    @JsonProperty("email_s")
    private String email;
    @JsonProperty("department_s")
    private String department;
    @JsonProperty("ratings_s")
    private String ratings;
    @JsonProperty("city_s")
    private String city;

    public
    Employee (Integer empId,String empName,Double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public
    Employee (Integer empId , String empName,Double salary,String email) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.email = email;
    }

    @Override
    public
    String toString () {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
    }
}
