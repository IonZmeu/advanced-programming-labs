package org.ionn;

import java.io.*;

public class ReadThread extends Thread {
    private final InputStream inputStream;
    public ReadThread(InputStream inputStream) {
        this.inputStream = inputStream;

    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        while (true){
            try {
                System.out.println(in.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
