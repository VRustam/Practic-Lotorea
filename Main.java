package com.lotoreya;

import java.util.*;

public class Main {

    static final int YARADILACAQ_SAYI_MAX = 60;
    static final int YARADILACAQ_SAYI_MIQDARI = 1000000;

    public static void main(String[] args) {
	// 10 reqemini axtaran proqra
    //1 den 60 qeder 1 000 000 yaradilan
    //say map icinde olacaq

        Map<Integer,Integer> creatingNumbersToMap = new HashMap<>();
        List<Integer> yaradilanSayList = new ArrayList<>();
        Set<Integer> onReqemi = new TreeSet<>();

        mapNumbersF(creatingNumbersToMap);
        mapCedveleYazdir(creatingNumbersToMap,yaradilanSayList);
        onReqeminiTap(onReqemi,yaradilanSayList);

        System.out.println("List  size : " + yaradilanSayList.size());
        System.out.println("Map Size : " + creatingNumbersToMap.size());
        System.out.println("Set Size : " + onReqemi.size());


        System.out.println("Sansli 10 reqemi ");

        for(int mueyyen : onReqemi){
            System.out.print(mueyyen + " ");
        }


    }

    private static void onReqeminiTap(Set<Integer> onReqemi, List<Integer> yaradilanSayList) {
        Collections.shuffle(yaradilanSayList);

        while(onReqemi.size() < 10){

            int randomNumber = (int)(Math.random() * YARADILACAQ_SAYI_MIQDARI);
                onReqemi.add(yaradilanSayList.get(randomNumber));
        }
    }

    private static void mapCedveleYazdir(Map<Integer, Integer> creatingNumbersToMap, List<Integer> yaradilanSayList) {
        for(Map.Entry<Integer,Integer> mueyyen : creatingNumbersToMap.entrySet()){
            int key = mueyyen.getKey(); // 9 reqemi
            int value = mueyyen.getValue();// 20 defe caqrildi misalucun
            for(int i=0 ; i<value;i++){
                yaradilanSayList.add(key);
            }


        }
    }

    private static void mapNumbersF(Map<Integer, Integer> creatingNumbersToMap) {
        for(int i=0 ; i <YARADILACAQ_SAYI_MIQDARI ; i++){
            int randomNumber = numberCreat();
            if(creatingNumbersToMap.containsKey(randomNumber)){
                int value = creatingNumbersToMap.get(randomNumber);
                creatingNumbersToMap.put(randomNumber,++value);
            }else{
                creatingNumbersToMap.put(randomNumber,1);
            }
        }
    }
    private static int numberCreat(){
        return ((int) (Math.random() * YARADILACAQ_SAYI_MAX) + 1);
    }
}
