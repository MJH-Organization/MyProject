package com.sist.contraller;

import java.util.HashMap;
import java.util.Map;

import com.sist.model.BoardDelete;
import com.sist.model.BoardDetail;
import com.sist.model.BoardFind;
import com.sist.model.BoardList;
import com.sist.model.BoardUpdate;
import com.sist.model.BoardWrite;
import com.sist.model.Model;

/**
 *      사용자 요청  ====> Contraller <====> Model
 *                                        BoardList 
 *                                        BoardDelete 
 *                                        BoardDetail 
 *                                        BoardUpdate 
 *                                        BoardFind 
 *          => 처리
 */
public class Controller {
    public void service (String cmd)
    {
        Map map = new HashMap();
        map.put("list", new BoardList());
        map.put("write", new BoardWrite());
        map.put("update", new BoardUpdate());
        map.put("find", new BoardFind());
        map.put("detail", new BoardDetail());
        map.put("delete", new BoardDelete());
        
        Model model=(Model)map.get(cmd);
        model.execute();
//        if (cmd.equals("list"))
//        {
//            BoardList b=new BoardList();
//            b.execute();
//            
//        }
//        else if(cmd.equals("detail"))
//        {
//            BoardDetail b=new BoardDetail();
//            b.execute();
//        }
//        else if(cmd.equals("update"))
//        {
//            BoardUpdate b=new BoardUpdate();
//            b.execute();
//        }
//        else if(cmd.equals("find"))
//        {
//            BoardFind b=new BoardFind();
//            b.execute();
//        }
//        else if(cmd.equals("write"))
//        {
//            BoardWrite b=new BoardWrite();
//            b.execute();
//        }
    }

}
