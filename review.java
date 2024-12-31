
// You are given a sentence s and an integer k. You want to truncate s such that it contains only the first k words. Return s after truncating it.
 
// Input: s = "Hello how are you Contestant", k = 4
// Output: "Hello how are you"
// Explanation:
// The words in s are ["Hello", "how" "are", "you", "Contestant"].
// The first 4 words are ["Hello", "how", "are", "you"].
// Hence, you should return "Hello how are you".

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class review {

    public static void main(String[] args) {
        String s="Hello how are you Contestant";
        StringBuffer finalresult=new StringBuffer();
        int k=4;
        String[] sarray=s.split(" ");
        String[] result=new String[k];
        for(int i=0; i<k; i++){
            result[i]=sarray[i];
            if (i!=k-1) {
               result[i]=result[i]+" "; 
            }
            finalresult.append(result[i]);
           
        }
        System.out.println(finalresult);


       String arr= Arrays.stream(sarray).limit(k).collect(Collectors.joining(" "));
       System.out.println(arr);
    }
    
}
// Employees: Contains information about employees. 
// employee_id (primary key)
// name
// department_id
 

// Departments: Contains information about departments. 
// department_id (primary key)
// department_name
 

// Salaries: Contains information about employee salaries. 
// employee_id
// salary
// pay_date (the date the specific salary was recorded)

// You are required to write a SQL query to find the department name and 
// the average salary of employees in each department for the month of October 2024.

//  List the results by the average salary in descending order.

//  Select e.department_name from employee e join department d on e.department_id=d.department_id
//  union
//  select AVG(s.salary) from salaries s left join employee e on e.employeeid= s.employeeid 
// 13:55:37	SELECT d.department_name,avg(s.salary) as Averagesalary from Departments d join Employees e on d.department_id=e.department_id join Salaries s on e.employee_id=s.employee_id    -- group by d.department_id order by Averagesalary desc  where s.pay_date  between '2024-01-22' and '2024-02-03' LIMIT 0, 1000
// 	Error Code: 1140. In aggregated query without GROUP BY, expression #1 of SELECT list contains nonaggregated column 'company_db.d.department_name'; this is incompatible with sql_mode=only_full_group_by	0.000 sec
