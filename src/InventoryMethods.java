/** Henry Vinh Tran; ITM 311-01; December 4th, 2023; FINAL PROJECT
This project will read the file "sales.txt" and display the inventory report on the output terminal.
________                          __              __                .__           .__                               
\______ \   ____     ____   _____/  |_    _______/  |_  ____ _____  |  |   ______ |  |   ____ _____    ______ ____  
 |    |  \ /  _ \   /    \ /  _ \   __\  /  ___/\   __\/ __ \\__  \ |  |   \____ \|  | _/ __ \\__  \  /  ___// __ \ 
 |____/    ( <_> ) |   |  (  <_> )  |    \___ \  |  | \  ___/ / __ \|  |__ |  |_> >  |_\  ___/ / __ \_\___ \\  ___/ 
/_______  /\____/  |___|  /\____/|__|   /____  > |__|  \___  >____  /____/ |   __/|____/\___  >____  /____  >\___  >
        \/              \/                   \/            \/     \/       |__|             \/     \/     \/     \/  */



public class InventoryMethods {

    public static int currentQuantity(int initialAmount, int quantitySold) {
        int currentAmount = initialAmount - quantitySold; // This will be the current quantity
        return currentAmount;
    }
    public static int amountToMinimum(int minimum, int currentAmount) {
        int neededAmount = minimum - currentAmount; // amount needed to be purchased to reach minimum.

        if (currentAmount >= minimum)
            neededAmount = 0;
        else if (minimum - currentAmount == 0)
            neededAmount = 0;
        
        return neededAmount;
    }






}
