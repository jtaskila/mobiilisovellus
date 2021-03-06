package com.example.pienyritysappi;

public class Globals {
    private static Globals instance;
    private static String api_key;
    private static String user_id;
    private static int user_type;

    private Globals(){
    }

    public static void setApi_key(String apikey){
        Globals.api_key = apikey;
    }

    public static String getApi_key(){
        return Globals.api_key;
    }

    public static void setUser_id(String user_id){
        Globals.user_id = user_id;
    }

    public static String getUser_id(){
        return Globals.user_id;
    }

    public static void setUser_type(int userType){
        Globals.user_type = userType;
    }

    public static int getUser_type(){
        return Globals.user_type;
    }

    public static synchronized Globals getInstance(){
        if (instance == null){
            instance = new Globals();
        }
        return instance;
    }
}
