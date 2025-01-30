import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
public @interface EnhancementRequest{
    int Id();
    String Sypnosis();
    String Engineer() default "undefined";
    String Date() default "Unknown";
}