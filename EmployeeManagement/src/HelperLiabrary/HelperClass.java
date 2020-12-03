/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperLiabrary;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Tlholo Makhene
 */
public class HelperClass {
    
     public static String getFileToCrawl(String directory){
         File dir = new File(directory);

      String[] children = dir.list();
      if (children == null) {
          return "";
      } else {
          int i=0;
          String filename = children[i];
          while (i<children.length && !filename.contains(".txt")){
              i++;
              filename = children[i];
          }
          return filename;
      }

  }
     
     public static Path currentPath = Paths.get(System.getProperty("user.dir"));


}
