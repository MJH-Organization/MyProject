package com.sist.map;
import java.util.*;
public class Container {
    private Map<String, Model> clsMap=new HashMap<String, Model>();
    
    public Container()
    {
        clsMap.put("board", new BoardModel());
        clsMap.put("recipe", new RecipeModel());
        clsMap.put("mypage", new MyPageModel());
        clsMap.put("food", new FoodModel());
        clsMap.put("member", new MemberModel());
    }
    
    public Model getBean(String key)
    {
        return clsMap.get(key);
    }
}
