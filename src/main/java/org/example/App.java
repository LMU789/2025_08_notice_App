package org.example;

import vo.Motivation;

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
        int lastId = 0;

        List<Motivation> motivationList = new ArrayList<Motivation>();

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim(); // trim : 공백 제거
            System.out.println("받은 명령어 : " +  cmd); // 받은 명령어 확인

            //종료
            if(cmd.equals("exit")) {
                System.out.println("== 명언 앱 종료 ==");
                break;
            } else if(cmd.equals("add")) {
                System.out.print("명언 : ");
                String body = sc.nextLine().trim();
                System.out.print("저자 : ");
                String author = sc.nextLine().trim();
                ++lastId;

                Motivation newMotiy = new Motivation(lastId, body, author);

                motivationList.add(newMotiy);

                System.out.println( lastId + "번 명언이 등록되었습니다.");
            } else if(cmd.equals("list")) {
                System.out.println("=".repeat(30));
                System.out.println("번호      /      저자     /      명언");
                if(motivationList.size() == 0) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {
                    Collections.reverse(motivationList);
                    for(Motivation m : motivationList) {
                        System.out.println(m.getId() + "             " + m.getBody() + "            " + m.getAuthor());
                    }

                    // list 내림차순
//                    for(int i = motivationList.size() -1; i >=0; i--) {
//                        System.out.println(motivationList.get(i).getId() + "             " + motivationList.get(i).getBody() + "            " + motivationList.get(i).getAuthor());
//                    }
                }
            } else {
                System.out.println("사용할수 없는 명령어 입니다.");
            }

        }

    }


}
