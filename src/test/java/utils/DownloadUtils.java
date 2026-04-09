package utils;

import java.io.File;

public class DownloadUtils {

    public static void deleteFileIfExists(String downloadPath, String fileName) {
        File file = new File(downloadPath + File.separator + fileName);

        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean isFileDownloaded(String downloadPath, String fileName, int waitTimeInSeconds)
            throws InterruptedException {

        File file = new File(downloadPath + File.separator + fileName);
        File tempFile = new File(downloadPath + File.separator + fileName + ".crdownload");

        for (int i = 0; i < waitTimeInSeconds; i++) {

            if (file.exists() && file.length() > 0 && !tempFile.exists()) {
                return true;
            }

            Thread.sleep(1000);
        }

        return false;
    }
}