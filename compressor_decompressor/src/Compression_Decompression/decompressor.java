package Compression_Decompression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException{
        String filedirectory=file.getParent();
        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzipIS=new GZIPInputStream(fis);
        FileOutputStream fos= new FileOutputStream(filedirectory+"/Decompressedfilecheck");

        byte[] buffer=new byte[1024];

        int len;

        while((len=gzipIS.read(buffer)) != -1)
        {
            System.out.println("length of file is :" + len);
            fos.write(buffer, 0, len);
        }

        gzipIS.close();
        fis.close();
        fos.close();
    }
    public static void main(String[] args) throws IOException {
        File path=new File("");
        method(path);
    }
}
