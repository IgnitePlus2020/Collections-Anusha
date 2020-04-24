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


        List<IgniteMembers>[] listOfDepartments = new List[3];


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
        System.out.println("Enter your choice:\n1.Display all the departments\n2.Create a new department\n3.Delete a department\n4.Display all the members as per department\n5.Create a member and add the member as per department");
        c = sc.nextInt();

        if (c == 1) {

            //for(int j = 0; j< listOfDepartments.length; j++) {
               // List<IgniteMembers> l = listOfDepartments[j];
               // System.out.println(l);
            for (String dept: mem.keySet()){
                System.out.println(  dept);
            }

        }

         if(c == 2)
        {
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
            newDepartment.add(new IgniteMembers(newName,newCollege,newAge,newSkillSet));
            listOfDepartments[2] = newDepartment;
            mem.put(newDept,newDepartment);
            System.out.println("Department "+newDept+" is added");
            for(IgniteMembers i : newDepartment)
                System.out.println(i.toString());

        }
        if(c == 3){
            System.out.println("Enter the name the department to be deleted\n1.data science\n2.infrastructure\n");
            int delDept = sc.nextInt();
            if(delDept == 1) {
                dataScience.remove(0);
                System.out.println("removed");
            }
                else if(delDept == 2) {
                infrastructure.remove(0);
                System.out.println("Removed");
            }

            }
        if (c == 4) {

            for (String dept: mem.keySet()) {
                System.out.println("Department Name: " + dept);
                System.out.println("-----------------------------------");
                for (IgniteMembers i : mem.get(dept))
                    System.out.println(i.toString());
                System.out.println("-----------------------------------");
            }
        }
        if(c == 5)
        {
            System.out.println("Enter the name the department to which the member is to be added\n1.data science\n2.infrastructure\n");
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

                if(ch == 1)
                {
                    dataScience.add(new IgniteMembers(nam,coll,ag,set));
                    System.out.println("Added successfully to department data science");
                    for(IgniteMembers i : dataScience)
                        System.out.println(i.toString());
                }
                else if(ch == 2) {
                    infrastructure.add(new IgniteMembers(nam, coll, ag, set));
                    System.out.println("Added successfully to department infrastructure");
                    for(IgniteMembers i : infrastructure)
                        System.out.println(i.toString());
                }
                else
                    System.out.println("Wrong choice");

        }


    }

}