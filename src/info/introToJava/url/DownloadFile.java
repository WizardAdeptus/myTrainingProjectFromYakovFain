package info.introToJava.url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please inter URL and OutputFileName");
            System.exit(0);
        }

        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            URL url = new URL(args[0]);
            URLConnection urlConnection = url.openConnection();

            fileOutputStream = new FileOutputStream(args[1]);
            inputStream = urlConnection.getInputStream();

            System.out.println("Downloading " + args[0]);

            int data;
            while ((data = inputStream.read()) != -1) {
                fileOutputStream.write(data);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("File " + args[0] + " is downloaded.");
        }
    }
}
