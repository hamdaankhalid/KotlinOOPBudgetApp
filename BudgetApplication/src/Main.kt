import java.util.Scanner
import Budget

class Main{
    fun menu() {
        println("Your categories are food, clothing, and entertainment")
        println("To make deposits enter 1")
        println("To make withdraws enter 2")
        println("To make transfers enter 3")
        println("To get overall balance enter 4")
        println("To exit enter quit")
    }

    fun main() {
        val read = Scanner(System.`in`)
        // Take user input for budget
        println("Enter your budget: ")

        val budget = read.nextDouble()

        // Take user input for how much each category should be allocated

        println("Percentage allocated for food : ")

        val foodBudget = read.nextDouble()

        println("Percentage allocated for clothing : ")

        val clothingBudget = read.nextDouble()

        println("Percentage allocated for entertainment : ")

        val entertainmentBudget = read.nextDouble()

        val budgetOrganiser = Budget(budget, foodBudget, entertainmentBudget, clothingBudget)

        // This can be changed to better accomodate for DRY

        while (true) {
            println("*****************************************")
            menu()
            var userInput = read.nextLine()
            if (userInput == "quit") {
                break
            } else if (userInput == "1") {
                println(
                        "Enter food, clothing, or entertainment, and then a space and the amount to deposit e.g. clothing 5.00"
                )
                var userDepositInfo = read.nextLine()
                var category = userDepositInfo.split(" ")[0]
                var amount = userDepositInfo.split(" ")[1].toDouble()
                if (category == "food") {
                    budgetOrganiser.food.deposit(amount)
                } else if (category == "clothing") {
                    budgetOrganiser.clothing.deposit(amount)
                } else if (category == "entertainment") {
                    budgetOrganiser.entertainment.deposit(amount)
                } else {
                    println("Unknown category")
                }
            } else if (userInput == "2") {
                println(
                        "Enter food, clothing, or entertainment, and then a space and the amount to withdraw e.g. food 10.00"
                )
                var userWithdrawInfo = read.nextLine()
                var category = userWithdrawInfo.split(" ")[0]
                var amount = userWithdrawInfo.split(" ")[1].toDouble()
                if (category == "food") {
                    budgetOrganiser.food.withdraw(amount)
                } else if (category == "clothing") {
                    budgetOrganiser.clothing.withdraw(amount)
                } else if (category == "entertainment") {
                    budgetOrganiser.entertainment.withdraw(amount)
                } else {
                    println("Unknown category")
                }
            } else if (userInput == "3") {
                println(
                        "Enter the orginiating catrogry as food, clothing, or entertainment, then a space and the amount, and then the target category as food, clothing, or entertainment e.g. clothing 10.80 entertainment"
                )
                var userWithdrawInfo = read.nextLine()
                var category = userWithdrawInfo.split(" ")[0]
                var amount = userWithdrawInfo.split(" ")[1].toDouble()
                var toCategory = userWithdrawInfo.split(" ")[2]
                if (category == toCategory) {
                    println("Cant transfer from self to itself")
                } else if (category == "food") {
                    if (toCategory == "entertainment") {
                        budgetOrganiser.food.transfer(amount, budgetOrganiser.entertainment)
                    } else if (toCategory == "clothing") {
                        budgetOrganiser.food.transfer(amount, budgetOrganiser.clothing)
                    } else {
                        println("Unknown category")
                    }
                } else if (category == "clothing") {
                    if (toCategory == "entertainment") {
                        budgetOrganiser.clothing.transfer(amount, budgetOrganiser.entertainment)
                    } else if (toCategory == "food") {
                        budgetOrganiser.clothing.transfer(amount, budgetOrganiser.food)
                    } else {
                        println("Unknown category")
                    }
                } else if (category == "entertainment") {
                    if (toCategory == "clothing") {
                        budgetOrganiser.entertainment.transfer(amount, budgetOrganiser.clothing)
                    } else if (toCategory == "food") {
                        budgetOrganiser.entertainment.transfer(amount, budgetOrganiser.food)
                    } else {
                        println("Unknown category")
                    }
                } else {
                    println("Unknown category")
                }
            } else if(userInput == "4"){
                budgetOrganiser.overallBalance()
            } else if (userInput == "menu"){
                menu()
            } else {
                println("Couldnt  understand input")
                menu()
            }
            println("*****************************************")
        }
    }

}
