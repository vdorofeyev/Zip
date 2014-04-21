package ru.MedcoreSoft.Zip;


import java.io.*;
import java.net.Socket;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Администратор on 11.04.2014.
 */
public class MainClass {
  public static void main(String[] args)
  {
   /*
      FileOutputStream fos = new FileOutputStream(file);
      ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(fos));
      zos.putNextEntry(new ZipEntry(file.getName()+".bin"))
      ObjectOutputStream oos = new ObjectOutputStream(zos)
      withOutputStream(oos)(strm => {
          serializeDrawingToStream(strm,file.getName());
 */
      File file = new File("C:\\tmp\\1.txt");//Н\\IMG_3279.JPG");
      FileInputStream fis=null;
      try {
        fis = new FileInputStream(file);
      } catch (FileNotFoundException e) {
          e.printStackTrace();
         return;
      }
      Socket socket = null;
      try {
          socket = new Socket("localhost", 3128);
      } catch (IOException e) {
          e.printStackTrace();
      }
      OutputStream sout = null;
      try {
          sout = socket.getOutputStream();
      } catch (IOException e) {
          e.printStackTrace();
          return;
      }
     BufferedOutputStream bos = new BufferedOutputStream(sout);
     ZipOutputStream zos = new ZipOutputStream(bos);
      byte[] buffer = new byte[10240];
      try {
        zos.putNextEntry( new ZipEntry("1.jpg"));
         while(
                  fis.read(buffer)
          >0)
        zos.write(buffer);
          zos.closeEntry();
      }
      catch (IOException e) {
          e.printStackTrace();
      }

 /*       return;
      try {
         zos.putNextEntry( new ZipEntry("1.jpg"));
          while(fis.read(buffer)>0)
              zos.write(buffer);
         for (int i = 0; i < 10; i++) {
              // not available on BufferedOutputStream
              zos.putNextEntry(new ZipEntry("hello-world." + i + ".txt"));
              zos.write("Hello World!".getBytes());
              // not available on BufferedOutputStream
              zos.closeEntry();
          }

      } catch (IOException e) {
          e.printStackTrace();
      }
    */
           finally {
          try {
              zos.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

  }
}
