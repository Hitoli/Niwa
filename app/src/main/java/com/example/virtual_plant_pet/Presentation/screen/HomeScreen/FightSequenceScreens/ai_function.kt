//A simple TreeNode class
var game = Game()
class TreeNode(var value:IntArray){
    var left: TreeNode? =null
    var right:TreeNode? =null
}

class Game(){
    //Checking if the all the cards have been played or not
    var aiCardsArray: BooleanArray = booleanArrayOf(false, false, false)
    var userCardArray: BooleanArray = booleanArrayOf(false, false, false)

    //Calculating the value of the best move for the AI
    var aiCardPlayArray:IntArray= intArrayOf(0,0,100)
    var userCardPlayArray:IntArray= intArrayOf(0,0,100)

    //The cards in the hands of the AI
    var aiCardsInHand:IntArray= intArrayOf(15,5)
    var aiCardsInHand2:IntArray= intArrayOf(35,10)
    var aiCardsInHand3:IntArray= intArrayOf(50,15)
    var allAICards:Array<IntArray> = arrayOf(aiCardsInHand,aiCardsInHand2,aiCardsInHand3)

    //The cards in the hands of the player
    var userCardsInHand:IntArray= intArrayOf(35,10)
    var userCardsInHand2:IntArray= intArrayOf(50,15)
    var userCardsInHand3:IntArray= intArrayOf(65,20)
    var allUserCards:Array<IntArray> = arrayOf(userCardsInHand,userCardsInHand2,userCardsInHand3)
}

//Populating the root value of the tree
fun rootPopuolate(){
    var bestScore = Int.MIN_VALUE
    var bestMove:IntArray

    for (i in 0..2) {
        if(!game.aiCardsArray[i]){
            var root = TreeNode(game.allAICards[i])
            var score = minimax(root,0,false)
            if(bestScore<score){
                bestScore = score
                bestMove = root.value
            }

        }
    }

}
fun checkWinner():Int{

    return if (game.aiCardPlayArray[2]<=0){
        -1
    }else if(game.userCardPlayArray[2]<=0){
        1
    }else{
        0
    }
}

fun minimax(node:TreeNode,depth:Int,isMaximizing:Boolean):Int{
    var result = checkWinner()
    if (game.aiCardPlayArray[2]==0||game.userCardPlayArray[2]==0){
        return 0
    }


}