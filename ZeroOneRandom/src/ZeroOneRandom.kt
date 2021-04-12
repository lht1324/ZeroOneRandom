import kotlin.random.Random

fun main() {
    val maxNumber = 10

    /*
    확률 확인용 코드
    val array = Array(maxNumber) { 0 }

    for (i in 0 until 100) {
        val temp = getRandom(maxNumber)
        array[temp]++
    }

    for (i in array.indices)
        println("array[$i] = ${array[i]}")
    */

    println("getRandom($maxNumber) = ${getRandom(maxNumber)}")
}

/*
0부터 maxNumber - 1까지의 수를 나열했다 가정한 뒤 getZeroOrOne()의 출력값에 따라 왼쪽, 오른쪽을 선택하고
선택한 부분을 다시 왼쪽, 오른쪽으로 나눠 선택한 부분의 크기가 1이 될 때까지 반복한다.
getZeroOrOne()에서 0이 출력되면 왼쪽, 1이 출력되면 오른쪽을 선택한다.
ex)
maxNumber = 10
0, 1, 2, 3, 4 / 5, 6, 7, 8, 9 -> 오른쪽
5, 6 / 7, 8, 9 -> 왼쪽
5 / 6 - > 왼쪽
5
 */
fun getRandom(maxNumber: Int): Int {
    var start = 0
    var size = maxNumber

    // size가 홀수인데 왼쪽일 경우 start = start, size /= 2
    // size가 짝수인데 왼쪽일 경우 start = start, size /= 2
    // size가 홀수인데 오른쪽일 경우 start += size / 2, size = size / 2 + 1
    // size가 짝수인데 오른쪽일 경우 start += size / 2, size /= 2
    while(size > 1) {
        if (size % 2 == 1) { // size 홀수
            if (getZeroOrOne() == 0) // 왼쪽
                size /= 2

            else { // 오른쪽
                start += size / 2
                size = (size / 2) + 1
            }
        }
        else { // size 짝수
            if (getZeroOrOne() == 0) // 왼쪽
                size /= 2

            else { // 오른쪽
                start += size / 2
                size /= 2
            }
        }
    }
    return start
}

fun getZeroOrOne() = Random.nextInt(2)