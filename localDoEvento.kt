package Hotel;

import kotlin.math.ceil
import java.time.DayOfWeek
import java.time.LocalTime


fun localDoEvento() {

    fun localDoEvento(numeroConvidados: Int) {
        val capacidadeLaranja = 150
        val capacidadeLaranjaComCadeiras = 220
        val capacidadeColorado = 350

        if (numeroConvidados > capacidadeColorado || numeroConvidados < 0) {
            println("Número de convidados inválido")
        } else {
            if (numeroConvidados <= capacidadeLaranja) {
                val cadeirasAdicionais = ceil((numeroConvidados - capacidadeLaranja) / 2.0).toInt()
                println("O evento será no auditório Laranja.")
                println("Serão necessárias $cadeirasAdicionais cadeiras adicionais.")
            } else {
                println("O evento será no auditório Colorado.")
            }
        }
    }

    fun diaDaSemana() {
        val diaSemana = readLine()?.toLowerCase()
        val hora = readLine()?.toInt()

        if (diaSemana != null && hora != null) {
            val disponivel = verificarDisponibilidade(diaSemana, hora)
            if (disponivel) {
                val nomeEmpresa = readLine()
                println("Auditório reservado para $nomeEmpresa: $diaSemana às $hora hs")
            } else {
                println("Auditório não está disponível nesse dia e horário.")
            }
        } else {
            println("Entrada inválida.")
        }
    }
}

fun verificarDisponibilidade(diaSemana: String, hora: Int): Boolean {
    val dia = when (diaSemana) {
        "segunda" -> DayOfWeek.MONDAY
        "terca" -> DayOfWeek.TUESDAY
        "quarta" -> DayOfWeek.WEDNESDAY
        "quinta" -> DayOfWeek.THURSDAY
        "sexta" -> DayOfWeek.FRIDAY
        "sabado" -> DayOfWeek.SATURDAY
        "domingo" -> DayOfWeek.SUNDAY
        else -> null
    }

    val horarioInicio = LocalTime.of(7, 0)
    val horarioFimSemana = LocalTime.of(15, 0)
    val horarioFimSemanaExtendido = LocalTime.of(23, 0)

    return when {
        dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY -> hora in 7..15
        dia != null -> hora in 7..23
        else -> false
    }
}

fun calcularCustoGarcons(numeroConvidados: Int, duracaoEvento: Int): Double {
    val garconsPorConvidados = ceil(numeroConvidados.toDouble() / 12).toInt()
    val garconsPorHoras = ceil(duracaoEvento.toDouble() / 2).toInt()
    val totalGarcons = garconsPorConvidados + garconsPorHoras
    val custoGarcons = totalGarcons * 10.50
    return custoGarcons
}

fun duracaoEvento() {
    val duracaoEvento = readLine()?.toInt()
    if (duracaoEvento != null) {
        val numeroConvidados = duracaoEvento * 12
        val custoGarcons = calcularCustoGarcons(numeroConvidados, duracaoEvento)
        println("São necessários $numeroConvidados garçons.")
        println("Custo: R$ $custoGarcons")
        println("Agora vamos calcular o custo do buffet do hotel para o evento.")
    } else {
        println("Entrada inválida.")
    }
}

fun calcularCustoBuffet(numeroConvidados: Int): Double {
    val litrosCafe = numeroConvidados * 0.2
    val litrosAgua = numeroConvidados * 0.5
    val quantidadeSalgados = numeroConvidados * 7

    val custoCafe = litrosCafe * 0.8
    val custoAgua = litrosAgua * 0.4
    val custoSalgados = quantidadeSalgados / 100.0 * 34

    val custoTotal = custoCafe + custoAgua + custoSalgados

    println("O evento precisará de $litrosCafe litros de café, $litrosAgua litros de água, $quantidadeSalgados salgados.")
    println("Custo total com comida do evento: R$ $custoTotal")

    return custoTotal
}

fun numeroDeConvidades() {
    val numeroConvidados = readLine()?.toInt()
    if (numeroConvidados != null) {
        val custoBuffet = calcularCustoBuffet(numeroConvidados)
        println("Relatório de custos:")
        println("Custo com comida do evento: R$ $custoBuffet")
        val custoGarcons = ""
        println("Custo com garçons: R$ $custoGarcons")
        println("Agora vamos calcular o custo total do evento.")
        println("Você aceita todos os valores informados? (S/N)")
        val resposta = readLine()?.toUpperCase()
        if (resposta == "S") {
            val custoTotal = custoBuffet + custoGarcons
            println("Custo total do evento: R$ $custoTotal")
        } else {
            println("Valores não aceitos. O cálculo do custo total não será realizado.")
        }
    } else {
        println("Entrada inválida.")
    }

    sairCadastro()
}

private operator fun Double.plus(custoGarcons: String): Any {
    return custoGarcons
}
