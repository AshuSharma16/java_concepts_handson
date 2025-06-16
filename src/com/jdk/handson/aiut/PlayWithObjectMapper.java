package com.jdk.handson.aiut;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayWithObjectMapper {
    public static void main(String[] args){

        //1.  pass json as file and Map to Employee Object Bean using File object
                System.out.println( "Employee Object Bean : -" + mapJsonFileToEmployee());

        //2.  pass json as string and map to Employee Object Bean
                String jsonString="{\r\n\"email\": \"bcavill0@statcounter.com\",\r\n\"first_name\": \"Birgit\",\r\n\"gender\": \"Female\",\r\n\"id\": 1,\r\n\"last_name\": \"Cavill\"\r\n}";
                System.out.println( "Employee Object Bean : -" +  mapJsonStringToEmployee(jsonString));


        //3. pass jsonfile as  fully qualified path and  map to Employee Object Bean
                System.out.println( "Employee Object Bean : -" +  mapJsonfileToEmployee("com/jdk/handson/aiut/EmployeejsonObject.json"));


        //4.  pass json as file and Map to EmployeeList Bean using File object
                 System.out.println(mapJsonFileToEmployeeListType());

    }

    private static Employee mapJsonfileToEmployee(String path){
        ObjectMapper mapper = new ObjectMapper();

        Employee employees = null;
        try {
            JsonNode stringNode = mapper.readTree(new ClassPathResource(path).getInputStream());
            final String jsonString = mapper.writeValueAsString(stringNode);
            JSONObject jsonObject = new JSONObject(jsonString);
            employees = mapper.readValue(jsonObject.toString(),Employee.class);
        } catch (IOException e) {
            System.out.println("exception occur while parshing json file : "+ e);
        }
        return employees;
    }

    static List<com.jdk.handson.completablefeature.Employee> mapJsonFileToEmployeeListType() {
        ObjectMapper mapper = new ObjectMapper();
        List<com.jdk.handson.completablefeature.Employee> employees = new ArrayList<>();
        try {
            employees = mapper.readValue(new File("employees.json"),new TypeReference<List<com.jdk.handson.completablefeature.Employee>>() {
            });
            System.out.println("Total Employee : "+ employees.size());
        } catch (IOException e) {
            System.out.println("exception occur while parshing json file : "+ e);
        }

        return employees;
    }

    static Employee mapJsonFileToEmployee() {
        ObjectMapper mapper = new ObjectMapper();
        Employee employees = null;
        try {
            employees = mapper.readValue(new File("EmployeejsonObject.json"),Employee.class);
        } catch (IOException e) {
            System.out.println("exception occur while parshing json file : "+ e);
        }
        return employees;
    }

    static Employee mapJsonStringToEmployee(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Employee employees = null;
        try {
            employees = mapper.readValue(jsonString,Employee.class);
        } catch (IOException e) {
            System.out.println("exception occur while parshing json file : "+ e);
        }
        return employees;
    }
}
