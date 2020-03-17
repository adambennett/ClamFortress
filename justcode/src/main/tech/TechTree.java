package main.tech;

import main.tech.eras.*;

import java.util.*;

public class TechTree {

    private static Era head;
    private static Era tail;
    private static Era currentEra;

    static {
        resetTechTree();
    }

    public static void resetTechTree() {
        createTree(standardTechTree());
    }

    public static void setTree(ArrayList<Era> newEraOrdering) {
        head = generateTreeHead(newEraOrdering);
        tail = head.advanceToEnd();
    }

    public static void setTree(Era newHead, Era newTail) {
        head = newHead;
        tail = newTail;
    }

    public static Boolean moveToEra(Era era, boolean allowBackwards) {
        Era node = currentEra;
        while (node.hasNext()) {
            if (node.getNext().getClass().equals(era.getClass())) {
                currentEra = node.getNext();
                return true;
            }
            node = node.getNext();
        }
        if (allowBackwards) {
            while (node.hasPrev()) {
                if (node.getPrev().getClass().equals(era.getClass())) {
                    currentEra = node.getPrev();
                    return true;
                }
            }
        }
        return false;
    }

    public static void incEra(int amt) {
        int ticks = 0;
        Era node = currentEra;
        while (node.hasNext() && ticks < amt) {
            node = node.getNext();
            ticks++;
        }
        currentEra = node;
    }

    public static void incEra() {
        incEra(1);
    }

    public static Era getCurrentEra() {
        return currentEra;
    }

    public static void createTree(ArrayList<Era> eras) {
        head = generateTreeHead(eras);
        tail = head.advanceToEnd();
    }

    public static ArrayList<Era> standardTechTree() {
        ArrayList<Era> eras = new ArrayList<>();
        eras.add(new StoneAge());
        eras.add(new BronzeAge());
        eras.add(new IronAge());
        eras.add(new ExplorationAge());
        eras.add(new IndustrialAge());
        eras.add(new InformationAge());
        eras.add(new FutureAge());
        return eras;
    }

    public static Era generateTreeHead(ArrayList<Era> erasInOrder) {
        Era head = null;
        for (int i = erasInOrder.size() - 1; i > -1; i--) {
            Era temp = erasInOrder.get(i);
            if (i - 1 > -1){
                temp.setPrev(erasInOrder.get(i-1));
                temp.getPrev().setNext(temp);
            } else {
                head = temp;
                if (i+1 < erasInOrder.size()) {
                    head.setNext(erasInOrder.get(i+1));
                }
            }
        }
        return head;
    }


}
