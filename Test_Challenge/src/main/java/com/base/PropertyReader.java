package com.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    /**
     * Returns Site Properties.
     *
     * @return properties
     */
    public Properties getSiteProp() {

        Properties prop = new Properties();
        FileReader reader = null;
        File file = null;

        try {

            file = new File("Site_Properties" + File.separator + "Site.properties");

            if (file.exists()) {
                reader = new FileReader(file.getAbsolutePath());
                prop.load(reader);
            }

            return prop;

        } catch (IOException e) {
            return prop;
        }
    }

    /**
     * Returns Site Properties.
     *
     * @return properties
     */
    public Properties getDataProp() {

        Properties prop = new Properties();
        FileReader reader = null;
        File file = null;

        try {

            file = new File("Site_Properties" + File.separator + "Data.properties");

            if (file.exists()) {
                reader = new FileReader(file.getAbsolutePath());
                prop.load(reader);
            }

            return prop;

        } catch (IOException e) {
            return prop;
        }
    }
}
