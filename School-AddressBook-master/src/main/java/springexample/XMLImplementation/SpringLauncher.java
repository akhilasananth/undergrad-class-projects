package springexample.XMLImplementation;

public class SpringLauncher {
    public static void main(String[] args) {
        String[] contextPaths = new String[]{"META-INF/app-context.xml"};
        new org.springframework.context.support.ClassPathXmlApplicationContext(contextPaths);
    }}
