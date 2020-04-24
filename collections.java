package com.tgt.igniteplus;

import java.util.*;

public class collections {
    public static void main(String[] args) {

        Set<String> gauthamSkillSet = new HashSet<>();
        gauthamSkillSet.add("Java");
        gauthamSkillSet.add("SQL");
        gauthamSkillSet.add("DS");

        Set<String> divyaSkillSet = new HashSet<>();
        divyaSkillSet.add("Java");
        divyaSkillSet.add("NOSQL");
        divyaSkillSet.add("ML");

        Set<String> amitSkillSet = new HashSet<>();
        amitSkillSet.add("Linux");
        amitSkillSet.add("PSQL");
        amitSkillSet.add("Scripting");

        Set<String> naveenSkillSet = new HashSet<>();
        naveenSkillSet.add("Chef");
        naveenSkillSet.add("React");
        naveenSkillSet.add("AI");


        List<IgniteMembers>[] listOfDepartments = new List[10];
        int d = 1;


        List<IgniteMembers> dataScience = new ArrayList<>();
        dataScience.add(new IgniteMembers("Gautham","VTU",28,gauthamSkillSet));
        dataScience.add(new IgniteMembers("Divya","TGT",26,divyaSkillSet));

        List<IgniteMembers> infrastructure = new ArrayList<>();
        infrastructure.add(new IgniteMembers("Amit","TMT",25,amitSkillSet));
        infrastructure.add(new IgniteMembers("Naveen","DOJO",22,naveenSkillSet));

        Map<String,List<IgniteMembers>> mem = new HashMap<>();
        mem.put("Data Science",dataScience);
        mem.put("Infrastructure",infrastructure);

        listOfDepartments[0] = dataScience;
        listOfDepartments[1]= infrastructure;


        int c,newAge;
        String newName, newDept, newCollege, s1, s2, s3;
        Set<String> newSkillSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        List<IgniteMembers> newDepartment = new ArrayList<>();
        do {
            System.out.println("-------------------------------");
            System.out.println("Enter your choice:\n1.Display all the departments\n2.Create a new department\n3.Delete a department\n4.Display all the members as per department\n5.Create a member and add the member as per department\n6.Exit");
            System.out.println("-------------------------------");
            c = sc.nextInt();

            if (c == 1) {

                //for(int j = 0; j< listOfDepartments.length; j++) {
                // List<IgniteMembers> l = listOfDepartments[j];
                // System.out.println(l);
                for (String dept : mem.keySet()) {
                    System.out.println(dept);
                }

            } else if (c == 2) {
                System.out.println("Enter the name of the department");
                newDept = sc.next();
                System.out.println("Enter the name of the member");
                newName = sc.next();
                System.out.println("Enter the age of the member");
                newAge = sc.nextInt();
                System.out.println("Enter the college");
                newCollege = sc.next();
                System.out.println("Enter the skill set");
                System.out.print("1.");
                s1 = sc.next();
                System.out.print("2.");
                s2 = sc.next();
                System.out.print("3.");
                s3 = sc.next();
                newSkillSet.add(s1);
                newSkillSet.add(s2);
                newSkillSet.add(s3);
                newDepartment.add(new IgniteMembers(newName, newCollege, newAge, newSkillSet));
                d = d + 1;
                listOfDepartments[d] = newDepartment;
                mem.put(newDept, newDepartment);
                System.out.println("Department " + newDept + " is added");
                for (IgniteMembers i : newDepartment)
                    System.out.println(i.toString());

            } else if (c == 3) {
                int a = 0;
                System.out.println("Enter the number of the department to be deleted");
                for (String dept : mem.keySet()) {
                    a++;
                    System.out.println(a + "." + dept);
                }
                int delDept = sc.nextInt();


               /* for (String dept : mem.keySet()) {
                    int dd=0;
                    for (IgniteMembers i : mem.get(dept))
                        listOfDepartments[delDept].remove(dd++);
                }*/
               // String deletedDepartment = (String)mem.remove("Infrastructure");



                int size = listOfDepartments[delDept].size();
                int s=0;
                //for(s = 0; s<size;s++)1

                listOfDepartments[delDept].remove(s);

                System.out.println("removed");
            } else if (c == 4) {

                for (String dept : mem.keySet()) {
                    System.out.println("Department Name: " + dept);
                    System.out.println("-----------------------------------");
                    for (IgniteMembers i : mem.get(dept))
                        System.out.println(i.toString());
                    System.out.println("-----------------------------------");
                }
            } else if (c == 5) {
                int a = 0;
                System.out.println("Enter the number the department to which the member is to be added");
                for (String dept : mem.keySet()) {
                    a++;
                    System.out.println(a + "." + dept);
                }
                int ch = sc.nextInt();

                System.out.println("Enter member's name");
                String nam = sc.next();
                System.out.println("Enter age:");
                int ag = sc.nextInt();
                System.out.println("Enter college");
                String coll = sc.next();
                Set<String> set = new HashSet<>();
                System.out.println("Enter skill set");
                System.out.print("1.");
                s1 = sc.next();
                System.out.print("2.");
                s2 = sc.next();
                System.out.print("3.");
                s3 = sc.next();
                set.add(s1);
                set.add(s2);
                set.add(s3);
                listOfDepartments[ch].add(new IgniteMembers(nam, coll, ag, set));
                System.out.println("Added successfully ");
                for (IgniteMembers i : listOfDepartments[ch])
                    System.out.println(i.toString());
            } else if (c == 6)
                System.exit(0);
            else
                System.out.println("Enter the right number");
        }while (true);
    }

}