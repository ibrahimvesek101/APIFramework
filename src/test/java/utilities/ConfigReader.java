package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;   //Create Properties instance
    static{
        String filePath="configuration.properties";  //path of the configuration file
        try {
            FileInputStream fis= null;
            try {
                fis = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            // fis dosyayolunu tanimladigimiz configuration.properties dosyasini okudu
            properties=new Properties();
            try {
                properties.load(fis); // fis'in okudugu bilgileri properties'e yukledi
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //close the file
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
    /*
      test method'undan yolladigimiz string key degerini alip
      Properties class'indan getProperty( ) method'unu kullanarak
      bu key'e ait String data typedaki value'u bize getirdi
      Dosyayı okumak için bu metodu oluşturuyoruz
     */
        return properties.getProperty(key);
    }
}
