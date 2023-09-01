import javax.swing.*;

public class ConversorMoedas {

    public static void main(String[] args) {

        exibirMenu();

    }

    public static void exibirMenu() {
        boolean opcaoValida = false;


        String[] opcoes = {"Conversão de Moedas", "Conversão de Temperatura", "Sair"};

        String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Conversor de Moedas", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha != null) {
            switch (escolha) {
                case "Conversão de Moedas":
                    realizarConversaoDeMoedas();
                    break;
                case "Conversão de Temperatura":
                    converterTemperatura();
                    break;
                case "Sair":
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
        String[] moedas = {"Real (BRL)", "Dólar (USD)", "Euro (EUR)"};

        String moedaEscolhida = (String) JOptionPane.showInputDialog(null, "Escolha a moeda de conversão:", "Conversor de Moedas - Escolha a Moeda", JOptionPane.PLAIN_MESSAGE, null, moedas, moedas[0]);

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

            String moedaDestinoEscolhida = (String) JOptionPane.showInputDialog(null, "Escolha a moeda de destino:", "Conversor de Moedas - Escolha a Moeda de Destino", JOptionPane.PLAIN_MESSAGE, null, moedasDestino, moedasDestino[0]);

            if (moedaDestinoEscolhida != null) {
                double valorConvertido = realizarConversao(valor, moedaEscolhida, moedaDestinoEscolhida);
                mostrarResultado(valor, moedaEscolhida, valorConvertido, moedaDestinoEscolhida);

                int opcao = JOptionPane.showConfirmDialog(null, "Deseja fazer outra conversão?", "Continuar?", JOptionPane.YES_NO_CANCEL_OPTION);

                if (opcao == JOptionPane.YES_OPTION) {
                    exibirMenu();
                } else if (opcao == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Programa finalizado.", "Fim do programa", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } else if (opcao == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "Programa concluído.", "Fim do programa", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }


            }
        }
    }

    public static double obterValorValidado() {
        double valor = 0.0;
        boolean entradaValida = false;

        while (!entradaValida) {
            String valorStr = JOptionPane.showInputDialog(null, "Digite o valor a ser convertido", "Conversor de Moedas - Digite o Valor", JOptionPane.PLAIN_MESSAGE);

            if (validarEntradaNumerica(valorStr)) {
                valor = Double.parseDouble(valorStr);
                entradaValida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Valor inválido. Digite um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

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

    public static double realizarConversao(double valor, String moedaOrigem, String moedaDestino) {
        double taxaConversao = 0.0;

        if (moedaOrigem.equals("Real (BRL)") && moedaDestino.equals("Dólar (USD)")) {
            taxaConversao = 0.2;
        } else if (moedaOrigem.equals("Dólar (USD)") && moedaDestino.equals("Real (BRL)")) {
            taxaConversao = 5.0;
        } else if (moedaOrigem.equals("Real (BRL)") && moedaDestino.equals("Euro (EUR)")) {
            taxaConversao = 0.18;
        } else if (moedaOrigem.equals("Euro (EUR)") && moedaDestino.equals("Real (BRL)")) {
            taxaConversao = 5.5;
        }

        return valor * taxaConversao;
    }

    public static void mostrarResultado(double valorOrigem, String moedaOrigem, double valorDestino, String moedaDestino) {
        String mensagem = String.format("%.2f %s é equivalente a %.2f %s.", valorOrigem, moedaOrigem, valorDestino, moedaDestino);
        JOptionPane.showMessageDialog(null, mensagem, "Resultado da Conversão", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void converterTemperatura() {
        JOptionPane.showMessageDialog(null, "Função de conversão em manutenção", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
}
