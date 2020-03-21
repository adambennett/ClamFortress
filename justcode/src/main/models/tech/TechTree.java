package main.models.tech;

import main.models.*;
import main.models.tech.eras.*;

import java.util.*;

public class TechTree extends GameObject {

    private static Era head;
    private static Era tail;
    private static Era currentEra;

    public TechTree() {
        super("Tech Tree", "The Tech Tree");
        resetTechTree();
    }

    public static Era getTail() {
        return tail;
    }

    public static Era getHead() {
        return head;
    }

    public static ArrayList<Era> getAscending() {
        ArrayList<Era> eras = new ArrayList<>();
        if (head != null) {
            eras.add(head);
        }
        Era curr = head;
        while (curr.hasNext()) {
            curr = curr.getNext();
            eras.add(curr);
        }
        return eras;
    }

    public static ArrayList<Era> getDescending() {
        ArrayList<Era> eras = new ArrayList<>();
        if (tail != null) {
            eras.add(tail);
        }
        Era curr = tail;
        while (curr.hasPrev()) {
            curr = curr.getPrev();
            eras.add(curr);
        }
        return eras;
    }

    public static void resetTechTree() {
        createTree(standardTechTree());
    }

    public static void setTree(ArrayList<Era> newEraOrdering) {
        head = generateTreeHead(newEraOrdering);
        tail = head.advanceToEnd();
        currentEra = head;
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

    public static Era getEraFromString(String name) {
        if (head != null) {
            if (head.getName().equals(name.toLowerCase())) {
                return head;
            }
            else {
                Era curr = head;
                while (curr.hasNext()) {
                    if (curr.getNext().getName().equals(name.toLowerCase())) {
                        return curr.getNext();
                    }
                    curr = curr.getNext();
                }
            }
        }
        return null;
    }

    public static void incEra() {
        incEra(1);
    }

    public static Era getCurrentEra() {
        return currentEra;
    }

    private static void createTree(ArrayList<Era> eras) {
        head = generateTreeHead(eras);
        tail = head.advanceToEnd();
        currentEra = head;
    }

    private static ArrayList<Era> standardTechTree() {
        ArrayList<Era> eras = new ArrayList<>();
        eras.add(new StoneAge(true));
        eras.add(new BronzeAge(true));
        eras.add(new IronAge(true));
        eras.add(new ExplorationAge(true));
        eras.add(new IndustrialAge(true));
        eras.add(new InformationAge(true));
        eras.add(new FutureAge(true));
        return eras;
    }

    private static Era generateTreeHead(ArrayList<Era> erasInOrder) {
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

    static {
        resetTechTree();
    }

    @Override
    public TechTree clone() {
        return new TechTree();
    }
}
