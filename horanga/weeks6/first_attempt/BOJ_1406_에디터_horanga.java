package horanga.weeks6.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1406_에디터_horanga {

    static ListIterator<String> iterator;
    static Queue<String> line;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        int num = Integer.parseInt(bufferedReader.readLine());

        String[] command = new String[num];

        for(int i =0; i<num; i++){
            command[i] = bufferedReader.readLine();
        }

        line = new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            line.add(str.charAt(i)+"");
        }


        iterator = (ListIterator<String>) line.iterator();

        while(iterator.hasNext()){
            iterator.next();
        }

        for(int i =0; i<command.length; i++){
            String c = command[i];

            if(c.startsWith("L")){
                l();
            } else if(c.startsWith("D")){
                d();
            } else if (c.startsWith("B")) {
                b();
            } else {
                p(c);
            }
        }

        StringBuilder string = new StringBuilder();

        Iterator<String> i = line.iterator();

        while(i.hasNext()) {
            string.append(i.next());
        }

        System.out.println(string);
    }

    private static void b(){
        if(iterator.hasPrevious()) {
            iterator.previous();
            iterator.remove();
        }
    }

    private static void d(){
        if(iterator.hasNext()){
            iterator.next();
        }
    }

    private static void l(){
        if(iterator.hasPrevious()) {
            iterator.previous();
        }
    }


    private static void p(String command){
        String[] split = command.split(" ");
        iterator.add(split[1]);
    }
}
