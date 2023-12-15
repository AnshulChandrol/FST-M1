package activities;

public class Activity8 {
    public static void main(String[] args) {
        try {
            Activity8.exceptionTest("Test");
            Activity8.exceptionTest(null);
        } catch (CustomException e) {
            System.out.println("inside catch block "+e.getMessage());
        }
    }

    public static void exceptionTest(String str) throws CustomException {
        if (str == null) {
            throw new CustomException("String value is null");

        } else {
            System.out.println(str);

        }
    }
}
