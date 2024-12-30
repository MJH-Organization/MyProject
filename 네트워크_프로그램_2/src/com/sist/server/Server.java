package com.sist.server;
import java.io.*;
import java.net.*;
import java.util.*;
import com.sist.commons.*;
/*
 *      class Server
 *      {
 *          Vector waitVc=new Vector()
 *          => 접속자 저장 공간(IP)
 *          class Client extends Thread
 *          {
 *              접속자마다 따로 통신만 담당
 *                     -------- Thread
 *                              ------
 *                              | 접속된 사람들과 통신
 *              멤버클래스를 이용한다                
 *          }
 *      }
 *      
 *      class Server
 *      {
 *          static Vector w=new Vector()
 *          
 *          => new Server()
 *      }
 *      class Client
 *      {
 *          Server server=new Server();
 *          server.w
 *      }
 *      
 *      => port가 같은 경우는 사용할 수 없다
 *      
 */
// 접속시에 처리 => 교환 소켓 / 대기 소켓
public class Server implements Runnable{
    private Vector<Client> waitVc=new Vector<>();
    // 1. 저장 공간 (접속자)   => 동기화
    /*
     *      Vector  ===> 네트워크
     *      ArrayList   ===> 데이터베이스
     *      LinkedList  ===> 추가 / 수정이 많은 곳
     */
    // 2. 서버 가동
    private ServerSocket ss;
    // 3. 접속시 => 연결 라인 => PORT
    private final int PORT=4321;
    
    // 4. 서버 가동 => ServerSocket 초기화
    public Server()
    {
        try
        {
            ss=new ServerSocket(PORT);
            // bind => 개통 (유심)
            // listen() => 대기
            System.out.println("Server Start...");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // 5. 접속시에 처리 => 사용자 정보를 받아서 Client 클래스 전송
    // 통신이 가능하게 만든다
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();

    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        try
        {
            while(true)
            {
                Socket s=ss.accept();
                // 접속시에 발신자 정보를 받는다
                Client client=new Client(s);
                // => 각 쓰레드로 전송 => 각자 따로 통신이 가능
                client.start();
            }
            
        }catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    // 클라이언트마다 통신을 담당
    // Server가 가지고 있는 모든 자원(변수,메서드)을 사용할 수 있다
    // => 쓰레드는 데이터가 없고 => 데이터 공유
    /*
     *  호출 => Server.Client
     *  한개의 프로그램 안에서 여러개의 프로그램을 동시에 실행
     *  ----------      ------------
     *   프로세스           쓰레드
     */
    class Client extends Thread
    {
        Socket s;   // 클라이언트의 IP
        OutputStream out;   // 송신
        BufferedReader in; // 수신 => 한글이 포함 => 2byte
        
        String id,name,sex,pos;
        // DB => id 중복체크 => 중복없이 => PRIMARY KEY
        public Client(Socket s)
        {
            /*
             *      => readLine() <===> write()
             *      => write()  <===> readLine()
             */
            try
            {
                this.s=s;
                out=s.getOutputStream();
                // 클라이언트로 전송
                in=new BufferedReader(new InputStreamReader(s.getInputStream()));
                // 클라이언트로부터 값을 수신
                
            }catch (Exception e) { }
            /*
             *  자바 프로그램에서 가장 쉬운 프로그램
             *                  ----------
             *                  패턴이 몇개냐?
             *  => 네트워크
             *  => 데이터베이스
             *  
             */
        }
        // 실제 통신
        public void run()
        {
            try
            {
                while(true)
                {
                    //1. 사용자 요청값 받기
                    String msg=in.readLine();
                    //로그인 => 100|id|name|sex
                    StringTokenizer st=
                            new StringTokenizer(msg,"|");
                    int protocol=Integer.parseInt(st.nextToken());
                    switch(protocol)
                    {
                    case Function.LOGIN:    // 로그인을 요청했다면
                        {
                            // 로그인 => 회원가입 내용을 전송
                            id=st.nextToken();
                            name=st.nextToken();
                            sex=st.nextToken();
                            pos="대기실";
                            
                            // 1. 접속이 된 사람 => 정보 전송
                            messageAll(Function.LOGIN+"|"+id+"|"+name+"|"+sex+"|"+pos);
                            
                            // 2. 입장메세지 전송
                            messageAll(Function.WAITCHAT+"|[알림] "
                                      +name+"님이 입장하셨습니다");
                            
                            // 3. waitVc에 저장
                            waitVc.add(this);
                            // 4-1. 화면을 변경
                            messageTo(Function.MYLOG+"|"+id);
                            // 4. 접속된 모든 정보를 로그인된 사람에게 전송
                            for(Client c:waitVc)
                            {
                                messageTo(Function.LOGIN+"|"
                                        +c.id+"|"
                                        +c.name+"|"
                                        +c.sex+"|"
                                        +c.pos);
                            }
                        }
                        break;
                    case Function.WAITCHAT:    // 로그인을 요청했다면
                    {
                        messageAll(Function.WAITCHAT+"|["+name+"] "+st.nextToken());
                    }
                        break;
                    case Function.EXIT:
                    {
                        messageAll(Function.EXIT+"|"+id);
                        messageAll(Function.WAITCHAT+"|[알림] "+name+"님이 퇴장하셨습니다");
                        messageTo(Function.MYEXIT+"|");
                        // 행위를 한 사람 => this
                        for(int i=0; i<waitVc.size();i++)
                        {
                            Client c=waitVc.get(i);
                            if(c.id.equals(id))
                            {
                                waitVc.remove(i);
                                try
                                {
                                    in.close();
                                    out.close();
                                }catch(Exception ex) {}
                                break;
                            }
                        }
                    }
                        break;
                    /*
                     *      서버의 기능
                     *      1. 저장
                     *      2. 수정
                     *      3. 읽기 / 쓰기 (송수신)
                     *      4. 검색    
                     */
                    case Function.INFO:
                    {
                        String yid=st.nextToken();
                        for(Client c:waitVc)
                        {
                            if(yid.equals(c.id))
                            {
                                messageTo(Function.INFO+"|"
                                        +c.id+"|"
                                        +c.name+"|"
                                        +c.sex+"|"
                                        +c.pos);
                            }
                            break;
                        }
                    }
                        break;
                    }
                }
            }catch (Exception ex) {
                // TODO: handle exception
            }
        }
        // 접속자 전체 : 대기실
        public synchronized void messageAll(String msg)
        {
            for (int i=0; i<waitVc.size(); i++)
            {
                Client c=waitVc.get(i);
                try
                {
                    c.messageTo(msg);
                }catch (Exception ee) 
                {
                    waitVc.remove(i);
                }
            }
        }
        // 접속자 개인 : 쪽지보내기, 정보보기, 귓속말
        public void messageTo(String msg)
        {
            try
            {
                out.write((msg+"\n").getBytes());
            }catch (Exception ex) 
            {
            }
        }
    }
    

}
