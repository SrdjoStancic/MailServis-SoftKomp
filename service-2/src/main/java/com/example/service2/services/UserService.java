package com.example.service2.services;

import com.example.service2.entities.NotificationTime;
import com.example.service2.entities.User;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserService {

    private HttpClient http;

    public UserService() {
    }

    public ArrayList<User> getHourlyUsers(){
        http = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:8081/users/hourly");
        get.setHeader("Content-Type", "application/json");

        return  executeHttpRequest(get);
    }
    public ArrayList<User> getDailyUsers(){
        http = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:8081/users/daily");
        get.setHeader("Content-Type", "application/json");
        return executeHttpRequest(get);
    }
    public ArrayList<User> getWeeklyUsers(){
        http = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:8081/users/weekly");
        get.setHeader("Content-Type", "application/json");
        return  executeHttpRequest(get);
    }

    private ArrayList<User> executeHttpRequest(HttpGet get){
        try {
            HttpResponse response = http.execute(get);


            if(response.getStatusLine().getStatusCode() == 200){
                String rawResponse = EntityUtils.toString(response.getEntity());
                ObjectMapper mapper = new ObjectMapper();
                ArrayList<LinkedHashMap<String,String>> usersResponse =  (ArrayList<LinkedHashMap<String,String>>)mapper.readValue(rawResponse, List.class);
                ArrayList<User> users = new ArrayList<User>();
                for (LinkedHashMap<String,String> map: usersResponse) {
                    NotificationTime time= NotificationTime.HOURLY;
                    switch (map.get("notificationTime")){
                        case "HOURLY":{
                            time = NotificationTime.HOURLY;
                            break;
                        }case "DAYLY":{
                            time = NotificationTime.DAYLY;
                            break;
                        }case "WEEKLY":{
                            time = NotificationTime.WEEKLY;
                            break;
                        }
                    }
                    User u = new User(map.get("id"),map.get("email"),map.get("password"),time);
                    users.add(u);
                }
                return users;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
