package com.pelajar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LatihanQueue {
    String str;
    int num;
    public static void main(String[] args) {
        LatihanQueue q = new LatihanQueue();
    }
    public LatihanQueue() {
        try{ 
            LinkedList <Integer> list = new LinkedList<Integer>();
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Jumlah Data : ");
            str = bf.readLine();
            if ((num = Integer.parseInt(str)) == 1) {
                System.out.println("Anda menekan angka satu");
                System.exit(0);
            }
            else {
                for (int i = 1; i<= num; i++){
                    str = bf.readLine();
                    int n = Integer.parseInt(str);
                    list.add(n);
                }
            }
            System.out.println("Isi queue: " + list);
            System.out.println("Elemen Pertama: " + list.removeFirst());
            System.out.println("Elemen Terakhir: " + list.removeLast());
            System.out.print("Elemen Tengah: " ); 
        }catch(Exception e){

        }
    
    }
}