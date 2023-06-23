fun main(){
    
	var number = 3
	var factnumber = factorial(number)
	println("The factorial number of $number is $factnumber")
    
    
    
    
    var calc = Calculator()
    var answer1 = calc.addition(5.0, 3.0)
    println("$answer1") 
    var answer2 = calc.subtraction(10.0, 4.0)
    println("$answer2")  
    var answer3 = calc.multiplication(2.5, 6.0)
    println("$answer3") 
    var answer4 = calc.division(20.0, 5.0)
    println("$answer4")  
    
    
    
    
    var word1 = "mac"
    var word2 = "radar"
    var word3 = "mum"
    println("${isPalindrome(word1)}") 
    println("${isPalindrome(word2)}") 
    println("${isPalindrome(word3)}") 
    
    
    
    
    var numbers = listOf(1,2,5,8,5,4,2)
    var sum = evenNumbers(numbers)
    println("addition of even numbers: $sum")
    
    
    
    
    val arr = intArrayOf(1,4,6,2,5,1,2,4)
    val result = findElements(arr)
    println("Single elements: ${result[0]} and ${result[1]}")
    
    
    
    var sentence = "the man is sitting!"
    var palindrome = checkPalindrome(sentence)
    println("Is the sentence palindrome?: $palindrome")
    
    
    
    var numbs = listOf(1,4,7,3,0,6,9)
    var res = largeAndSmallNumbers(numbs)
    val smallest = res[0]
    val largest = res[1]
    println("Small number is: $smallest")
    println("Large number is: $largest")
    
    
   var array = intArrayOf(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
   println(binarySearch(array, 21))
    
    
    
   var low = 1
   var input = 29
   while (low < input) {
      if (primeNumber(low))
         print(low.toString() + " ")
      ++low
   }

   
}



// 1. Write a Kotlin function to find the factorial of a given number.

fun factorial(n: Int): Long {
    return if (n == 0 || n == 1) {
        1
    } else {
        n * factorial(n - 1)
    }
}


// 2. Implement a Kotlin class that represents a simple calculator with addition, subtraction, multiplication, and division operations.

class Calculator() {
    fun addition(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    fun subtraction(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    fun multiplication(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    fun division(num1: Double, num2: Double): Double {
        return num1 / num2
    }
}


// 3. Write a Kotlin function to check if a given string is a palindrome.


fun isPalindrome(word: String): Boolean {
    var wordInput = word.lowercase().replace(" ", "")
    var length = wordInput.length

    for (i in 0 until length / 2) {
        if (wordInput[i] != wordInput[length - i - 1]) {
            return false
        }
    }

    return true
}


// 5. Write a Kotlin function that takes a list of integers and returns the sum of all even numbers

fun evenNumbers(nums: List<Int>): Int {
    var sum = 0

    for (num in nums) {
        if (num % 2 == 0) {
            sum += num
        }
    }

    return sum
}

//Section 3: Problem solving 
//1. Given an array of integers, write an algorithm to find the two elements that appear only once. 
//The array will always have exactly two elements that occur only once, while all other elements appear twice.


fun findElements(arrOfNum: IntArray): IntArray {
    val elements = mutableListOf<Int>()

    for (num in arrOfNum) {
        if (arrOfNum.count { it == num } == 1) {
            elements.add(num)
        }
    }

    return elements.toIntArray()
}

// 2. Write an algorithm to determine if a given string is a valid palindrome, ignoring non-alphanumeric characters 
// and considering case sensitivity.

fun checkPalindrome(str: String): Boolean {
    val string = str.filter { it.isLetterOrDigit() }.lowercase()
    return string == string.reversed()
}


//3. Given a list of numbers, write an algorithm to find the largest and smallest numbers in the list.

fun largeAndSmallNumbers(numbers: List<Int>): List<Int> {
    if (numbers.isEmpty()) {
        return listOf()
    }

    var smallest = Int.MAX_VALUE
    var largest = Int.MIN_VALUE

    for (num in numbers) {
        if (num < smallest) {
            smallest = num
        }
        if (num > largest) {
            largest = num
        }
    }

    return listOf(smallest, largest)
}

//4. Implement a function that accepts a sorted array of integers and a target value. 
// The function should return the index of the target value in the array, or -1 if it is not found.
// Use a binary search algorithm to solve this problem.

fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }

    // Item not found
    return -1
}

//5. Write a function that takes a positive integer as input and returns the number of prime numbers less than or equal to that input.

fun primeNumber(num: Int): Boolean {
    
   var prime = true
   for (i in 2..num / 2) {
      if (num % i == 0) {
         prime = false
         break
      }
   }
   return prime
}
