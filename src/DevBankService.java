import java.util.Random;
import java.util.Scanner;

public class DevBankService {

    private Client client;
    private Integer agencyNumber;
    private Integer accountNumber;
    private Float balanceAvaliable = 0F;
    public String accountType;

    private static final Random random = new Random();

    public DevBankService() {
        this.agencyNumber = generateUniqueNumber();
        this.accountNumber = generateUniqueNumber();
    }
    private Integer generateUniqueNumber() {
        int min = 10000;
        int max = 99999;
        return random.nextInt((max - min) + 1) + min;
    }
    public void accountInformation() {
        System.out.println("-------------------------");
        System.out.println(this.client);
        System.out.println(this.toString());
        System.out.println("-------------------------");
    }

    public void openAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("---WELCOME TO DEV BANK---");
        System.out.println("-------------------------");
        System.out.println("Choose your account: CurrentAccount or SavingAccount.");
        accountType = sc.nextLine();

        if (accountType.equals("CurrentAccount")) {
            this.client = new Client();
            System.out.println("---Open an Current Account at DEV Bank---");
            System.out.println("--------What's your first name: ---------");
            client.setName(sc.nextLine());
            System.out.println("------------What's your age: ------------");
            client.setAge(sc.nextInt());
            System.out.println("------------What's your CPF: ------------");
            client.setCpf(sc.nextDouble());
            System.out.println("Current Account opened successfully!");
        } else if (accountType.equals("SavingAccount")) {
            this.client = new Client();
            System.out.println("----Open an Saving Account at DEV Bank---");
            System.out.println("--------What's your first name: ---------");
            client.setName(sc.nextLine());
            System.out.println("------------What's your age: ------------");
            client.setAge(sc.nextInt());
            System.out.println("------------What's your CPF: ------------");
            client.setCpf(sc.nextDouble());
            System.out.println("Saving Account opened successfully!");
        } else {
            System.out.println("Invalid account type.");
        }

    }

    public void deposit() {

        if (accountType.equals("CurrentAccount")) {
            Scanner sc = new Scanner(System.in);
            float d;
            System.out.println("---How much would you like to deposit?---");
            d = sc.nextFloat();
            this.setBalanceAvaliable(this.getBalanceAvaliable() + d);
            System.out.println("Deposit successful!\n" +
                    "Your new balance is: " + this.getBalanceAvaliable());
            System.out.println("-------------------------");
        } else if (accountType.equals("SavingAccount")) {
            Scanner sc = new Scanner(System.in);
            float s;
            System.out.println("---How much would you like to deposit?---");
            s = sc.nextFloat();
            this.setBalanceAvaliable(this.getBalanceAvaliable() + s);
            System.out.println("Deposit successful!\n"
                    + "Your money will be yielding 10% p.a.\n" +
                    "Your new balance: " + this.getBalanceAvaliable());
            System.out.println("-------------------------");
        }

    }

    public void withdraw() {
        if (balanceAvaliable == 0) {
            System.out.println("Unavailable balance!");
        } else {
            float w;
            Scanner sc = new Scanner(System.in);
            System.out.println("Withdraw amount: ");
            w = sc.nextFloat();
            this.setBalanceAvaliable(this.getBalanceAvaliable() - w);
            System.out.println("Successful withdraw!\n"
                    + "Current balance: " + this.getBalanceAvaliable());
            System.out.println("-------------------------");
        }
    }

    public void closeAccount() {
        if (this.balanceAvaliable > 0) {
            System.out.println("You have balance in your account, impossible to closed.");
        } else if (this.balanceAvaliable < 0) {
            System.out.println("Your account is negative, pay your debts.");
        } else {
            Scanner sc = new Scanner(System.in);
            Integer cc;
            System.out.println("--------CLOSE ACCOUNT-------");
            System.out.println("Inform your account number: ");
            cc = sc.nextInt();
            if (cc.equals(this.getAccountNumber())) {
                System.out.println("-------------------------");
                System.out.println("Thanks, your account has been closed successfully.");
            } else {
                System.out.println("Account number provided does not match!");
            }
        }
    }

    public Integer getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(Integer agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getBalanceAvaliable() {
        return balanceAvaliable;
    }

    public void setBalanceAvaliable(Float balanceAvaliable) {
        this.balanceAvaliable = balanceAvaliable;
    }

    @Override
    public String toString() {
        return "Agency Number: " + this.getAgencyNumber() + "\n"
                + "Account Number: " + this.getAccountNumber() + "\n"
                + "Balance: " + this.getBalanceAvaliable();
    }
}
