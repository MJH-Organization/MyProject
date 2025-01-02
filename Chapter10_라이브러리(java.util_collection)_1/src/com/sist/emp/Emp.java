package com.sist.emp;
import java.util.*;

import lombok.Data;
// 클래스는 한개에 대한 정보   => 저장 new를 사용하면 여러개를 저장
@Data
public class Emp {

    private int empno;      // 사번
    private String ename;   // 이름
    private String job;     // 직위
    private int mgr;        // 사수 번호
    private Date hireDate;  // 입사일
    private int sal;        // 급여
    private int comm;       // 성과급
    private int deptno;     // 부서번호
}
