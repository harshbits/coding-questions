package facebook.leetcode_2020.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalculateTaxAndSalary {

    public static void main(String[] args) {
        new CalculateTaxAndSalary(null).test();
    }

    private List<TaxBracket> taxBrackets;

    public void test() {
        //[10000, .3],[20000, .2], [30000, .1], [None, .1]].
        List<TaxBracket> taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(10000, 0.3));
        taxBrackets.add(new TaxBracket(20000, 0.2));
        taxBrackets.add(new TaxBracket(null, 0.1));
        taxBrackets.add(new TaxBracket(30000, 0.1));

        CalculateTaxAndSalary tax = new CalculateTaxAndSalary(taxBrackets);

        //10000 * 0.3 = 3000 + 20000 * 0.2 = 4000 + 30000 * 0.1 = 3000 + 10000 * 0.1 = 1000
        // 3000 + 4000 + 3000 + 1000 = 11000
        double t = tax.calculate(70000);
        System.out.println(t);
    }

    public CalculateTaxAndSalary(List<TaxBracket> taxBrackets) {
        // not needed if sorted
        if (taxBrackets == null) {
            this.taxBrackets = new ArrayList<>();
        } else {
            this.taxBrackets = taxBrackets;
        }
        //assuming sorted
        // o(n log n)
        Collections.sort(this.taxBrackets, new Comparator<TaxBracket>() {
            @Override
            public int compare(TaxBracket o1, TaxBracket o2) {
                if (o1.salary == null && o2.salary == null) {
                    return 0;
                }
                if (o1.salary == null && o2.salary != null) {
                    return 1;
                }
                if (o1.salary != null && o2.salary == null) {
                    return -1;
                }
                return o1.salary - o2.salary;
            }
        });
    }

    // O(n) ; n = number of tax brackets
    private double calculate(int income) {
        double totalTax = 0.0;
        for (TaxBracket taxBracket : taxBrackets) {
            // we will reach here when we passed all the brackets
            // since this is sorted
            if (taxBracket.salary == null) {
                totalTax += income * taxBracket.tax;
                break;
            }

            if (income > taxBracket.salary) {
                totalTax += taxBracket.salary * taxBracket.tax;
                income = income - taxBracket.salary;
            } else {
                totalTax += income * taxBracket.tax;
                //income = 0;
                break;
            }
        }
        return totalTax;
    }

    private class TaxBracket {
        Integer salary;
        Double tax;

        public TaxBracket(Integer salary, Double tax) {
            this.salary = salary;
            this.tax = tax;
        }
    }
}
