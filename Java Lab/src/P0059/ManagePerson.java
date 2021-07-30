package P0059;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



public class ManagePerson {
    private static BufferedReader bufferReader;
    private static Scanner reader;

    public void displayMenu(){
        System.out.println("=============== File Processing ===============");
        System.out.println("1. Find person info.");
        System.out.println("2. Copy Text to new file.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
    }

    public void findPersonInfo(List<Person> list) throws Exception{
        System.out.println("--------------- Person info ---------------");
        System.out.print("Enter Path: ");
        String pathName = Validation.checkString();
        if(checkFileExist(pathName)){
            return;
        }
        System.out.print("Enter Money: ");
        double money = Validation.checkDouble();
        list = getListPerson(pathName);
        if(list == null){
            return;
        }
        printList(list, money);
    }

    private static List<Person> getListPerson(String pathName) throws Exception {
        List<Person> list = new ArrayList<>();
        File file =  new File(pathName);
        String eachLine = "";
        try {
            FileReader fileReader = new FileReader(file);
            bufferReader = new BufferedReader(fileReader);
            while((eachLine = bufferReader.readLine()) != null){
                String personInfo[] = eachLine.split(";");
                list.add(new Person(personInfo[0], personInfo[1], getMoney(personInfo[2])));
            }
        } catch (Exception e) {
            System.out.println("Can't read file.");
        }
        return list;
    }

    private static boolean checkFileExist(String path){
        File file = new File(path);
        if(!file.exists() || !file.isFile()){
            System.out.println("Path doesn't exsit");
            return true;
        }
        return false;
    }

    private static double getMoney(String money) {
        double salaryResult = 0;
        try {
            salaryResult = Double.parseDouble(money);
        } catch (NumberFormatException e) {
            salaryResult = 0;
        }
        return salaryResult;
    }

    private void sortList(List<Person> list){
        Collections.sort(list,new Comparator<Person>(){

            @Override
            public int compare(Person p1, Person p2) {
                if(p1.getMoney() > p2.getMoney()){
                    return 1;
                }
                return -1;
            }
            
        });
    }

    private void printList(List<Person> list,double money){
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        sortList(list);
        int index = 0;
        for(Person p : list){
            if(p.getMoney() >= money){
                p.display();
            }
        }
        System.out.println();
        System.out.println("Max: " + list.get(list.size() - 1).getName());
        for(Person p : list){
            if(p.getMoney() >= money){
                index = list.indexOf(p);
                break;
            }
        }
        System.out.println("Min: " + list.get(index).getName());
    }

    public void copyNewFile() throws Exception{
        System.out.println("--------------- Copy Text ---------------");
        System.out.print("Enter Source:  ");
        String source = Validation.checkString();
        if(checkFileExist(source)){
            return;
        }
        System.out.print("Enter new file name:  ");
        String destination =  Validation.checkString();
        if(copyWordOneTimes(source, destination)){
            System.out.println("Copy successful");
        }
    }

    private static boolean copyWordOneTimes (String source, String destination) throws Exception{
        String content = getUserContent(source);
        if(content == null){
            throw new Exception("Path doesn't exsit");
        }
        wrtienewFile(destination, content);
        return true;
    }


    private static String getUserContent(String source){
        // HashSet<String> set = new HashSet<>();
        List<String> ls = new ArrayList<>();
        File file = new File(source);
        try {
            reader = new Scanner(file);
            while(reader.hasNextLine()){
                String word = reader.nextLine();
                String wordlist[] = word.split(" ");
                System.out.println(wordlist.length);
                for(int i = 0;i < wordlist.length;i++){
                    if(ls.contains(wordlist[i])){
                        continue;
                    }
                    ls.add(wordlist[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("Can't read file");
        }
        String content = "";
        for(String line : ls){
            content = content + line + " ";
        }
        return content;
    }

    private static void wrtienewFile(String destination,String content){
        File file = new File(destination);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Can't create file");
                e.printStackTrace();
            }
        }
        try {
            FileWriter myWriter = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(myWriter);
            bWriter.write(content);
            bWriter.close();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Can't not write");
            e.printStackTrace();
        }

    }



}
