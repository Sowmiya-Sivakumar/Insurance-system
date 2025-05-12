   package util;

   import java.io.FileInputStream;
   import java.io.IOException;
   import java.util.Properties;

   public class DBPropertyUtil {
       public static String getConnectionString(String fileName) {
           Properties properties = new Properties();
           try (FileInputStream input = new FileInputStream(fileName)) {
               properties.load(input);
               String url = properties.getProperty("db.url");
               String username = properties.getProperty("db.username");
               String password = properties.getProperty("db.password");
               return url + "?user=" + username + "&password=" + password;
           } catch (IOException e) {
               e.printStackTrace();
               System.out.println("Connection string is null. Please check your db.properties file.");
               return null;
           }
       }
   }
   