public class TestClass {
    public static void main(String[] args) {
        SalesGoal goal = new SalesGoal();
        goal.setCost(1.25);
        goal.setCandyName("Skittles");
        goal.setName("Bob James");
        goal.setQty(10);
        goal.setMonth(9);
        goal.setDay(10);
        System.out.println(goal.toString() + "\n" + goal.feedback());

        SalesGoal goals = new SalesGoal(.25, "M&M's", "Bobby Johnson", 50, 10, 19);
        System.out.println(goals.toString() + "\n" + goals.feedback());
    }
}
