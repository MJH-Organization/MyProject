package com.sist.vo;

import lombok.Data;

/**
 *      1|
 *      양화진외국인선교사묘원|
 *      양화진외국인선교사묘원은 서울 마포구 합정동에 위치한 외국인 선교사들의 공동묘지이다.|
 *      04084 서울 마포구 양화진길 46 (합정동, 양화진홍보관) 
 */

@Data
public class SeoulVO {
    private String no;
    private String name;
    private String content;
    private String address;
    
    // 다른 클래스에서 사용이 가능하다록   => 메서드 (기능 부여)
    // 캡슐화

}
