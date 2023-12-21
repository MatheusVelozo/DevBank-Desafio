import java.util.Scanner;

public class Client {

    private String name;
    private Integer age;
    private Double cpf;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getCpf() {
        return cpf;
    }

    public void setCpf(Double cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Client Name: " + name;
    }
}
