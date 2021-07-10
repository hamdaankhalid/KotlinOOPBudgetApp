class Category(private val name: String, private var balance: Double) {

    init {
        println("Category of name ${name} with balance ${balance} created")
    }

    fun getName(): String{
        return name
    }

    fun getBalance(): Double{
        return balance
    }

    fun withdraw(amount: Double){
        if(amount > balance){
            println("Cannot withdraw more than balance.")
        } else if (amount < 0){
            println("Cannot withdraw a negative amount.")
        } else {
            withdrawLogic(amount)
            println("Your amount of ${amount} was withdrawn successfully, you have $${balance} left in your account")
        }
    }

    fun deposit(amount: Double){
        if(amount < 0){
            println("Cannot deposit amount below 0.")
        }else{
            depositLogic(amount)
            println("Your amount was deposited, and your balance is now ${balance}")
        }
    }

    fun transfer(amount: Double, toCategory: Category){
        if (amount < 0){
            println("Cannot transfer negative amount")
        } else if (amount > balance) {
            println("Your requested amount is more than your curret balance")
        } else {
            withdrawLogic(amount)
            toCategory.depositLogic(amount)
            println("Deposited ${amount} into ${toCategory.getName()}")
        }
    }

    protected fun depositLogic(amount: Double) {
        balance = balance + amount
    }

    protected fun withdrawLogic(amount: Double) {
        balance = balance - amount
    }

}
