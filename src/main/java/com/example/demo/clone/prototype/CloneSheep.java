package com.example.demo.clone.prototype;

public class CloneSheep {
    public static void main(String[] args){
        Sheep sheep = new Sheep("小白",5,"白色");
        Sheep sheepB = new Sheep("小黑",5,"黑色");
        sheep.setFriend(sheepB);
        Sheep sheep1 = (Sheep)sheep.clone();
        Sheep sheep2 = (Sheep)sheep.clone();;
        Sheep sheep3 = (Sheep)sheep.clone();;
        Sheep sheep4 = (Sheep)sheep.clone();;

        System.out.println("sheep "+sheep.hashCode()+" name；"+sheep.getName().hashCode()+" friend:"+sheep.getFriend().hashCode());
        System.out.println("sheep "+sheep1.hashCode()+" name；"+sheep1.getName().hashCode()+" friend:"+sheep1.getFriend().hashCode());
        System.out.println("sheep "+sheep2.hashCode()+" name；"+sheep2.getName().hashCode()+" friend:"+sheep2.getFriend().hashCode());
        System.out.println("sheep "+sheep3.hashCode()+" name；"+sheep3.getName().hashCode()+" friend:"+sheep3.getFriend().hashCode());
        System.out.println("sheep "+sheep4.hashCode()+" name；"+sheep4.getName().hashCode()+" friend:"+sheep4.getFriend().hashCode());
        System.out.println(sheep.toString());
        System.out.println(sheep1.toString());
        System.out.println(sheep2.toString());
        System.out.println(sheep3.toString());
        System.out.println(sheep4.toString());

    }
}
