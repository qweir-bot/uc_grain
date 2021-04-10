package com.example.demo.clone.nodesign;

public class CloneSheep {
    public static void main(String[] args){
        Sheep sheep = new Sheep("小白",5,"白色");

        Sheep sheep1 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep2 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());
        Sheep sheep4 = new Sheep(sheep.getName(),sheep.getAge(),sheep.getColor());

        System.out.println(sheep.hashCode());
        System.out.println(sheep1.hashCode());
        System.out.println(sheep2.hashCode());
        System.out.println(sheep3.hashCode());
        System.out.println(sheep4.hashCode());
        System.out.println(sheep.toString());
        System.out.println(sheep1.toString());
        System.out.println(sheep2.toString());
        System.out.println(sheep3.toString());
        System.out.println(sheep4.toString());

    }
}
