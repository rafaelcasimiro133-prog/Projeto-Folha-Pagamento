public class Colaborador {private int matricula;
private String nome;
private double salarioBase;

private static final double SALARIO_BASE = 2000.00;

public Colaborador(int matricula, String nome) {
    this.matricula = matricula;
    this.nome = nome;
    this.salarioBase = SALARIO_BASE;
}
public int getMatricula() {
    return matricula;
}

public String getNome() {
    return nome;
}

public double getSalarioBase() {
    return salarioBase;
}
public double calcularSalarioFinal() {
    return salarioBase;
}
public void exibirDados() {
    System.out.println("Matricula: " + matricula);
    System.out.println("Nome: " + nome);
    System.out.println("Salario Base: R$ " + salarioBase);
    System.out.println("Salario Final: R$ " + calcularSalarioFinal());
}
}