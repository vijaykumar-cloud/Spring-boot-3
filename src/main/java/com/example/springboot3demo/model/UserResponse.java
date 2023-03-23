package com.example.springboot3demo.model;

import java.util.List;

public class UserResponse {
    private int page;
    private int perPage;
    private int total;
    private int totalPage;
    private List<User> data;

}

class Support {
    private String url;
    private String text;
}
