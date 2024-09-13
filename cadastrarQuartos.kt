package Hotel

import Hotel.inicio
import Hotel.nomeHotel
import Hotel.quartosOcupados
import Hotel.sairCadastro

fun cadastrarQuartos() {
    println("Qual é o valor da diária?")
    var valorDiaria = readln().toDouble()

    if(valorDiaria <= 0) {
        println("O valor da diária não é válido.")
    } else {
        println("O valor da diária é R$$valorDiaria")
    }

    println("Quantos dias deseja se hospedar?")
    var dias = readln().toInt()

    if (dias <= 0) {
        println("O número de dias não é válido.")
    } else if (dias > 30) {
        println("Valor inválido. O número de dias não pode ser maior que 30")
    } else {
        println("Você deseja se hospedar por $dias dias.")
    }

    println("Informe o nome completo do hóspede: ")
    var nomeHospede = readln()

    println("Informe o número do quarto (de 1 a 20): ")
    var numeroQuarto = readln().toInt()

    while (numeroQuarto !in 1..20) {
        println("Número de quarto inválido. Informe novamente: ")
        numeroQuarto = readln().toInt()
    }

    if (quartosOcupados.contains(numeroQuarto)) {
        println("Quarto já está ocupado.")
        println("Deseja escolher outro quarto? (S/N)")
        val escolherOutroQuarto = readln().toUpperCase()
        if (escolherOutroQuarto == "S") {
            cadastrarQuartos()
        } else {
            inicio()
        }
    } else {
        quartosOcupados.add(numeroQuarto)
        println("Quarto $numeroQuarto ocupado com sucesso.")
    }

    println("$nomeHospede, você deseja confirmar a reserva no valor de R$$valorDiaria por $dias dias? (S/N)")
    val confirmarReserva = readln().toUpperCase()

    if (confirmarReserva == "S") {
        println("Reserva confirmada.")
    } else {
        println("Reserva cancelada.")
        println("Voltado para o início...")
        inicio()
    }
    sairCadastro()
}

fun erro(){
    println("Por favor, informe um número entre 1 e 4.")
    inicio()
}

fun sairDoHotel() {
    println("Você deseja sair?")
    val confirma = readln().toBoolean()
    if (confirma) {
        println("Até logo! Obrigada por se hospedar no $nomeHotel!")
    } else {
        inicio()
    }
}