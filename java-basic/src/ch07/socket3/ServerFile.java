package ch07.socket3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 양방향 통신
 * 서버: InputStream(글 읽기)
 *      + WriteStream(글 쓰기)
 */
public class ServerFile {

    // 클라이언트 연결을 받는 소켓
    ServerSocket serverSocket;

    // 실제 통신을 하는 소켓
    // 1024 ~ 65535까지 포트 중 사용하지 않는 포트를 랜덤으로 선정
    Socket socket;
    BufferedReader br;

    // 새로운 스레드 필요
    BufferedWriter bw;
    BufferedReader keyboard;

    public ServerFile() {
        System.out.println("1. 서버소켓 시작!!");
        try {
            serverSocket = new ServerSocket(10000);

            System.out.println("2. 서버소켓 생성완료 : 클라이언트 접속 대기중");
            socket = serverSocket.accept();  // 클라이언트 접속 대기중...
            System.out.println("3. 클라이언트 연결완료: buffer 연결 완료(read)");
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            keyboard = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // write 스레드 실행(글 쓰기)
            WriteThread wt = new WriteThread();
            Thread thread = new Thread(wt);
            thread.start();

            // main 스레드 역할(글 읽기)
            while(true) {
                String msg = br.readLine();
                System.out.println("4. 클라이언트로 부터 받은 메시지 : " + msg);
            }

        } catch (Exception e) {
            System.out.println("서버소켓 에러 발생 : " + e.getMessage());
        }
    }

    // 내부 클래스
    class WriteThread implements Runnable {

        @Override
        public void run() {
            try {
                while(true) {
                    String keyboardMsg = keyboard.readLine();
                    bw.write(keyboardMsg + "\n");
                    bw.flush();
                }
            } catch (Exception e) {
                System.out.println("서버소켓 쪽에서 키보드 입력 받는 중 오류 발생 : " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new ServerFile();
    }
}
