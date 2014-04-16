package ru.MedcoreSoft.Zip;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Администратор on 11.04.2014.
 */
public class MainClass {
  public static void main(String[] args)
  {
      System.out.println("Hi!");

      FileOutputStream fos = null;
      try {
          fos = new FileOutputStream("hello-world.zip");
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
         BufferedOutputStream bos = new BufferedOutputStream(fos);
      ZipOutputStream zos = new ZipOutputStream(bos);

      try {
          for (int i = 0; i < 10; i++) {
              // not available on BufferedOutputStream
              zos.putNextEntry(new ZipEntry("hello-world." + i + ".txt"));
              zos.write("Hello World!".getBytes());
              // not available on BufferedOutputStream
              zos.closeEntry();
          }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          try {
              zos.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
}
