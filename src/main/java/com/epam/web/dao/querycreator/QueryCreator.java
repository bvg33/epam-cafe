package com.epam.web.dao.querycreator;

import com.epam.web.entity.User;

import java.util.*;

public class QueryCreator implements Creator {

    @Override
    public String createInsertQuery(String tableName,Map<String,String> fields) {
        String keys="(";
        String questionMark ="values(";
        Map<String,String> joiners=createInsertParameters(fields);
        String query="insert into "+ tableName+" "+keys+joiners.get("keysJoiner")+") "+questionMark
                +joiners.get("questionMarkJoiner")+")";
        return query;
    }

    @Override
    public String createUpdateQuery(String tableName, Map<String, String> fields) {
        String joiners=createUpdateParameters(fields);
        String query="update "+tableName+" set "+joiners+" where id="+fields.get("id");
        return query;
    }
    private String createUpdateParameters(Map<String,String> fields){
        StringJoiner joiner=new StringJoiner(",");
        for(Map.Entry<String,String>entry:fields.entrySet()){
            if(entry.getKey().equals("id")==false) {
                joiner.add(entry.getKey()+"=?");
            }
        }
        return joiner.toString();
    }

    private Map<String,String> createInsertParameters(Map<String,String> fields){
        StringJoiner keyJoiner =new StringJoiner(",");
        StringJoiner questionMarkJoiner=new StringJoiner(",");
        for(Map.Entry<String,String>entry:fields.entrySet()){
            if(entry.getKey().equals("id")==false) {
                keyJoiner.add(entry.getKey());
                questionMarkJoiner.add("?");
            }
        }
        Map<String,String> map =new HashMap<>();
        map.put("keysJoiner",keyJoiner.toString());
        map.put("questionMarkJoiner",questionMarkJoiner.toString());
        return map;
    }
}
