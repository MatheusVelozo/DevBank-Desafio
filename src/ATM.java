import java.util.Random;

public class ATM {
    public static void main(String[] args) {

        DevBankService devBankService = new DevBankService();
        devBankService.openAccount();
        devBankService.accountInformation();
        devBankService.deposit();
        devBankService.withdraw();
        devBankService.closeAccount();

    }
}