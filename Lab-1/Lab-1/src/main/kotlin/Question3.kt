class Question3 {
    fun getFirstLas(number: Int): Int {
        val lastNumber = number % 10;
        var firstNumber = number;

        while (firstNumber >= 10) {
            firstNumber /= 10;
        }

        return firstNumber * 10 + lastNumber;
    }

    fun findOddSums(values: Array<Int>): Int {
        var total = 0;

        for (i in values.indices) {
            if (i % 2 != 0) {
                total += (values[i] * values[i]);
            }
        }

        return total;
    }

    fun getWeightInPlanets(): Unit {
//        get user weight
        print("Your weight in pound: ")
        val weightInPound = readln()!!.toInt()

//        get planet requested
        print(
            """
            1. Venus
            2. Mars
            3. Jupyter
            4. Saturn
            5. Uranus
            6. Neptune
            Your Choice : 
        """.trimIndent()
        )
        val planetChoice = readln()!!.toInt();

        val planetMap = hashMapOf<Int, String>();
        planetMap[1] = "Venus"
        planetMap[2] = "Mars"
        planetMap[3] = "Jupyter"
        planetMap[4] = "Saturn"
        planetMap[5] = "Uranus"
        planetMap[6] = "Neptune"
//        display the value
        var result: Double = 0.0;
        when (planetChoice) {
            1 -> result = weightInPound * 0.78
            2 -> result = weightInPound * 0.39
            3 -> result = weightInPound * 2.65
            4 -> result = weightInPound * 1.17
            5 -> result = weightInPound * 1.05
            6 -> result = weightInPound * 1.23
        }


        println("$weightInPound : pound on earth == $result pound in ${planetMap[planetChoice]}")
    }
}