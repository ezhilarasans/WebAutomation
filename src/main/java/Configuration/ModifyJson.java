package Configuration;

import java.io.*;

public class ModifyJson {
    public ModifyJson() {
    }

    public static void updateJsonFile(String inFilePath, String outFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inFilePath));
        FileWriter writer = new FileWriter(outFilePath);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String modifiedLine = line.replaceAll("\\\\n", " ").replaceAll("\\\\", "");
            writer.write(modifiedLine);
            writer.write("\n");
        }
        reader.close();
        writer.close();
    }
}
