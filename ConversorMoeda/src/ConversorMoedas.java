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

        String escolha = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma opção:",
                "Conversor de Moedas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if (escolha != null) {
            switch (escolha.charAt(0)) {
                case '1':
                    // chame a função para a conversão de moedas aqui
                    break;
                case '2':
                    // chame a função para outra opção de convesão aqui
                    break;
                case '3':
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o Conversor de Moedas!", "Conversor de Moedas", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                    exibirMenu();
            }
        }

    }

    public static void realizarConversaoDeMoedas() {
        String[] moedas = {"Real (BRL", "Dólar (USD)", "Euro (EUR)"}; //adicionar mais moedas

        String moedaEscolhida = (String) JOptionPane.showInputDialog(
                null,
                "Escolha a moeda de conversão:",
                "Conversor de Moedas - Escolha a Moeda",
                JOptionPane.PLAIN_MESSAGE,
                null,
                moedas,
                moedas[0]
        );

        if (moedaEscolhida != null) {
            double valor = obterValorValidado();

            String[] moedasDestino = new String[moedas.length - 1];
            int index = 0;
            for (String moeda : moedas) {
                if (!moeda.equals(moedaEscolhida)) {
                    moedasDestino[index] = moeda;
                    index++;
                }
            }

            String moedaDestinoEscolhida = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha a moeda de destino:",
                    "Conversor de Moedas - Escolha a Moeda de Destino",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    moedasDestino,
                    moedasDestino[0]
            );

            if (moedaDestinoEscolhida != null) {
                double valorConvertido = realizarConversao(valor, moedaEscolhida, moedaDestinoEscolhida);
                mostrarResultado(valor,moedaEscolhida, valorConvertido, moedaDestinoEscolhida);


                //agora pode realizar a conversao com o valor, a moeda escolhida
                // como origem e a moeda escolhida como destino
            }
        }
    }

    public static double obterValorValidado() {
        double valor = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            String valorStr = JOptionPane.showInputDialog(
                    null,
                    "Digite o valor a ser convertido",
                    "Conversor de Moedas - Digite o Valor",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (validarEntradaNumerica(valorStr)){
                valor = Double.parseDouble(valorStr);
                entradaValida = true;
            } else  {
                JOptionPane.showInputDialog(null, "Valor inválido. Digite um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Agora pode realizar a conversão com o valor inserido
        // e a moeda escolhida pelo usuário


        return valor;
    }

    public static boolean validarEntradaNumerica(String valorStr) {
        try {
            Double.parseDouble(valorStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public  static double realizarConversao(double valor, String moedaOrigem, String moedaDestino) {
        // implemente a lógica real de conversão aqui
        // retorna o valor convertido
        return  valor * 2.0; //exemplo de conversão fictícia
    }

    public  static void mostrarResultado(double valorOrigem, String moedaOrigem, double valorDestino, String moedaDestino) {
        String mensagem = String.format("%.2f %s é equivalente a %.2f %s.", valorOrigem, moedaOrigem, valorDestino, moedaDestino);
        JOptionPane.showInputDialog(null, mensagem, "Resultado da Conversão", JOptionPane.INFORMATION_MESSAGE);
    }
}
