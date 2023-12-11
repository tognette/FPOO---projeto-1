package br.org.sesisp.view;

import br.org.sesip.dao.CrudDAO;

import br.org.sesisp.model.Aluno;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class TelaMain {
	public static void main(String[] args) {
		CrudDAO inserir_aluno = new CrudDAO();
		
		Scanner entrada = new Scanner(System.in);
		Aluno aluno1 = new Aluno();
	
		System.out.println("Digite o numero de acordo com a acao que deseja realizar!!");
		System.out.println("- 1 - Create");
		System.out.println("- 2 - Update ");
		System.out.println("- 3 - Read");
		System.out.println("- 4 - Delete");
		int escolha = entrada.nextInt();
		
		switch(escolha) {
		case 1 :
		aluno1.setNome(JOptionPane.showInputDialog("Insira o nome o aluno: "));
		aluno1.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Insira a idade do aluno: ")));
		inserir_aluno.create(aluno1);
		System.out.println("Nome: " + aluno1.getNome());
		System.out.println("Idade: " + aluno1.getIdade());
		break;
		
		case 2 :
		aluno1.setNome("José");
		aluno1.setIdade(17);
		aluno1.setNome(JOptionPane.showInputDialog("Insira o nome a ser atualizado: "));
		aluno1.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Insira a idade a ser alterada: ")));
		aluno1.setRa(1);
		inserir_aluno.update(aluno1);
		System.out.println("Nome: " + aluno1.getNome());
		System.out.println("Idade: " + aluno1.getIdade());
		break;
		
		case 3 :
		System.out.println("lendo lista...");
		for(Aluno olho : inserir_aluno.read()) {
			System.out.println("Dados do aluno: " + olho.getRa()+ " " + olho.getNome() + " " + olho.getIdade());
		}
		break;
		
		case 4 :
		CrudDAO remover_aluno = new CrudDAO();
		remover_aluno.delete(Integer.parseInt(JOptionPane.showInputDialog("insira o numero do aluno a ser excluio: ")));
		System.out.println("Aluno removido com sucesso!");
		break;
		}
	}
}
//ALTER TABLE alunos AUTO_INCREMENT = 1;