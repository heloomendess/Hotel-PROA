package Hotel

var nomeHotel = "Hotel Everest";
var quartosOcupados = mutableListOf<Int>()

fun main() {
    // Função principal que chama a função inicio().
    inicio()
    cadastrarQuartos()
    cadastrarHospedes()
    abastecimentoDoAutomovel()
    localDoEvento()
    manutencaoDoAr()
    sairDoHotel()
    erro()

}

fun inicio() {

    print("Bem vindo ao $nomeHotel!\n")
    println("Menu do hotel:")
    println("1- Cadastrar quartos")
    println("2- Cadastrar hospedes")
    println("3- Abastecimento de automóveis")
    println("4- Local do evento")
    println("5- Manutenção do ar condicionado")
    println("6- Sair do hotel")
    println("\n")
    println("Escolha uma opção: ")

    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função inicio().
    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastrarQuartos()
        2 -> cadastrarHospedes()
        3 -> abastecimentoDoAutomovel()
        4 -> localDoEvento()
        5 -> manutencaoDoAr()
        6 -> sairDoHotel()
        else -> erro()
    }
}

