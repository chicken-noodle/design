package minqi.xiao.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> titles = new ArrayList<>();
        List<String> writers = new ArrayList<>();
        List<String> poems = new ArrayList<>();
        int cnt = 0;

        while (true) {
            String str = scanner.nextLine();
            if (!str.equals("no")) {
                if (str.equals(""))
                    continue;
                cnt++;
                String str2 = scanner.nextLine();
                String str3 = scanner.nextLine();
                String str4 = scanner.nextLine();
                StringBuilder stringBuilder = new StringBuilder(str4);
                stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
                titles.add(str);
                writers.add(str2);
                poems.add(str3.replaceAll(" ","") + stringBuilder.toString().replaceAll(" ",""));

            } else {
                break;
            }
        }
        for (int i = 0; i < cnt; i++)
            System.out.println("insert into memory_poem (title,writer,poem) values('"+titles.get(i)+"','"+writers.get(i)+"','"+poems.get(i)+"');");
        scanner.close();
    }
}
