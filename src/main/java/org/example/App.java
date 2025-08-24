package org.example;

import org.example.controller.MotivationController;
import org.example.system.SystemController;
import org.example.vo.Motivation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);



        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim(); // trim : 공백 제거
            System.out.println("받은 명령어 : " + cmd); // 받은 명령어 확인

            
            if (cmd.equals("exit")) { //종료
                systemController.exit();
                break;
            }
            else if (cmd.equals("add")) { // 등록
                motivationController.add();
            }
            else if (cmd.equals("list")) { // 목록
                motivationController.list();
            }
            else if (cmd.startsWith("delete")) { // 강사님 풀이
                motivationController.delete(cmd);
            }
            else {
                System.out.println("사용할수 없는 명령어 입니다.");
            }

        }

    }


}
