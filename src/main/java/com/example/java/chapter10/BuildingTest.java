package com.example.java.chapter10;

public class BuildingTest {
    private static void print(BuildingType type){
        System.out.println("BuildingType{ buildingName: " + type.getBuildingName()
                + " buildingAddress: " + type.getBuildingAddress()
                + " buildingId: " + type.getBuildingId()  +" }" );
    }

    public static void main(String[] args) {
        BuildingFactory buildingFactory = new BuildingFactory();
        print(buildingFactory.create("BUILDING-A", "100 WEST MAIN", "1"));
        print(buildingFactory.create("BUILDING-B", "110 WEST MAIN", "2"));
        print(buildingFactory.create("BUILDING-C", "120 WEST MAIN", "3"));
    }
}
