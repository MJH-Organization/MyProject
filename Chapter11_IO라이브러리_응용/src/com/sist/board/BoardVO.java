package com.sist.board;
import java.io.Serializable;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 *      => 파일 => ArrayList => 제어
 *      --------------------------
 *      1. Collection : 다수의 데이터를 저장하는
 *      
 *      List > ArrayList 
 *              1) add()
 *              2) set()
 *              3) remove()
 *              4) get()
 *              5) size()
 *              6) isEmpty90
 *              => 데이터 중복이 가능
 *              => 순서를 가지고있다
 *      Set > HashSet
 *      Map > HashMap         
 *              => 웹에서 가장 많이 사용되는 라이브러리
 *              => 키와 값
 *              => 키는 중복(X), 값은 중복
 *              => MyBatis => 키, SQL
 *              => Spring => 키, class
 */
// 캡슐화 / 오버라이딩 => 포함
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO implements Serializable{

    private int no;     // 게시물 번호
    private String name;    // 글쓴이
    private String subject; // 제목
    private String content; // 내용
    private String pwd;     // 비밀번호 => 본인여부 확인
    private Date regdate;   // 작성일
    private int hit;        // 조회수
    
}
