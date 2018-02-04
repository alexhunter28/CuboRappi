/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rappi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Rappi {
    
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        //NUMERO DE CASOS DE PRUEBA
        int T = sc.nextInt();

        //EJECUTAR CADA CASO DE PRUEBA
        for(int t = 0; t < T; t++){

            //STORES COORDINATE VALUES
            HashMap<String, Long> hm = new HashMap<>();

            //N IS SIZE OF EACH SIZE | M IS NUMBER OF QUERIES
            int n, m;

            //GETTING INPUT
            n = sc.nextInt();
            m = sc.nextInt();

            //EXECUTING EACH QUERY
            for(int q = 0; q < m; q++){
                String query = sc.next();
                if(query.equals("UPDATE")){

                    //COORDINATEs OF BLOCK
                    int x, y, z;

                    //UPDATE VALUE
                    long w;

                    //GETTING INPUT
                    x = sc.nextInt();
                    y = sc.nextInt();
                    z = sc.nextInt();
                    w = sc.nextLong();

                    //GENERATING HASHMAP KEY
                    String key = Integer.toString(x) + " " + Integer.toString(y) + " " + Integer.toString(z);
                    System.out.println(key);
                    //PUTTING VALUE IN HASHMAP
                    hm.put(key, w);
                }
                else{

                    //DELIMITER COORDINATES
                    int x1, y1, z1, x2, y2, z2;

                    //SUM OF VALUES
                    long result = 0;

                    //GETTING INPUT
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    z1 = sc.nextInt();
                    x2 = sc.nextInt();
                    y2 = sc.nextInt();
                    z2 = sc.nextInt();


                    //ITERATING THROUGH THE HASHMAP
                    for(Map.Entry<String, Long> entry : hm.entrySet()){

                        //CURRENT COORDINATES
                        int x, y, z;

                        //REVERSING KEY TO COORDINATES
                        String[] key = entry.getKey().split(" ");
                        x = Integer.parseInt(key[0]);
                        y = Integer.parseInt(key[1]);
                        z = Integer.parseInt(key[2]);

                        //CHECKING IF COORDINATES ARE WITHIN THE DELIMETERS
                        if((x >= x1 && x <= x2) && (y >= y1 && y <= y2) && (z >= z1 && z <= z2)){

                            //ADDING CURRENT VALUE TO SUM OF VALUES
                            result += entry.getValue();
                        }
                    }
                    //PRINTING SUM OF BLOCKS WITHIN DELIMETER COORDINATES
                    System.out.println(result);
                }
            }
        }

        sc.close();
    }
        
        

    
    public static void solucion2(){        
            
        Scanner in = new Scanner(System.in);
        int tcCnt = Integer.valueOf(in.nextLine());
        //System.out.println("Test Case Count "+tcCnt);
        for (int test=0; test < tcCnt;test++) {
            String nm = in.nextLine();
            int n = Integer.valueOf(nm.split("\\s")[0]);
            int m = Integer.valueOf(nm.split("\\s")[1]);
            int size = Integer.valueOf(String.valueOf(n +1)+""+String.valueOf(n+1)+""+String.valueOf(n+1));
            //System.out.println("Size= "+size);

            long[] array = new long[size];


            //System.out.println("N= "+n);
            //System.out.println("M= "+m);

            for (int j=0;j<m;j++) {
                String line = in.nextLine();
                String caseType = line.split("\\s")[0];
                //System.out.println("For m= "+j+", Case Type =  "+caseType);


                if (caseType.equals("UPDATE")) {
                    int x = Integer.valueOf(line.split("\\s")[1]);
                    int y = Integer.valueOf(line.split("\\s")[2]);
                    int z = Integer.valueOf(line.split("\\s")[3]);
                    long value = Long.valueOf(line.split("\\s")[4]);

                    int indx = Integer.valueOf(x+""+y+""+z);
                    //System.out.println("x= "+x+" y= "+y+" z= "+z+" value= "+value);
                    //initializedMap.put(x+":"+y+":"+z,value);
                    while (indx < array.length) {
                        //System.out.println("Index= "+indx+", Value="+value);
                        array[indx]+=value;
                        indx+=(indx & (-indx));
                    }
                } 
                long tempSum=0;
                if (caseType.equals("QUERY")) {
                    int x1 = Integer.valueOf(line.split("\\s")[1]);
                    int y1 = Integer.valueOf(line.split("\\s")[2]);
                    int z1 = Integer.valueOf(line.split("\\s")[3]);

                    long sum1=0;
                    int localIndx=Integer.valueOf(x1+""+y1+""+z1)-1;
                    while (localIndx > 0) {
                        sum1+=array[localIndx];
                        //System.out.println("Local Index= "+localIndx+", Sum1="+sum1);
                        localIndx-=(localIndx & (-localIndx));
                    }
                    //System.out.println("Till Index1= "+indx1+", Sum1="+sum1);
                    int x2 = Integer.valueOf(line.split("\\s")[4]);
                    int y2 = Integer.valueOf(line.split("\\s")[5]);
                    int z2 = Integer.valueOf(line.split("\\s")[6]);

                    long sum2=0;
                    localIndx=Integer.valueOf(x2+""+y2+""+z2);
                    while (localIndx > 0) {
                        sum2+=array[localIndx];
                        //System.out.println("Local Index= "+localIndx+", Sum2="+sum2);
                        localIndx-=(localIndx & (-localIndx));
                    }

                    //System.out.println("Till Index2= "+indx2+", Sum2="+sum2);
                    //System.out.println("x1= "+x1+" y1= "+y1+" z1= "+z1+" x2= "+x2+" y2= "+y2+" z2= "+z2);


                    tempSum = sum2-sum1;
                    System.out.println(tempSum);
                }
            }
        }
        in.close();
    }    
    
}
