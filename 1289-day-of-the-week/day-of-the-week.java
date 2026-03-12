import java.util.*;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        
        String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day); 
        
        return days[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }
}