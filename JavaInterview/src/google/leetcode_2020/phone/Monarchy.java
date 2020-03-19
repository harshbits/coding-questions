package google.leetcode_2020.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monarchy {


    public static void main(String[] args) {

        String king = "king";
        Monarchy monarchy = new Monarchy(king);
        monarchy.birth("Andy", "king");
        monarchy.birth("Bob", "king");
        monarchy.birth("Catherine", "king");
        monarchy.birth("Mathew", "Andy");
        monarchy.birth("Alex", "Bob");
        monarchy.birth("Asha", "Bob");

        List<String> order = monarchy.getOrderOfSuccession();
        System.out.println(order);

        monarchy.death("Bob");
        order = monarchy.getOrderOfSuccession();
        System.out.println(order);
    }


    private String king;

    private Map<String, Person> personMap;

    public Monarchy(String king) {
        this.king = king;
        this.personMap = new HashMap<>();
        this.personMap.put(king, new Person(king));
    }

    public void birth(String child, String parent) {
        if (parent == null) {
            return;
//            throw IllegalArgumentException("Parent is invalid");
        }

        Person p = personMap.get(parent);
        Person c = new Person(child);
        p.children.add(c);
        this.personMap.put(child, c);
    }

    // if a person dies, they are removed from monarchy but their children are still considered monarchs
    public void death(String name) {
        this.personMap.get(name).isDead = true;
    }

    // Pre - order printing
    public List<String> getOrderOfSuccession() {
        List<String> order = new ArrayList<>();
        Person k = personMap.get(king);
        dfsPreOrder(order, k);
        return order;
    }

    private void dfsPreOrder(List<String> order, Person parent) {
        // print only if person is alive
        if (!parent.isDead) {
            order.add(parent.name);
        }
        for (Person child : parent.children) {
            dfsPreOrder(order, child);
        }
    }

}


class Person {
    String name;
    List<Person> children;
    boolean isDead;

    public Person(String name) {
        this.name = name;
        this.isDead = false;
        this.children = new ArrayList<>();
    }

    // we could have getter and setter as well
}
