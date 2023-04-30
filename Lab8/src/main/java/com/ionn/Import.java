package com.ionn;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
public class Import {

    Artist artistObj = new Artist();
    Genre genreObj = new Genre();
    Album albumObj = new Album();
    public void importFromDataSet(String path) throws FileNotFoundException, SQLException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            int year = Integer.parseInt(fields[1]);
            String album = fields[2];
            String artist = fields[3];
            String genre = fields[4];
            artistObj.create(artist);
            genreObj.create(genre);
            albumObj.create(year,album,artist,genre);
        }
        scanner.close();
    }
}
