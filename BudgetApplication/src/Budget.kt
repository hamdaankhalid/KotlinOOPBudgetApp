import Category

class Budget(private var budget: Double,
             private var foodBudgetPercent: Double,
             private var entertainmentBudgetPercent: Double,
             private var clothingBudgetPercent: Double) {
    
    // The main class works to access these objects and use their functions to maniupluate data
    val food : Category
    val clothing : Category
    val entertainment : Category

    init {
        food = Category("Food", budget * foodBudgetPercent/100)
        clothing = Category("Clothing", budget * entertainmentBudgetPercent/100)
        entertainment = Category("Entertainment", budget * clothingBudgetPercent/100)
        println("Your budget was initalized with amount ${budget}")
    }

    fun getBudget(){
        println("Your total budget is ${budget}")
    }

    fun overallBalance(){
        var total = food.getBalance() + clothing.getBalance() + entertainment.getBalance()
        println("Remaining balance across all categories is ${total}")
    }

}