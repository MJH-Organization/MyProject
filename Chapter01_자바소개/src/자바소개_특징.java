// ctrl + space 
// sysout / sout 
// 주석 ==> 한줄 주석 ==> 가독성 
/*
 *   여러줄 주석 
 *   
 *   1. 변수 : 데이터형 (메모리에 저장하는 크기) 
 *      ================================
 *       데이터 저장 : 메모리에 저장 => RAM (프로그램 종료시에 사라진다)
 *                  => 파일 / RDBMS(오라클) => 공유 데이터
 *   2. 사용자 요청 따라 처리 (데이터 처리) 
 *       => 연산자 / 제어문 
 *   3. 여러개를 동시에 저장 
 *       => 같은 데이터만 저장 (정수,실수...) 배열 
 *       => 다른 데이터 저장 : 클래스 (********)
 *                           | 재사용 (수정 / 추가) 
 *   4. 데이터 모아서 관리 : 배열,클래스 
 *      명령문을 모아서 관리 
 *      =============== 메소드 
 *   5. 객체 지향 프로그램 
 *      = 가독성 
 *      = 재사용
 *      = 최적화 
 *      
 *   6. 예외처리 : 종료하지 않는 프로그램 
 *   ==================================== 기본 문법 
 *   7. 라이브러리 : 자바에서 지원하는 기능 (클래스/메소드) 
 *      ========
 *        IO / 네트워크 
 *        =========== Web 프로그램 
 *   8. 미니프로젝트 : 파일기반 
 *   
 *   =========================================
 *   2page 
 *   자바 실행 과정 
 *   ===========
 *    => 프로그램 언어 : C/C++,Java,C#,Python....
 *       ==========
 *       | 자바언어는 프로그래머만 인식하는 언어 => 컴파터는 모르는 언어 
 *       | => 컴퓨터가 인식할 수 있게 변경 => 컴파일 
 *            =====(0,1)
 *            예) 'A' => 65 ==> 100001
 *                => 모든 문자마다 번호를 가지고 있다 (UniCode)
 *                => 0~65535
 *    => C/C++ => A.c ====> A.obj ====> A.exe
 *                         ======= 컴파일된 파일 
 *                               | 바이트 코드 : 모든 운영체제에서 동일하게 사용
 *                               | 배포 
 *    => Java  => A.java ====> A.class ======> 화면 출력  
 *                       javac          java
 *                       ======         =====
 *                       컴파일            한줄씩 읽어서 출력 
 *                                          |
 *                                         인터프리터 
 *       => 소스 검증 (2번 : 컴파일 / 실행시) => 보안 
 *       => 제임스 고슬링 : 자바는 절대 해킹이 어렵다 
 *   ====================================== 5page 이미지 참조
 *       ** 이클립스는 코딩시마다 자동 컴파일이 된다 
 *                          ========= 바로 에러 출력 
 *          javac는 자동 처리 => java(실행) => ctrl+F11
 *          
 *   6page : 개발환경 구축 
 *   1. JDK => jdk.java.net/17 (다운로드 위치) 
 *      => oracle / openjdk (무료) 
 *         => 1.8이상은 유료 
 *            === 호환성이 가장 좋다 (SUN)
 *      => Spring Framework => 11버전까지 사용이 가능  
 *         Spring - Boot => 17버전 이후
 *      => 버전 호환 단점 
 *   2. 환경 설정 
 *      내PC => 속성 => 고급시스템 설정 => 환경변수 선택 
 *      => 시스템 설정 
 *         classpath : .;c:\jdk17.0.2\lib
 *         path : c:\jdk17.0.2\bin 
 *      => 리눅스 : .bashrc
 *   3. 편집기 
 *      => Eclipse : IBM => 통합 개발 툴 (IDE) => 무료 
 *          => Back-End (Java/Web/Spring)
 *          => eclipse.org
 *      => 인텔리J : Back-End / Front-End 
 *         => 무료 / 유료 
 *      => File => new => JavaProject선택 => 프로젝트 폴더 생성 
 *         => src안에 클래스를 만들어서 사용 
 *                   =====
 *                   | 프로그램의 시작점 => main
 *                   
 *      주의점) ==> 19page 
 *      1. 자바파일명과 클래스명은 동일해야 된다 
 *      2. 대소문자를 구분 
 *         *** 자바개발자의 약속 
 *             1) 클래스명은 대소문자로 시작한다 
 *                MainClass => 헝거리언씩 표기법 
 *                Main_class
 *             2) 변수 / 메소드 => 소문자로 시작 
 *             3) 상수 => 전체를 대문자 
 *             4) 가급적이면 의미를 부여 
 *                a 
 *                movie_name
 *                
 *                a,b,c 
 *                kor,eng,math(3~7)
 *      3. 문장이 종료(명령어) => ; => .
 *         오라클 => ;
 *         
 *      4. 변수 : 변경이 가능 
 *         int age;
 *         상수 : 변경이 불가능 
 *         final int AGE;
 *         리터럴 : 실제 저장된 값
 *         age=20;
 *         
 *      => 23page 
 *      자바의 구성요소 
 *      public class ClassName => 클래스 시작 
 *      {
 *         // 프로그램 시작점 => 모든 프로그램은 반드시 main 1개가 존재
 *         public static void main(String[] arg)
 *         { => 메소드 시작 
 *           ==> 기능 수행 => 소스 코딩
 *         } => 메소드 종료
 *      } => 클래스 종료
 *      
 *      확장 
 *      public class ClassName{
 *         ===================
 *                변수 
 *         ===================
 *               생성자 => 변수의 초기화
 *         ===================
 *           사용자 정의 메소드
 *           => 게시판 목록
 *           => 게시판 등록
 *           => 게시판 상세
 *           => 게시판 수정 
 *           => 게시판 삭제
 *         ===================
 *              main() => CBD => 조립식
 *         ===================
 *      }
 *      
 *      22page 
 *        => 들여쓰기 
 *        class A
 *        {
 *           public static void main()
 *           {
 *           }
 *        }
 *        for:
 *        for:
 *        
 *        for:
 *          for:
 *      23page : 주석 => 컴파일 예외
 *      
 *      HTML <!-- --> 
 *      CSS //
 *      Python # , """
 *                 """
 *      JSP <%-- --%>
 *   
 */
import java.util.Arrays;
public class 자바소개_특징 {
   // 자동으로 호출 => 시작/종료


// ctrl+shift+/
// ctrl+shift+\
public static void main(String[] args) {
	  
	
//	  System.out.println("Hello");
//	  System.out.println("Hello");
//	  System.out.println("Hello"); 
//	  System.out.println("Hello");
//	  System.out.println("Hello"); 
//	  System.out.println("Hello");
//	  System.out.println("Hello"); 
//	  System.out.println("Hello");
//	  System.out.println("Hello"); 
//	  System.out.println("Hello");
	 
	  System.out.println("Hello");
	  System.out.println("Hello");
	  System.out.println("Hello");
	  System.out.println("Hello");
	  
   }
   
}
