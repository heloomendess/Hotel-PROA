package Hotel

fun manutencaoDoAr() {
    val empresas = mutableListOf<String>()
    val valores = mutableListOf<Double>()
    val quantidades = mutableListOf<Int>()
    val descontos = mutableListOf<Double>()
    val minimos = mutableListOf<Int>()

    do {
        println("Qual o nome da empresa?")
        val empresa = readLine()
        empresas.add(empresa!!)

        println("Qual o valor por aparelho?")
        val valor = readLine()?.toDouble()
        valores.add(valor!!)

        println("Qual a quantidade de aparelhos?")
        val quantidade = readLine()?.toInt()
        quantidades.add(quantidade!!)

        println("Qual a porcentagem de desconto?")
        val desconto = readLine()?.toDouble()
        descontos.add(desconto!!)

        println("Qual o número mínimo de aparelhos para conseguir o desconto?")
        val minimo = readLine()?.toInt()
        minimos.add(minimo!!)

        println("Deseja informar novos dados? (S/N)")
        val resposta = readLine()
    } while (resposta == "n" && resposta == "N")

    var menorValor = Double.MAX_VALUE
    var empresaMenorValor = ""

    for (i in 0 until empresas.size) {
        val valorTotal = valores[i] * quantidades[i]
        val valorComDesconto = if (quantidades[i] > minimos[i]) {
            valorTotal - (valorTotal * descontos[i] / 100)
        } else {
            valorTotal
        }

        if (valorComDesconto < menorValor) {
            menorValor = valorComDesconto
            empresaMenorValor = empresas[i]
        }

        println("O serviço de ${empresas[i]} custará R$ $valorComDesconto")
    }

    println("O orçamento de menor valor é o de $empresaMenorValor por R$ $menorValor")

    sairCadastro()
}