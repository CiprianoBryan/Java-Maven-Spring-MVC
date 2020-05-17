package academy.learnprogramming.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {
    private final static String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup");
        // Create the web application context = spring container
        // Need to create the register servlet using that servlet context

        // The servlet context defines a set of methods that a servlet uses to communicate with its
        //    servlet container which in our case is tomcat so let´s create the spring context
        //    and register the web application
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // Let´s now register our web config class
        context.register(WebConfig.class);

        // Create the dispatcher servlet and register that with the servlet context
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
