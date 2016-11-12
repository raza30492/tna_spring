package com.example.springdatajpa.config;


import com.example.springdatajpa.entity.Role;
import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.service.DesgnService;
import com.example.springdatajpa.service.EmployeeService;
import com.example.springdatajpa.util.PasswordUtil;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ContextListener implements ServletContextListener{

   private final Logger logger = LoggerFactory.getLogger(ContextListener.class);
   
   @Autowired
   private EmployeeService employeeService;
   
   @Autowired
   private DesgnService desgnService;
   
   @Override
   public void contextInitialized(ServletContextEvent sce) {
      logger.info("contextInitialized()");
      
      WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
              .getAutowireCapableBeanFactory()
              .autowireBean(this);
      //Check if Designations exist
      if(desgnService.countDesgns() == 0L){
          desgnService.saveDesgns(Role.values());
      }
      
      if(employeeService.findOne(55555) == null){
          Employee employee = new Employee(55555, "Md Zahid Raza", "zahid7292@gmail.com", "8987525008", LocalDate.of(1995, Month.SEPTEMBER, 5));
          employee.setPassword(PasswordUtil.encrypt("admin"));
          employee.setDesgn(desgnService.findByRole(Role.ADMIN));
          employeeService.saveUser(employee);
      }
      
   }

   @Override
   public void contextDestroyed(ServletContextEvent sce) {
      logger.info("contextDestroyed()");
      try{
         AbandonedConnectionCleanupThread.shutdown();
         logger.info("AbandonedConnectionCleanupThread stopped.");
      }catch(InterruptedException e){
         logger.error("Failed to stop AbandonedConnectionCleanupThread.");
      }
      
      Enumeration<Driver> drivers = DriverManager.getDrivers();
      Driver driver = null;
      while(drivers.hasMoreElements()){
         driver = drivers.nextElement();
         try{
            DriverManager.deregisterDriver(driver);
            logger.info(driver + " deregistered.");
         }catch(SQLException e){
            logger.error("Failed to deregidter Driver");
         }
      }
   }

}

