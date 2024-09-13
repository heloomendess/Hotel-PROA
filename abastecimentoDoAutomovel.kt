package Hotel

import java.util.*

fun abastecimentoDoAutomovel() {
    println("Informe o valor do álcool no posto Wayne Oil: ")
    val valorAlcoolWayneOil = readln().toDouble()

    println("Informe o valor da gasolina no posto Wayne Oil: ")
    val valorGasolinaWayneOil = readln().toDouble()

    println("Informe o valor do álcool no posto Stark Petrol: ")
    val valorAlcoolStarkPetrol = readln().toDouble()

    println("Informe o valor da gasolina no posto Stark Petrol: ")
    val valorGasolinaStarkPetrol = readln().toDouble()

    val litrosAbastecidos = 42

    val valorTotalAlcoolWayneOil = valorAlcoolWayneOil * litrosAbastecidos
    val valorTotalGasolinaWayneOil = valorGasolinaWayneOil * litrosAbastecidos
    val valorTotalAlcoolStarkPetrol = valorAlcoolStarkPetrol * litrosAbastecidos
    val valorTotalGasolinaStarkPetrol = valorGasolinaStarkPetrol * litrosAbastecidos

    val valorTotalAlcool = if (valorTotalAlcoolWayneOil < valorTotalAlcoolStarkPetrol) {
        valorTotalAlcoolWayneOil
    } else {
        valorTotalAlcoolStarkPetrol
    }

    val valorTotalGasolina = if (valorTotalGasolinaWayneOil < valorTotalGasolinaStarkPetrol) {
        valorTotalGasolinaWayneOil
    } else {
        valorTotalGasolinaStarkPetrol
    }

    val combustivelMaisAtraente = if (valorTotalAlcool * 1.3 < valorTotalGasolina) {
        "álcool"
    } else {
        "gasolina"
    }

    val postoMaisBarato = if (valorTotalAlcool < valorTotalGasolina) {
        "Wayne Oil"
    } else {
        "Stark Petrol"
    }

    println("O combustível mais atraente é o $combustivelMaisAtraente.")
    println("O posto mais barato é o $postoMaisBarato.")

    sairCadastro();
}