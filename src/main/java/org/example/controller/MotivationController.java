package org.example.controller;

import org.example.vo.Motivation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MotivationController {

    private Scanner sc;
    int lastId = 0;
    List<Motivation> motivationList = new ArrayList<Motivation>();

    public MotivationController(Scanner sc) {
        this.sc = sc;
    }

    public void add() {

        System.out.print("명언 : ");
        String body = sc.nextLine().trim();
        System.out.print("저자 : ");
        String author = sc.nextLine().trim();
        ++lastId;

        Motivation newMotiy = new Motivation(lastId, body, author);

        motivationList.add(newMotiy);

        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }

    public void list() {
        System.out.println("=".repeat(30));
        System.out.println("번호      /      명언     /      저자");
        if (motivationList.size() == 0) {
            System.out.println("등록된 명언이 없습니다.");
        } else {
            Collections.reverse(motivationList);
            for (Motivation m : motivationList) {
                if (m.getBody().length() < 5) {
                    System.out.println(" " + m.getId() + "               " + m.getBody() + "            " + m.getAuthor());
                } else {
                    System.out.println(" " + m.getId() + "               " + m.getBody().substring(0, 5) + "            " + m.getAuthor());

                }
            }

//             list 내림차순
//            for(int i = motivationList.size() -1; i >=0; i--) {
//                System.out.println(motivationList.get(i).getId() + "             " + motivationList.get(i).getBody() + "            " + motivationList.get(i).getAuthor());
//            }
        }
    }

    public void delete(String cmd) {

        if(cmd.split(" ").length > 2) {
            System.out.println("delete 뒤에는 숫자만 하나만 입력 가능합니다.");
            return;
        }

        int id = -1;

        try {
            id = Integer.parseInt(cmd.split(" ")[1]);
        } catch (NumberFormatException e) {
            System.out.println("delete 뒤에는 숫자만 입력 가능합니다.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("delete 한칸 띄고 숫자 입력하십시오.");
            return;
        }

        int foundIndex = -1;
        Motivation foundMotvation = null;
        for(int i = 0; i < motivationList.size(); i++) {
            foundMotvation = motivationList.get(i);
            if(foundMotvation.getId() == id) {
                System.out.println(foundMotvation.toString());
                foundIndex = i;
            }
        }

        if(foundMotvation == null) {
            System.out.println(id + "번 글은 없습니다.");
            return;
        }

        motivationList.remove(foundIndex);
        System.out.println(id + "번 글이 삭제되었습니다.");

    }
}
