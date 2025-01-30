public class Main{
	public static void main(String[] args) throws Exception {
        Class<?> clazz = BugFixClass.class;
        if (clazz.isAnnotationPresent(EnhancementRequest.class)) {
            EnhancementRequest annotation = clazz.getAnnotation(EnhancementRequest.class);
            System.out.println("ID: " + annotation.Id());
            System.out.println("Synopsis: " + annotation.Sypnosis());
            System.out.println("Engineer: " + annotation.Engineer());
            System.out.println("Date: " + annotation.Date());
        }
    }
}

