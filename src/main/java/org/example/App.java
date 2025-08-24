package org.example;

import org.example.controller.MotivationController;
import org.example.system.SystemController;

public class App {

    public void run() {
        System.out.println("== 명언 앱 ==");
        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();



        while (true) {
            System.out.print("명령어) ");
            String cmd = Container.getScanner().nextLine().trim(); // trim : 공백 제거
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
            else if (cmd.startsWith("delete")) { // 삭제
                motivationController.delete(cmd);
//                motivationController.newDelete(cmd);
            }
            else {
                System.out.println("사용할수 없는 명령어 입니다.");
            }

        }

    }


}
