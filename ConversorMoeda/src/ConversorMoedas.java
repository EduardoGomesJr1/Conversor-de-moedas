import javax.swing.*;

public class ConversorMoedas {

    public static void main(String[] args) {

        exibirMenu();

    }

    public static void exibirMenu() {
        String[] opcoes = {
                "Conversão de Moedas",
                "Conversão de Temperatura",
                "Sair"
        };

        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Conversor de Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
            //chamar a função de conversão de moedas aqui
        } else if (escolha == 1) {
            // Chamar a função de conversão de temperatura aqui
        } else if (escolha == 2 || escolha == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }

    }
    // Aqui pode definir as outras funções de conversão e opções necessárias
}
