/** Henry Vinh Tran; ITM 311-01; December 4th, 2023; FINAL PROJECT
This project will read the file "sales.txt" and display the inventory report on the output terminal.
________                          __              __                .__           .__                               
\______ \   ____     ____   _____/  |_    _______/  |_  ____ _____  |  |   ______ |  |   ____ _____    ______ ____  
 |    |  \ /  _ \   /    \ /  _ \   __\  /  ___/\   __\/ __ \\__  \ |  |   \____ \|  | _/ __ \\__  \  /  ___// __ \ 
 |____/    ( <_> ) |   |  (  <_> )  |    \___ \  |  | \  ___/ / __ \|  |__ |  |_> >  |_\  ___/ / __ \_\___ \\  ___/ 
/_______  /\____/  |___|  /\____/|__|   /____  > |__|  \___  >____  /____/ |   __/|____/\___  >____  /____  >\___  >
        \/              \/                   \/            \/     \/       |__|             \/     \/     \/     \/  */

import java.util.Scanner;
import java.io.File;

public class InventoryReportGenerator extends InventoryMethods {
    public static void main(String[] args) throws Exception {

        // Check to make sure the file exists.
        File file = new File("sales.txt");
        if (!file.isFile()) {
            System.out.println("ERROR! Invalid file. Check spelling or if the file exists at all.");
            System.exit(1);
        }

        // Read the file.
        String[][] partInfoArray = new String[10][4];

        try (Scanner readingTheFile = new Scanner(file)) {
            int rowIndex = 0;
            while (readingTheFile.hasNext() && rowIndex < 10) {
                String line = readingTheFile.nextLine();
                
                // Skip the header line
                if (line.contains("part\tinitial_amount\tqty_sold\tminimum")) {
                    continue;
                }
                
                // Split line by line into pieces and place data into array.
                String[] lineParts = line.split("\\s+"); // Split on any whitespace
                
                for (int i = 0; i < lineParts.length && i < 4; i++) {
                    partInfoArray[rowIndex][i] = lineParts[i]; // Have each column be an attribute and each row be for each part.
                }
                
                rowIndex++;
            }
            
            // Display the various counts to generate the report.
            System.out.println("----------------------------------------------------------------------");
            System.out.println("| Part Number || Current Quantity || Amount to Purchase until Minimum|");
            System.out.println("----------------------------------------------------------------------");
            
            for (int j = 0; j < rowIndex; j++) {
                String iniAmoString = partInfoArray[j][1];
                String qtyString = partInfoArray[j][2];
                String minString = partInfoArray[j][3];
                
                int initialAmount = Integer.parseInt(iniAmoString);
                int qtySold = Integer.parseInt(qtyString);
                int minimum = Integer.parseInt(minString);
                
                int currentAmount = currentQuantity(initialAmount, qtySold);
                
                System.out.println("| "+ partInfoArray[j][0] + "\t\t" + currentAmount + "\t\t\t" + amountToMinimum(minimum, currentAmount) + "\t\t     |");
            }
            System.out.println("----------------------------------------------------------------------");
        }
    }
}